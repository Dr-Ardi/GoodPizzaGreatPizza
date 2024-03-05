package com.example.gpgpBack.added;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="added")
public class Added {
    @Id
    @SequenceGenerator(
        name="added_seq",
        sequenceName = "added_seq",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "added_seq"
    )

    private Long id;
    private String add_Type;
    private String added_Item;
    private double added_Price;
    

    public Added() {
    }


    public Added(Long id, String add_Type, String added_Item, double added_Price) {
        this.id = id;
        this.add_Type = add_Type;
        this.added_Item = added_Item;
        this.added_Price = added_Price;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    


    public String getAdd_Type() {
        return this.add_Type;
    }

    public void setAdd_Type(String add_Type) {
        this.add_Type = add_Type;
    }

    public String getAdded_Item() {
        return this.added_Item;
    }

    public void setAdded_Item(String added_Item) {
        this.added_Item = added_Item;
    }

    public double getAdded_Price() {
        return this.added_Price;
    }

    public void setAdded_Price(double added_Price) {
        this.added_Price = added_Price;
    }


}
