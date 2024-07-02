package com.example.gpgpBack2.tables;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="gpgp/restaurant_Tables")
public class TablesController {
    
    private final TablesService tablesService;
    @Autowired
    public TablesController(TablesService tablesService) {
        this.tablesService = tablesService;
    }

    @GetMapping
    public List<Tables> getAllItems(){
        return tablesService.getAllItems();
    }

    @GetMapping(path = "free")
    public List<Long> getAvailableTables(){
        return tablesService.getAvailableTables(false);
    }  

    @PutMapping(path = "sit/{table_Number}")
    public void sit(@PathVariable("table_Number") Long table_Number){
        tablesService.sit(table_Number);
    }

    @PutMapping(path = "unsit/{table_Number}")
    public void unsit(@PathVariable("table_Number") Long table_Number){
        tablesService.unsit(table_Number);
    }

    @PutMapping(path = "paid/{table_Number}")
    public void tablePaid(@PathVariable("table_Number") Long table_Number){
        tablesService.tablePaid(table_Number);
    }


    @PutMapping(path = "waiter/{table_Number}")
    public void callWaiter(@PathVariable("table_Number") Long table_Number){
        tablesService.callWaiter(table_Number);
    }

    @PutMapping(path = "{table_Number}")
    public void haveFinished(@PathVariable("table_Number") Long table_Number){
        tablesService.haveFinished(table_Number);
    }

    @PutMapping(path = "/payment/{table_Number}")
    public void changePaymentMethod(@PathVariable("table_Number") Long table_Number,
                                    @RequestParam(required = false) String payment){
        tablesService.changePaymentMethod(table_Number, payment);
    }
    
}
