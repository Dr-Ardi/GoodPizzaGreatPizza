package com.example.gpgpBack.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository testItemRep;

    @AfterEach
    void tearDown(){
        testItemRep.deleteAll();
    }

    @Test
    public void testCheckId() {
        Item item = new Item("Test Type", "Test Item", 1, 1.0);
        testItemRep.save(item);

        Long id = testItemRep.checkId(item.getId());
        assertThat(id).isEqualTo(item.getId());
    }

    @Test
    public void testCheckName() {
        Item item = new Item("Test Type", "Test Item", 1, 1.0);
        testItemRep.save(item);

        String name = testItemRep.checkName("Test Item");
        assertThat(name).isEqualTo("Test Item");
    }

    @Test
    public void testGetEachType() {
        Item item1 = new Item("Type 1", "Test Item1", 1, 1.0);
        testItemRep.save(item1);

        Item item2 = new Item("Type 2", "Test Item2", 1, 1.0);
        testItemRep.save(item2);

        List<String> types = testItemRep.getEachType();
        assertThat(types).containsExactlyInAnyOrder("Type 1", "Type 2");
    }

    @Test
    public void testGetItemById() {
        Item item = new Item("Test Type", "Test Item", 1, 1.0);
        testItemRep.save(item);

        Item fetchedItem = testItemRep.getItemById(item.getId());
        assertThat(fetchedItem).isEqualTo(item);
    }

    @Test
    public void testGetItemsByType() {
        Item item1 = new Item("Test Type", "Test Item 1", 1, 1.0);
        testItemRep.save(item1);

        Item item2 = new Item("Test Type", "Test Item 2", 1, 1.0);
        testItemRep.save(item2);

        List<Item> items = testItemRep.getItemsByType("Test Type");
        assertThat(items).containsExactlyInAnyOrder(item1, item2);
    }

    @Test
    public void testGetItemByName() {
        Item item = new Item("Test Type", "Test Item", 1, 1.0);
        testItemRep.save(item);

        Item fetchedItem = testItemRep.getItemByName("Test Item");
        assertThat(fetchedItem).isEqualTo(item);
    }
}

