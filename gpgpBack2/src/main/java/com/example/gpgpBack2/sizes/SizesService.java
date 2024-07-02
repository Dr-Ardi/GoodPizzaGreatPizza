package com.example.gpgpBack2.sizes;

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

    public List<Sizes> findSizes(String item_Type){

        List<Sizes> defaultSizes = List.of(
            new Sizes(null, item_Type, "Not Found", 0.0)
        );

        try{

            String type = sizesRepository.checkSize(item_Type);
            if(type != null)
                return sizesRepository.findSizes(item_Type);
            else
                System.out.println("Size not Found");

        }
        catch(Exception e){
            System.out.println("Exception: " + e);
        }

        return defaultSizes;
    } 
}
