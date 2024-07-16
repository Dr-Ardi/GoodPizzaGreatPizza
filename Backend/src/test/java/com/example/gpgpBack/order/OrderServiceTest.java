package com.example.gpgpBack.order;

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

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock private OrderRepository testOrderRep;
    private OrderService testOrderService;

    @BeforeEach
    void setUp(){
        testOrderService = new OrderService(testOrderRep);
    }

    @Test
    void testGetTableOrders_Found() {
        Order sampleOrder1 = new Order(1, 1, "test", "test", "test", "test", 1, true, 14.0, "test");
        Order sampleOrder2 = new Order(2, 2, "test", "test", "test", "test", 1, true, 11.0, "test");
        when(testOrderRep.checkTable(1L)).thenReturn(1L);
        when(testOrderRep.getTableOrders(1L)).thenReturn(List.of(sampleOrder1, sampleOrder2));

        List<Order> orders = testOrderService.getTableOrders(1L);

        assertThat(orders).hasSize(2);
        verify(testOrderRep).checkTable(1L);
        verify(testOrderRep).getTableOrders(1L);
    }

    @Test
    void testGetTableOrders_NotFound() {
        when(testOrderRep.checkTable(1L)).thenReturn(null);

        List<Order> orders = testOrderService.getTableOrders(1L);

        assertThat(orders).hasSize(1);
        verify(testOrderRep).checkTable(1L);
        verify(testOrderRep, never()).getTableOrders(1L);
    }

    @Test
    void testAddToOrder() {
        Order sampleOrder1 = new Order(1, 1, "test", "test", "test", "test", 1, true, 14.0, "test");
        testOrderService.addToOrder(sampleOrder1);

        verify(testOrderRep).save(sampleOrder1);
    }

    @Test
    void testCompleteOrder() {
        Order sampleOrder1 = new Order(1, 1, "test", "test", "test", "test", 1, true, 14.0, "test");
        Order sampleOrder2 = new Order(2, 2, "test", "test", "test", "test", 1, true, 11.0, "test");
        sampleOrder1.setOrdered(false);
        sampleOrder2.setOrdered(false);

        when(testOrderRep.getTableOrders(1L)).thenReturn(List.of(sampleOrder1, sampleOrder2));

        testOrderService.completeOrder(1L);

        assertThat(sampleOrder1.isOrdered()).isTrue();
        assertThat(sampleOrder2.isOrdered()).isTrue();
        verify(testOrderRep).getTableOrders(1L);
    }

    @Test
    void testGetFinalPrice_Found() {
        when(testOrderRep.checkTable(1L)).thenReturn(1L);
        when(testOrderRep.getFinalPrice(1L)).thenReturn(25.0);

        double finalPrice = testOrderService.getFinalPrice(1L);

        assertThat(finalPrice).isEqualTo(25.0);
        verify(testOrderRep).checkTable(1L);
        verify(testOrderRep).getFinalPrice(1L);
    }

    @Test
    void testGetFinalPrice_NotFound() {
        when(testOrderRep.checkTable(1L)).thenReturn(null);

        double finalPrice = testOrderService.getFinalPrice(1L);

        assertThat(finalPrice).isEqualTo(0.0);
        verify(testOrderRep).checkTable(1L);
        verify(testOrderRep, never()).getFinalPrice(1L);
    }

    @Test
    @Disabled
    void testDeleteTableOrder() {
        Order sampleOrder1 = new Order(1, 1, "test", "test", "test", "test", 1, true, 14.0, "test");
        Order sampleOrder2 = new Order(2, 2, "test", "test", "test", "test", 1, true, 11.0, "test");
        when(testOrderRep.getTableOrders(1L)).thenReturn(List.of(sampleOrder1, sampleOrder2));

        testOrderService.deleteTableOrder(1L);

        verify(testOrderRep).getTableOrders(1L);
        verify(testOrderRep).deleteById(1L);
        verify(testOrderRep).deleteById(2L);
    }
}
