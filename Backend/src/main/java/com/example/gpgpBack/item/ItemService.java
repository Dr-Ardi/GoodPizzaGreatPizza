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

   
}


// theTypes.
            // theTypes.forEach(theType -> {
            //     if(products[j].equals(theType)){
            //         String temp = theTypes.get(j);
            //         theTypes.set((j), theType);
            //         theTypes.set(theTypes.indexOf(theType), temp);
            //     }
            // });