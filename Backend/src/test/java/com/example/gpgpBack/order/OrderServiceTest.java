package com.example.gpgpBack.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock private OrderRepository testOrderRep;
    private OrderService testOrderService;

    @BeforeEach
    void setUp(){
        testOrderService = new OrderService(testOrderRep);
    }
}
