package com.example.gpgpBack.sizes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "sizes")
public class Sizes {
    

     @Id
    @SequenceGenerator(
            name = "sizes_seq",
            sequenceName = "sizes_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sizes_seq"
    )

    private String item_Type;
    private String item_Size;
    private double added_Cost;


    public Sizes() {
    }

    public Sizes(String item_Type, String item_Size, double added_Cost) {
        this.item_Type = item_Type;
        this.item_Size = item_Size;
        this.added_Cost = added_Cost;
    }

    public String getItemType() {
        return this.item_Type;
    }

    public void setItemType(String item_Type) {
        this.item_Type = item_Type;
    }

    public String getItemSize() {
        return this.item_Size;
    }

    public void setItemSize(String item_Size) {
        this.item_Size = item_Size;
    }

    public double getAddedCost() {
        return this.added_Cost;
    }

    public void setAddedCost(double added_Cost) {
        this.added_Cost = added_Cost;
    }

}
