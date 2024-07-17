package com.example.gpgpBack.ingredients;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    // @SequenceGenerator(
    //     name="ingred_seq",
    //     sequenceName = "ingred_seq",
    //     allocationSize = 1
    // )
    // @GeneratedValue(
    //     strategy = GenerationType.SEQUENCE,
    //     generator = "ingred_seq"
    // )

    private Long id;
    private int item_Id;
    private String ingredient_Name;


    public Ingredient() {
    }

    public Ingredient(int item_Id, String ingredient_Name) {
        this.item_Id = item_Id;
        this.ingredient_Name = ingredient_Name;
    }

    public Ingredient(Long id, int item_Id, String ingredient_Name) {
        this.id = id;
        this.item_Id = item_Id;
        this.ingredient_Name = ingredient_Name;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getItem_Id() {
        return this.item_Id;
    }

    public void setItem_Id(int item_Id) {
        this.item_Id = item_Id;
    }

    public String getIngredient_Name() {
        return this.ingredient_Name;
    }

    public void setIngredient_Name(String ingredient_Name) {
        this.ingredient_Name = ingredient_Name;
    }

}
