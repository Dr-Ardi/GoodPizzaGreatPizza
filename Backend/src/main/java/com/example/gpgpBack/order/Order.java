package com.example.gpgpBack.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
    
    @Id
    @SequenceGenerator(
        name="order_seq",
        sequenceName = "order_seq",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "order_seq"
    )
    
    private Long id;
    private int table_Number;
    private int priority;
    private String item_Name;
    private String extra;
    private String included;
    private String excluded;
    private int quantity;
    private boolean ordered;
    private double order_Cost;
    private String size;

    public Order() {
    }

    public Order(Long id, int table_Number, int priority, String item_Name, String extra, String included, String excluded, int quantity, boolean ordered, double order_Cost, String size) {
        this.table_Number = table_Number;
        this.priority = priority;
        this.item_Name = item_Name;
        this.extra = extra;
        this.included = included;
        this.excluded = excluded;
        this.quantity = quantity;
        this.ordered = ordered;
        this.order_Cost = order_Cost;
        this.size = size;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTable_Number() {
        return this.table_Number;
    }

    public void setTable_Number(int table_Number) {
        this.table_Number = table_Number;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getItem_Name() {
        return this.item_Name;
    }

    public void setItem_Name(String item_Name) {
        this.item_Name = item_Name;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getExcluded() {
        return this.excluded;
    }

    public void setExcluded(String excluded) {
        this.excluded = excluded;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isOrdered() {
        return this.ordered;
    }

    public boolean getOrdered() {
        return this.ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public double getOrder_Cost() {
        return this.order_Cost;
    }

    public void setOrder_Cost(double order_Cost) {
        this.order_Cost = order_Cost;
    }


    public String getIncluded() {
        return this.included;
    }

    public void setIncluded(String included) {
        this.included = included;
    }


    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }


    
}
