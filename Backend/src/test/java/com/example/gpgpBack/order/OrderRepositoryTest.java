package com.example.gpgpBack.order;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    void setUp(){
        testOrderRep.save(new Order( 1, 1, "test", "test", "test", "test", 1, true, 14.0, "test"));
        testOrderRep.save(new Order(1, 2, "test", "test", "test", "test", 1, true, 11.0, "test"));
    }

    @Test
    void testCheckTable() {
        Long tableNumber = testOrderRep.checkTable(1L);
        assertThat(tableNumber).isEqualTo(1L);
    }

    @Test
    void testGetTableOrders() {
        List<Order> orders = testOrderRep.getTableOrders(1L);
        assertThat(orders).hasSize(2);
        assertThat(orders.get(0).getPriority()).isEqualTo(1);
        assertThat(orders.get(1).getPriority()).isEqualTo(2);
    }

    @Test
    void testGetFinalPrice() {
        double totalCost = testOrderRep.getFinalPrice(1L);
        assertThat(totalCost).isEqualTo(25.0);
    }

}

