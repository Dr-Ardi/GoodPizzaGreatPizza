package com.example.gpgpBack.ingredients;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredRepository extends JpaRepository<Ingredient, Long>  {
    @Query("SELECT i.ingredient_Name FROM Ingredient i WHERE item_Id = ?1")
    List<String> findIngreItemsById(Long item_Id);

}
