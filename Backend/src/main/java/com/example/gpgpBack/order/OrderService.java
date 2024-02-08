package com.example.gpgpBack.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public void addToOrder(Order order){
        orderRepository.save(order);
    }

    public List<Order> getTableOrders(Long table_Number){
        return orderRepository.getTableOrders(table_Number);
    }

    @Transactional
    public void completeOrder(Long table_Number){

        List<Order> orders = orderRepository.getTableOrders(table_Number);
        
        orders.forEach(order -> {
            if(!order.isOrdered())
                order.setOrdered(true);
        }); 


    }
}
