package model;

import java.util.Date;

public class CountBooking {

    private long count;
    private Date arrivalDate;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public CountBooking(Date arrivalDate, long count) {
        this.arrivalDate = arrivalDate;
        this.count = count;

    }

    @Override
    public String toString() {
        return "CountBooking{" +
                "count=" + count +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}
