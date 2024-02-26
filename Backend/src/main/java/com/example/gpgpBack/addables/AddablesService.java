package com.example.gpgpBack.addables;

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
        return addRepository.getAddablesByType(item_Type);
    }
}
