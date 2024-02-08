package com.example.gpgpBack.ingredients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="gpgp/ingredients")
public class IngredController {

    private final IngredService ingredService;
    @Autowired
    public IngredController(IngredService ingredService) {
        this.ingredService = ingredService;
    }

    @GetMapping
    public List<Ingredient> getAllItems(){
        return ingredService.getAllItems();
    }

    
    @GetMapping(path = "{item_Id}")
    public List<String> findIngreItemsById(@PathVariable("item_Id") Long item_Id){
        return ingredService.findIngreItemsById(item_Id);
    }

}
