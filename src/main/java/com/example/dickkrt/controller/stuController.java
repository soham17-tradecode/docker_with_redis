package com.example.dickkrt.controller;

import com.example.dickkrt.model.Model;
import com.example.dickkrt.repo.stuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class stuController {
    @Autowired
    stuRepo stuRepo;



    @RequestMapping ("/gets")
    public List<Model> st()
    {
        return stuRepo.findAll();

    }
    @PostMapping("/save")
    public Model save(
            @RequestBody Model model)
    {
        return stuRepo.save(model);
    }
}
