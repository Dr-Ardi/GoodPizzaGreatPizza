package com.example.gpgpBack.ingredients;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class IngredRepositoryTest {

    @Autowired
    private IngredRepository testIngredRep;

    @AfterEach
    void tearDown(){
        testIngredRep.deleteAll();
    }

    @BeforeEach
    void setUp() {
        Ingredient ingredient = new Ingredient(1, "Test");
        testIngredRep.save(ingredient);
    }

    @Test
    public void testCheckId() {
        Long foundId = testIngredRep.checkId(1L);
        assertThat(foundId).isEqualTo(1L);
    }

    @Test
    public void testFindIngreItemsById() {
        List<Ingredient> ingredients = testIngredRep.findIngreItemsById(1L);
        assertThat(ingredients).isNotEmpty();
        assertThat(ingredients.get(0).getItem_Id()).isEqualTo(1L);
    }

    @Test
    public void testGetIngredients() {
        List<String> ingredientNames = testIngredRep.getIngredients(1L);
        assertThat(ingredientNames).contains("Test");
    }

}
