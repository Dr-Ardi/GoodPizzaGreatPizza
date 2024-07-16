package com.example.gpgpBack.added;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@DataJpaTest
public class AddedRepositoryTest {

    @Autowired
    private AddedRepository testAddedRep;

    @AfterEach
    void tearDown(){
        testAddedRep.deleteAll();
    }

    @Test
    public void testGetAllTypes() {
        // Given
        Added added1 = new Added("Type 1", "Item 1", 10.0);
        testAddedRep.save(added1);

        Added added2 = new Added("Type 2", "Item 2", 15.0);
        testAddedRep.save(added2);

        // When
        List<String> types = testAddedRep.getAllTypes();

        // Then
        assertThat(types).containsExactlyInAnyOrder("Type 1", "Type 2");
    }

    @Test
    public void testGetAdditionsByType() {
        // Given
        Added added1 = new Added("Type 1", "Item 1", 10.0);
        testAddedRep.save(added1);

        Added added2 = new Added("Type 1", "Item 2", 15.0);
        testAddedRep.save(added2);

        // When
        List<Added> additions = testAddedRep.getAdditionsByType("Type 1");

        // Then
        assertThat(additions).hasSize(2);
        assertThat(additions).extracting(Added::getAdded_Item).containsExactlyInAnyOrder("Item 1", "Item 2");
    }
}
