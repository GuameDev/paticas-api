package com.paticasprototype.paticas.infrastructure;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrototypeController {

    @GetMapping("/")
    public String index() {
        return "YESSSSSSSSSSSSSSSSSSSSSSSSSSSS!";
    }
}
