package com.example.gpgpBack2.sizes;

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
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )


    private Long id;
    private String item_Type;
    private String item_Size;
    private double added_Cost;


    public Sizes() {
    }

    public Sizes(Long id, String item_Type, String item_Size, double added_Cost) {
        this.id = id;
        this.item_Type = item_Type;
        this.item_Size = item_Size;
        this.added_Cost = added_Cost;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem_Type() {
        return this.item_Type;
    }

    public void setItem_Type(String item_Type) {
        this.item_Type = item_Type;
    }

    public String getItem_Size() {
        return this.item_Size;
    }

    public void setItem_Size(String item_Size) {
        this.item_Size = item_Size;
    }

    public double getAdded_Cost() {
        return this.added_Cost;
    }

    public void setAdded_Cost(double added_Cost) {
        this.added_Cost = added_Cost;
    }
    

}
