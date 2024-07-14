package com.example.gpgpBack.ingredients;

import org.junit.jupiter.api.AfterEach;
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

}
