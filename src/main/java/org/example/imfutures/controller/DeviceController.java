package org.example.imfutures.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/IMFuture/device")
public class DeviceController {

    @PostMapping("/properties")
    public void properties(Object property) {
        System.out.println(property.toString());
    }
}
