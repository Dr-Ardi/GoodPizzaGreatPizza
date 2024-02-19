package com.example.gpgpBack.sizes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="gpgp/sizes")
public class SizesController {
    

    private final SizesService sizesService;
    
    @Autowired
    public SizesController(SizesService sizesService) {
        this.sizesService = sizesService;
    }

    @GetMapping(path = "{item_Type}")
    public List<String> findIngreItemsById(@PathVariable("item_Type") String item_Type){
        return sizesService.findSizes(item_Type);
    }


}
