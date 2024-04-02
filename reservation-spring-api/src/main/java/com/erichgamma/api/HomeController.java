package com.erichgamma.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String hello(){
        return "Welcom To Spring Boot !";
    }

    @PostMapping("/name")
    public String name(@RequestBody Map<String, ?> map){
        String name = (String)map.get("name");
        System.out.println("request가 가져온 이름: "+name);
        return name;
    }
}
