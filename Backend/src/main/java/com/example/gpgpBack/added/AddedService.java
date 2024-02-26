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
        return addedRepository.getAdditionsByType(add_Type);
    }
}
