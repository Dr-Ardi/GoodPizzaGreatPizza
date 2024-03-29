package com.example.gpgpBack.ingredients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="gpgp/ingredients")
public class IngredController {

    private final IngredService ingredService;
    @Autowired
    public IngredController(IngredService ingredService) {
        this.ingredService = ingredService;
    }
    
    @GetMapping(path = "{item_Id}")
    public List<Ingredient> findIngreItemsById(@PathVariable("item_Id") Long item_Id){
        return ingredService.findIngreItemsById(item_Id);
    }

    @GetMapping(path = "desc/{item_Id}")
    public List<String> getDescription(@PathVariable("item_Id") Long item_Id){
        return ingredService.getDescription(item_Id);
    }

}
