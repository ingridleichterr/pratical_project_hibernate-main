package persistence;

import model.Booking;
import model.CountBooking;
import model.Customer;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

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

    //method count all bookings by date - NOT WORKING
    public List<CountBooking> bookingsByDate (){
        String sql = "SELECT new model.CountBooking(arrivalDate, " +
                " COUNT(*))" +
                " FROM Booking" +
                " GROUP BY arrivalDate";
        return em.createQuery(sql, CountBooking.class).getResultList();

    }

}
