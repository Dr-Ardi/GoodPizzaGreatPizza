package com.example.gpgpBack2.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="gpgp/orders")
public class OrderController {
    

    private final OrderService orderService;
    
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void addToOrder(@RequestBody Order order){
        System.out.println(order);
        orderService.addToOrder(order);
    }

    @GetMapping(path = "{table_Number}")
    public List<Order> getTableOrders(@PathVariable("table_Number") Long table_Number){
        return orderService.getTableOrders(table_Number);
    }


    @PutMapping(path = "{table_Number}")
    public void completeOrder(@PathVariable("table_Number") Long table_Number){
        orderService.completeOrder(table_Number);
    }

    @GetMapping(path = "final/{table_Number}")
    public double getFinalPrice(@PathVariable("table_Number") Long table_Number){
        return orderService.getFinalPrice(table_Number);
    }
}
