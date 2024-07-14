package com.example.gpgpBack.order;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository testOrderRep;

    @AfterEach
    void tearDown(){
        testOrderRep.deleteAll();
    }

}

