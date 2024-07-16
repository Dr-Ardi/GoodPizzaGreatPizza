package com.example.gpgpBack.ingredients;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.gpgpBack.item.Item;
import com.example.gpgpBack.item.ItemRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class IngredServiceTest {

    @Mock private IngredRepository testIngredRep;
    @Mock private ItemRepository testItemRep;
    private IngredService testIngredService;

    @BeforeEach
    void setUp(){
        testIngredService = new IngredService(testIngredRep, testItemRep);
    }

    @Test
    void testFindIngreItemsById_Found() {
        Ingredient sampleIngredient = new Ingredient(1L, 1, "Salt");
        when(testIngredRep.checkId(1L)).thenReturn(1L);
        when(testIngredRep.findIngreItemsById(1L)).thenReturn(List.of(sampleIngredient));

        List<Ingredient> ingredients = testIngredService.findIngreItemsById(1L);

        assertThat(ingredients).isNotEmpty();
        assertThat(ingredients.get(0).getItem_Id()).isEqualTo(1L);
        verify(testIngredRep).checkId(1L);
        verify(testIngredRep).findIngreItemsById(1L);
    }

    @Test
    @Disabled
    void testFindIngreItemsById_NotFound() {
        when(testIngredRep.checkId(1L)).thenReturn(null);

        List<Ingredient> ingredients = testIngredService.findIngreItemsById(1L);

        assertThat(ingredients).isEqualTo(List.of(new Ingredient( 1, "ingred")));
        verify(testIngredRep).checkId(1L);
        verify(testIngredRep, never()).findIngreItemsById(1L);
    }

    @Test
    void testGetDescription_SimpleItem() {
        when(testItemRep.getItemById(1L)).thenReturn(new Item(1L, "Soft Drink", "Apple juice", 1, 1.0));

        List<String> description = testIngredService.getDescription(1L);

        assertThat(description).containsExactly("An apple juice.");
        verify(testItemRep).getItemById(1L);
    }

    @Test
    void testGetDescription_ComplexItem() {
        when(testItemRep.getItemById(1L)).thenReturn(new Item(1L, "Pizza", "Test Item", 1, 1.0));
        when(testIngredRep.getIngredients(1L)).thenReturn(List.of("Cheese", "Tomato"));

        List<String> description = testIngredService.getDescription(1L);

        assertThat(description).containsExactly("A pizza with cheese and tomato.");
        verify(testItemRep).getItemById(1L);
        verify(testIngredRep).getIngredients(1L);
    }
}
