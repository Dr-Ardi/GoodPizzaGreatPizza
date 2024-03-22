package com.example.gpgpBack.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(path="id/{id}")
    public Item getItemById(@PathVariable("id") Long id){
        return itemService.getItemById(id);
    }

    @GetMapping(path="type/{type}")
    public List<Item> getItemByType(@PathVariable("type") String type){
        return itemService.getItemsByType(type);
    }

    @GetMapping(path="name/{name}")
    public Item getItemByName(@PathVariable("name") String name){
        return itemService.getItemByName(name);
    }

    @GetMapping(path="types")
    public List<String> getEachType(){
        return itemService.getEachType();
    }

   
}
