package persistence;

import model.*;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class RepositoryBooking {

    private EntityManager em;

    public RepositoryBooking() {
        em = DBUtil.getEntityManager();
    }

    //method save booking
    public void saveBooking(Booking booking){
        try {
            em.getTransaction().begin();
            this.em.persist(booking);
            em.getTransaction().commit();

        }catch (Exception ex){
            em.getTransaction().rollback();
        }
    }

    //method count all bookings by date
    public List<CountBooking> bookingsByDate (){
        String sql = "SELECT new model.CountBooking(arrivalDate, " +
                " COUNT(*))" +
                " FROM Booking" +
                " GROUP BY arrivalDate";
        return em.createQuery(sql, CountBooking.class).getResultList();

    }

    //list all bookings in one date you receive from user
    public List<ShowBookingsOnADate> bookingsOnADate (String enteredDate){
        try {
            String sql = "SELECT new model.ShowBookingsOnADate(b.bookingId, b.customer.name," +
                    " b.room.name, b.meal.name)" +
                    " FROM Booking b" +
                   " WHERE b.arrivalDate= :enteredDate";

            return em.createQuery(sql, ShowBookingsOnADate.class)
                    .setParameter("enteredDate", enteredDate)
                    .getResultList();
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //list all bookings for one room
    public List<ShowBookingsOfARoom> bookingsOfARoom (int enteredRoomId){
        try {
            String sql = "SELECT new model.ShowBookingsOfARoom(b.room.roomId, b.room.name," +
                    " b.arrivalDate, b.bookingId, b.customer.name)" +
                    " FROM Booking b" +
                    " WHERE b.room.roomId= :enteredRoomId" +
                    " ORDER BY b.arrivalDate ASC";

            return em.createQuery(sql, ShowBookingsOfARoom.class)
                    .setParameter("enteredRoomId", enteredRoomId)
                    .getResultList();
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
