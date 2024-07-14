package com.example.gpgpBack.addables;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@DataJpaTest
public class AddablesRepositoryTest {
    @Autowired
    private AddablesRepository testAddablesRep;

    @AfterEach
    void tearDown(){
        testAddablesRep.deleteAll();
    }

    @Test
    public void testGetAddablesByType() {
        Addables addable = new Addables("Type 1", false, false, false, false, false, false);
        testAddablesRep.save(addable);

        Addables result = testAddablesRep.getAddablesByType("Type 1");
        assertThat(result).isNotNull();
        assertThat(result.getItem_Type()).isEqualTo("Type 1");
        assertThat(result.getSizable()).isFalse();
        assertThat(result.getMeats()).isFalse();
        assertThat(result.getCheeses()).isFalse();
        assertThat(result.getSauces()).isFalse();
        assertThat(result.getRemovables()).isFalse();
        assertThat(result.getExtras()).isFalse();
    }

    @Test
    public void testGetAllTypes() {
        Addables addable1 = new Addables("Type 1", false, false, false, false, false, false);
        testAddablesRep.save(addable1);

        Addables addable2 = new Addables("Type 2", false, false, false, false, false, false);
        testAddablesRep.save(addable2);

        List<String> types = testAddablesRep.getAllTypes();
        assertThat(types).containsExactlyInAnyOrder("Type 1", "Type 2");
    }
}
