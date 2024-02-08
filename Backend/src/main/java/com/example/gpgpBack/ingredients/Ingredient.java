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
    @SequenceGenerator(
        name="ingred_seq",
        sequenceName = "ingred_seq",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "ingred_seq"
    )

    private Long item_Id;
    private String ingredient_Name;


    public Ingredient() {
    }

    public Ingredient(Long item_Id, String ingredient_Name) {
        this.item_Id = item_Id;
        this.ingredient_Name = ingredient_Name;
    }

    public Long getItemId() {
        return this.item_Id;
    }

    public void setItemId(Long item_Id) {
        this.item_Id = item_Id;
    }

    public String getIngredientName() {
        return this.ingredient_Name;
    }

    public void setIngredientName(String ingredient_Name) {
        this.ingredient_Name = ingredient_Name;
    }

}
