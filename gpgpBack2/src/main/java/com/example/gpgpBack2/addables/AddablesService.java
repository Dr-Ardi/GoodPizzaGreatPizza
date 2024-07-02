package com.example.gpgpBack2.addables;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddablesService {
    
    private final AddablesRepository addRepository;
    @Autowired
    public AddablesService(AddablesRepository addRepository) {
        this.addRepository = addRepository;
    }

    public Addables getAddablesByType(String item_Type){

        List<String> types = addRepository.getAllTypes();
        Addables defaultVal = new Addables( "none", false, false, false,
            false, false, false);;
        try{

            if (types.contains(item_Type)) 
                return addRepository.getAddablesByType(item_Type);
            else
                System.out.println("Didn't find: " + item_Type);
        }
        catch(Exception e){
            System.out.println("Exception: " + e);
        }

        return defaultVal;
    }
}