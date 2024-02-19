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

    public List<String> findIngreItemsById(Long item_Id){
        return ingredRepository.findIngreItemsById(item_Id);
    }

    public List<String> getDescription(Long item_Id) {

        List<String> ingredient = ingredRepository.findIngreItemsById(item_Id);

        String ingredients = ingredient.toString();

        String description = ingredients.substring(1, (ingredients.length()-1));

        ingredients = description.substring((description.lastIndexOf(',')+1), description.length() );

        description = (description.substring(0, description.lastIndexOf(',')) + " and" + ingredients); 

        description = (" with " + description + ".").toLowerCase();

        return List.of(description);
    } 
    


}
