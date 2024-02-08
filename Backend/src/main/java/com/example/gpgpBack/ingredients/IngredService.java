package com.example.gpgpBack.ingredients;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredService {

    private final IngredRepository ingredRepository;

    @Autowired
    public IngredService(IngredRepository ingredRepository) {
        this.ingredRepository = ingredRepository;
        
    }
    
    public List<Ingredient> getAllItems(){
        return ingredRepository.findAll();
    }

    public List<String> findIngreItemsById(Long item_Id){
        return ingredRepository.findIngreItemsById(item_Id);
    } 
    


}
