package com.example.gpgpBack.tables;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TablesService {
    
    private final TablesRepository tablesRepository;

    @Autowired
    public TablesService(TablesRepository tablesRepository) {
        this.tablesRepository = tablesRepository;
        
    }
    
    public List<Tables> getAllItems(){
        return tablesRepository.findAll();
    }

    public List<Long> getAvailableTables(boolean occupied){
        return tablesRepository.getAvailableTables(occupied);
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
