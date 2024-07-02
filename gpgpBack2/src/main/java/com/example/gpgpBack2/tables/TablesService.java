package com.example.gpgpBack2.tables;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gpgpBack2.order.OrderRepository;


@Service
public class TablesService {
    
    private final TablesRepository tablesRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public TablesService(TablesRepository tablesRepository, OrderRepository orderRepository) {
        this.tablesRepository = tablesRepository;
        this.orderRepository = orderRepository;
        
    }
    
    public List<Tables> getAllItems(){
        return tablesRepository.getAllTables();
    }

    public List<Long> getAvailableTables(boolean occupied){
        return tablesRepository.getAvailableTables(occupied);
    }

    @Transactional
    public void sit(Long table_Number){
        
        Tables table = tablesRepository.findById(table_Number).orElseThrow(() -> new IllegalStateException("Doesnt Exist"));
        
        if(!table.isOccupied())
            table.setOccupied(true);
        
    }

    @Transactional
    public void unsit(Long table_Number){
        
        Tables table = tablesRepository.findById(table_Number).orElseThrow(() -> new IllegalStateException("Doesnt Exist"));
        
        if(table.isOccupied())
            table.setOccupied(false);
        
    }

    @Transactional
    public void tablePaid(Long table_Number){
        
        Tables table = tablesRepository.findById(table_Number).orElseThrow(() -> new IllegalStateException("Doesnt Exist"));
        
        if(table.isFinished()){
            table.setFinished(false);
            table.setOccupied(false);
            table.setPayment("Cash");
            table.setWaiter_Called(false);
            this.orderRepository.deleteTableOrder(table_Number);
        }
        
    }


    @Transactional
    public void callWaiter(Long table_Number){
        
        Tables table = tablesRepository.findById(table_Number).orElseThrow(() -> new IllegalStateException("Doesnt Exist"));
        
        if(!tablesRepository.isWaiterCalled(table_Number))
            table.setWaiter_Called(true);
        else
            table.setWaiter_Called(false);
        
        
    }

    @Transactional
    public void haveFinished(Long table_Number){
        
        Tables table = tablesRepository.findById(table_Number).orElseThrow(() -> new IllegalStateException("Doesnt Exist"));
        
        if(!tablesRepository.isTableFinished(table_Number))
            table.setFinished(true);
        
    }

    @Transactional
    public void changePaymentMethod(Long table_Number, String payment){
        
        Tables table = tablesRepository.findById(table_Number).orElseThrow(() -> new IllegalStateException("Doesnt Exist"));
        
        if(payment != null)
            table.setPayment(payment);
        
    }
}
