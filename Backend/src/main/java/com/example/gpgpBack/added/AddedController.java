package com.example.gpgpBack.added;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="gpgp/added")
public class AddedController {
    
    private final AddedService addedService;
    @Autowired
    public AddedController(AddedService addedService) {
        this.addedService = addedService;
    }

    @GetMapping(path="{add_Type}")
    public List<Added> getAdditionsByType(@PathVariable("add_Type") String add_Type){
        return addedService.getAdditionsByType(add_Type);
    }
}
