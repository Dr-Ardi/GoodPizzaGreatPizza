package com.example.gpgpBack.added;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddedService {
    
    private final AddedRepository addedRepository;
    @Autowired
    public AddedService(AddedRepository addedRepository) {
        this.addedRepository = addedRepository;
    }

    public List<Added> getAdditionsByType(String add_Type){
        List<String> added = addedRepository.getAllTypes();
        List<Added> defaultVal = List.of(
            new Added(null,"none", "none", 0.0)
        );
        try{
            if (added.contains(add_Type))
                return addedRepository.getAdditionsByType(add_Type);
            else
                System.out.println("Didn't find: " + add_Type);
        }
        catch(Exception e){
            System.out.println("Exception: " + e);
        }
        return defaultVal;
    }
}
