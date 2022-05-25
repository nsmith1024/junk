package com.example.accessingdatamongodb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CustomerController {
    
    @GetMapping(value="/")
    public String HelloController()
    {
        return "IM ALIVE!!!!!!";
    }
}
