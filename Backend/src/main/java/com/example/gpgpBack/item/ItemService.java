package com.example.gpgpBack.item;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    

    
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    
    

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public List<String> getEachType(){
        List<String> theTypes = itemRepository.getEachType();
        String[] products = {"Appetiser", "Fries", "Salad", "Pizza","Burger", "Pasta", "Water", "Soft Drink", "Beer", "Wine"};

        
        int i=0;

        for(i=0; i<products.length; i++){
            
            int p= 0;
            for(p = 0; p <theTypes.size(); p++){
                if (products[i].equals(theTypes.get(p))) {

                    String temp = theTypes.get(i);
                    theTypes.set(i, theTypes.get(p));
                    theTypes.set(p, temp);
                    
                }
            }
            
        }
        return theTypes;
    }



    public Item getItemById(Long id) {

        Item defaultItem = new Item( null, "type", "name", 0, 0.0);

        try{

            Long idCheck = itemRepository.checkId(id);

            if(idCheck != null)
                return itemRepository.getItemById(id);
            else
                System.out.println("Not Found");

        }
        catch(Exception e){
            System.out.println("Exception: " + e);
        }

        return defaultItem;

    }

    public List<Item> getItemsByType(String type) {

        return itemRepository.getItemsByType(type);

    }

    public Item getItemByName(String name) {

        Item defaultItem = new Item( null, "type", "name", 0, 0.0);

        try{

            String nameCheck = itemRepository.checkName(name);

            if(nameCheck != null)
                return itemRepository.getItemByName(name);
            else
                System.out.println("Not Found");

        }
        catch(Exception e){
            System.out.println("Exception: " + e);
        }

        return defaultItem;
    }

   
}