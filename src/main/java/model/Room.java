package model;

import javax.persistence.*;

//create table
@Entity
public class Room {

    //create columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId")
    private int roomId;

    @Column(name = "availability")
    private int availability;

    @Column(name = "price")
    private int price;

    //foreign keys
    @ManyToOne
    @JoinColumn(name="guestHouseId")
    private GuestHouse guestHouse;

    @OneToOne
    @JoinColumn(name="roomTypeId")
    private RoomType roomType;

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



    //to string method

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", availability=" + availability +
                ", price=" + price +
                ", guestHouse=" + guestHouse +
                ", roomType=" + roomType +
                '}';
    }
}
