package model;

import javax.persistence.*;

//creating table
@Entity
public class GuestHouse {

    //creating columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guestHouseId")
    private int bookingId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    //getters and setters
    public int getBookingId() {return bookingId;
    }

    public void setBookingId(int bookingId) {this.bookingId = bookingId;
    }

    public String getName() {return name;
    }

    public void setName(String name) {this.name = name;
    }

    public String getAddress() {return address;
    }

    public void setAddress(String address) {this.address = address;
    }

    public String getPhoneNumber() {return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;
    }

    //to string method
    @Override
    public String toString() {
        return "guestHouse{" +
                "bookingId=" + bookingId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
