package com.example.gpgpBack.tables;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@DataJpaTest
public class TablesRepositoryTest {

    @Autowired
    private TablesRepository testTablesRep;

    @AfterEach
    void tearDown(){
        testTablesRep.deleteAll();
    }

}

