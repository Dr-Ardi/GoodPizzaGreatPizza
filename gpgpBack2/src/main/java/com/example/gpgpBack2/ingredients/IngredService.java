package com.example.gpgpBack2.ingredients;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gpgpBack2.item.Item;
import com.example.gpgpBack2.item.ItemRepository;

@Service
public class IngredService {

    private final IngredRepository ingredRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public IngredService(IngredRepository ingredRepository, ItemRepository itemRepository) {
        this.ingredRepository = ingredRepository;
        this.itemRepository = itemRepository;
        
    }

    public List<Ingredient> findIngreItemsById(Long item_Id){
        
        List<Ingredient> defaultVal = List.of(
            new Ingredient(null, 0, "ingred")
        );

        try{
            Long id = ingredRepository.checkId(item_Id);
            if (id != null)
                return ingredRepository.findIngreItemsById(item_Id);
            else
                System.out.println("Id " + id + " not found.");
        }
        catch(Exception e){
            System.out.println("Exception: " + e);
        }
        return defaultVal;
    }

    public List<String> getDescription(Long item_Id) {

        Item item = itemRepository.getItemById(item_Id);
        String type = item.getType();
        char[] vowel = {'a', 'e', 'i', 'o', 'u'};

        String start = "A ";

        String description;
        
        try{
            for(int i=0; i< vowel.length; i++){

                if(item.getName().toLowerCase().charAt(0) == vowel[i]){
                    start = "An ";
                    break;
                }

            }

            if ("Soft Drink".equals(type) || "Wine".equals(type) || "Water".equals(type) || "Beer".equals(type))
                return List.of(start + item.getName().toLowerCase()+ ".");

            if ("Appetiser".equals(type) || "Fries".equals(type))
                return List.of(start + "portion of " + item.getName().toLowerCase() + ".");

                
            if ("Pizza".equals(type) || "Burger".equals(type) || "Salad".equals(type) || "Pasta".equals(type)){
                List<String> ingredient = ingredRepository.getIngredients(item_Id);
                String ingredients = ingredient.toString();

                
                
                
                description = ingredients.substring(1, (ingredients.length()-1));
                
                if(ingredients.indexOf(",") != -1){

                    ingredients = description.substring((description.lastIndexOf(',')+1), description.length() );

                    description = (description.substring(0, description.lastIndexOf(',')) + " and" + ingredients); 

                    
                }
                
                description = (type + " with " + description + ".").toLowerCase();
                
                if ("Pasta".equals(type))
                    return List.of(start + " portion of " + description);
                
                return List.of(start + description);
            }
        }catch(Exception e){
            System.out.println("Exception: " + e);
        }
        
        return List.of("");
    } 
    

}
