package com.example.gpgpBack.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="gpgp/items")
public class ItemController {

    private final ItemService itemService;
    
    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    

    @GetMapping
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

   
}
