package com.example.gpgpBack2.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="restaurant_Tables")
public class Tables {
    
    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )


    private Long table_Number;
    private boolean occupied;
    private boolean waiter_Called;
    private boolean finished;
    private String payment ;
    

    public Tables() {
    }

    public Tables(Long table_Number, boolean occupied, boolean waiter_Called, boolean finished, String payment) {
        this.table_Number = table_Number;
        this.occupied = occupied;
        this.waiter_Called = waiter_Called;
        this.finished = finished;
        this.payment = payment;
    }

    public Long getTable_Number() {
        return this.table_Number;
    }

    public void setTable_Number(Long table_Number) {
        this.table_Number = table_Number;
    }

    public boolean isOccupied() {
        return this.occupied;
    }

    public boolean getOccupied() {
        return this.occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isWaiter_Called() {
        return this.waiter_Called;
    }

    public boolean getWaiter_Called() {
        return this.waiter_Called;
    }

    public void setWaiter_Called(boolean waiter_Called) {
        this.waiter_Called = waiter_Called;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public boolean getFinished() {
        return this.finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getPayment() {
        return this.payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }


}
