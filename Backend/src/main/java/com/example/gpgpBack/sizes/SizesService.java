package com.example.gpgpBack.sizes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizesService {
    

     
    private final SizesRepository sizesRepository;

    @Autowired
    public SizesService(SizesRepository sizesRepository) {
        this.sizesRepository = sizesRepository;
    }
    
    

    public List<Sizes> getAllSizes(){
        return sizesRepository.findAll();
    }

    public List<String> findSizes(String item_Type){
        return sizesRepository.findSizes(item_Type);
    } 
}
