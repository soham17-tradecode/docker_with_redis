package com.example.dickkrt.service;

import com.example.dickkrt.model.Model;
import com.example.dickkrt.repo.stuRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class redisService {

    @Autowired
    stuRepo stuRepo;


    @Autowired
    RedisTemplate<String,Object> template;

//    @Autowired
//    Model model;


//    public void save(
//            String key,
//            String value)
//    {
//        template.opsForValue()
//                .set(key,value);
//    }
//    public Object get(String key)
//    {
//        return template.opsForValue().get(key);
//    }



    public Model getUser(Integer id)
    {
        String key = "user_"+id;

        Object cached = template.opsForValue().get(key);

        if (cached!=null)
        {
            System.out.println("this is form redis");
            return (Model) cached;
        }

        Model model = stuRepo.findById(id).orElse(null);
        if (model!=null)
        {

            template.opsForValue().set(key,model);
        } System.out.println("this is  from db");
        return model;

    }

}
