package com.example.dickkrt.controller;

import com.example.dickkrt.model.Model;
import com.example.dickkrt.model.redisData;
import com.example.dickkrt.service.redisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.web.bind.annotation.*;

@RestController
public class redisController {
    @Autowired
    redisService redisService;
//    @Autowired
//    redisData redisData;

//    @PostMapping("/redis/save")
//    public String  save(@RequestParam String key ,@RequestParam String value)
//
//    {
////
//        redisService
//                .save(key, value);
//        return "saved";
//
//    }

//    @GetMapping("/redis/get")
//    public Object get(@RequestBody redisData redisData )
//    {
//
//        return redisService.get(redisData.getKey());
//    }

    @GetMapping("/get/{id}")
    public Model get(@PathVariable Integer id)
    {
        return redisService.getUser(id);

    }



}
