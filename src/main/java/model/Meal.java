package model;

import javax.persistence.*;

//create table
@Entity
public class Meal {

    //create columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mealId")
    private int mealId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

    //foreign keys
    @ManyToOne
    @JoinColumn(name="mealTypeId")
    private MealType mealType;

    @ManyToOne
    @JoinColumn(name="guestHouseId")
    private GuestHouse guestHouse;


    //getters and setters
    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //to string method
    @Override
    public String toString() {
        return "meal{" +
                "mealId=" + mealId +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
