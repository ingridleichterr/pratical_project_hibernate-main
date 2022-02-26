package model;


import javax.persistence.*;

//creating table
@Entity
public class RoomType {

    //creating columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomTypeId")
    private int roomTypeId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private int quantity;

    //getters and setters
    public int getRoomTypeId() {return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {this.roomTypeId = roomTypeId;
    }

    public String getName() {return name;
    }

    public void setName(String name) {this.name = name;
    }

    public String getDescription() {return description;
    }

    public void setDescription(String description) {this.description = description;
    }

    public int getQuantity() {return quantity;
    }

    public void setQuantity(int quantity) {this.quantity = quantity;
    }

    //to string method

    @Override
    public String toString() {
        return "RoomType{" +
                "roomTypeId=" + roomTypeId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
