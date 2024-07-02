package com.example.gpgpBack2.order;

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
    
    public List<Order> getTableOrders(Long table_Number){
        
        List<Order> noTable = List.of(
            new Order(null, 0, 0, "Table Not Found",
                "", "", "", 0, false, 0.0, "")
        );

        try{

            Long table = orderRepository.checkTable(table_Number);
            
            if (table != null)
                return orderRepository.getTableOrders(table_Number);
            else
                System.out.println("Table Not Found");

        }
        catch(Exception e){
            System.out.println("Exception: " + e);
        }

        return noTable;
    }

    public void addToOrder(Order order){
        System.out.println(order);
        orderRepository.save(order);
    }

    @Transactional
    public void completeOrder(Long table_Number){

        List<Order> orders = orderRepository.getTableOrders(table_Number);
        
        orders.forEach(order -> {
            if(!order.isOrdered())
                order.setOrdered(true);
        }); 


    }

    public double getFinalPrice(Long table_Number){

        double defaultFinal = 0.0;

        try{

            Long tableCheck = orderRepository.checkTable(table_Number);

            if (tableCheck != null)
                return orderRepository.getFinalPrice(table_Number);
            else
                System.out.println("Table doesn't exist");
        }
        catch(Exception e){
            System.out.println("Exception: " + e);
        }


        return defaultFinal;
    }
}
