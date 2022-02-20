package model;

import javax.persistence.*;
import java.util.Date;

//creating table
@Entity
public class Booking {

    //creating columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingId")
    private int bookingId;

    @Column(name = "numberOfPeople")
    private int numberOfPeople;

    @Column(name = "arrivalDate")
    private Date arrivalDate;

    @Column(name = "leavingDate")
    private Date leavingDate;

    @Column(name = "bookerName")
    private String bookerName;

    @Column(name = "bookerEmail")
    private String bookerEmail;

    @Column(name = "bookerPhoneNumber")
    private String bookerPhoneNumber;

    //foreign keys
    @OneToOne
    @JoinColumn(name="bookingPaymentId")
    private BookingPayment bookingPaymentId;

    @ManyToOne
    @JoinColumn(name="roomId")
    private Room room;

    @ManyToOne
    @JoinColumn(name="customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="mealId")
    private Meal meal;

    //getters and setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {this.arrivalDate = arrivalDate;}

    public Date getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(Date leavingDate) {this.leavingDate = leavingDate;}

    public String getBookerName() {
        return bookerName;
    }

    public void setBookerName(String bookerName) {
        this.bookerName = bookerName;
    }

    public String getBookerEmail() {return bookerEmail;}

    public void setBookerEmail(String bookerEmail) {
        this.bookerEmail = bookerEmail;
    }

    public String getBookerPhoneNumber() {
        return bookerPhoneNumber;
    }

    public void setBookerPhoneNumber(String bookerPhoneNumber) {
        this.bookerPhoneNumber = bookerPhoneNumber;
    }

    //to string method
    @Override
    public String toString() {
        return "booking{" +
                "bookingId=" + bookingId +
                ", numberOfPeople=" + numberOfPeople +
                ", arrivalDate=" + arrivalDate +
                ", leavingDate=" + leavingDate +
                ", bookerName='" + bookerName + '\'' +
                ", bookerEmail='" + bookerEmail + '\'' +
                ", bookerPhoneNumber='" + bookerPhoneNumber + '\'' +
                '}';
    }
}
