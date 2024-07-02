package com.example.gpgpBack2.addables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="gpgp/addables")
public class AddablesController {
    
    private final AddablesService addService;
    @Autowired
    public AddablesController(AddablesService addService) {
        this.addService = addService;
    }

    @GetMapping(path="{item_Type}")
    public Addables getAddablesByType(@PathVariable("item_Type") String item_Type){
        return addService.getAddablesByType(item_Type);
    }
}
