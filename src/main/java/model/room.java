package model;

import javax.persistence.*;

//create table
@Entity
public class room {

    //create columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId")
    private int roomId;

    @Column(name = "availability")
    private int availability;

    @Column(name = "price")
    private int price;

    @Column(name = "quantity")
    private int quantity;

    //foreign keys
    @ManyToOne
    @JoinColumn(name="guestHouseId")
    private guestHouse guestHouse;

    @OneToOne
    @JoinColumn(name="roomTypeId")
    private roomType roomType;

    //getters and setters
    public int getRoomId() {return roomId;
    }

    public void setRoomId(int roomId) {this.roomId = roomId;
    }

    public int getAvailability() {return availability;
    }

    public void setAvailability(int availability) {this.availability = availability;
    }

    public int getPrice() {return price;
    }

    public void setPrice(int price) {this.price = price;
    }

    public int getQuantity() {return quantity;
    }

    public void setQuantity(int quantity) {this.quantity = quantity;
    }

    //to string method
    @Override
    public String toString() {
        return "room{" +
                "roomId=" + roomId +
                ", availability=" + availability +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
