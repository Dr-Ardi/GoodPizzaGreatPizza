package com.example.gpgpBack.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @Mock private ItemRepository testItemRep;
    private ItemService testItemService;

    @BeforeEach
    void setUp(){
        testItemService = new ItemService(testItemRep);
    }

    @Test
    void testGetAllItems() {
        Item sampleItem = new Item(1L, "Food", "Pizza", 2, 12.99);
        when(testItemRep.findAll()).thenReturn(List.of(sampleItem));

        List<Item> items = testItemService.getAllItems();

        assertThat(items).isNotEmpty();
        assertThat(items.get(0).getId()).isEqualTo(1L);
        verify(testItemRep).findAll();
    }

    @Test
    @Disabled
    void testGetEachType() {
        List<String> types = Arrays.asList("Soft Drink", "Pizza", "Water");
        when(testItemRep.getEachType()).thenReturn(types);

        List<String> sortedTypes = testItemService.getEachType();

        assertThat(sortedTypes).containsExactly("Pizza", "Soft Drink", "Water");
        verify(testItemRep).getEachType();
    }

    @Test
    void testGetItemById_Found() {
        Item sampleItem = new Item(1L, "Food", "Pizza", 2, 12.99);
        when(testItemRep.checkId(1L)).thenReturn(1L);
        when(testItemRep.getItemById(1L)).thenReturn(sampleItem);

        Item item = testItemService.getItemById(1L);

        assertThat(item).isNotNull();
        assertThat(item.getId()).isEqualTo(1L);
        verify(testItemRep).checkId(1L);
        verify(testItemRep).getItemById(1L);
    }

    @Test
    void testGetItemById_NotFound() {
        when(testItemRep.checkId(1L)).thenReturn(null);

        Item item = testItemService.getItemById(1L);

        assertThat(item).isNotNull();
        assertThat(item.getName()).isEqualTo("name");
        verify(testItemRep).checkId(1L);
        verify(testItemRep, never()).getItemById(1L);
    }

    @Test
    void testGetItemsByType() {
        Item sampleItem = new Item(1L, "Food", "Pizza", 2, 12.99);
        when(testItemRep.getItemsByType("Food")).thenReturn(List.of(sampleItem));

        List<Item> items = testItemService.getItemsByType("Food");

        assertThat(items).isNotEmpty();
        assertThat(items.get(0).getType()).isEqualTo("Food");
        verify(testItemRep).getItemsByType("Food");
    }

    @Test
    void testGetItemByName_Found() {
        Item sampleItem = new Item(1L, "Food", "Pizza", 2, 12.99);
        when(testItemRep.checkName("Pizza")).thenReturn("Pizza");
        when(testItemRep.getItemByName("Pizza")).thenReturn(sampleItem);

        Item item = testItemService.getItemByName("Pizza");

        assertThat(item).isNotNull();
        assertThat(item.getName()).isEqualTo("Pizza");
        verify(testItemRep).checkName("Pizza");
        verify(testItemRep).getItemByName("Pizza");
    }

    @Test
    void testGetItemByName_NotFound() {
        when(testItemRep.checkName("Pizza")).thenReturn(null);

        Item item = testItemService.getItemByName("Pizza");

        assertThat(item).isNotNull();
        assertThat(item.getName()).isEqualTo("name");
        verify(testItemRep).checkName("Pizza");
        verify(testItemRep, never()).getItemByName("Pizza");
    }
}
