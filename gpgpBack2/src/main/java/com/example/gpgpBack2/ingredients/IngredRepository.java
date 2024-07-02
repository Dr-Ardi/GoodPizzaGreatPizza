package com.example.gpgpBack2.ingredients;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredRepository extends JpaRepository<Ingredient, Long>  {

    @Query("SELECT i.item_Id FROM Ingredient i WHERE i.item_Id = ?1")
    Long checkId(Long item_Id);

    @Query("SELECT i FROM Ingredient i WHERE i.item_Id = ?1")
    List<Ingredient> findIngreItemsById(Long item_Id);

    @Query("SELECT i.ingredient_Name FROM Ingredient i WHERE i.item_Id = ?1")
    List<String> getIngredients(Long item_Id);

}
