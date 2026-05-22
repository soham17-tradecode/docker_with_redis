package com.example.dickkrt.repo;

import com.example.dickkrt.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface stuRepo extends JpaRepository<Model,Integer> {

//    Optional<Model> findById(Integer id);
}
