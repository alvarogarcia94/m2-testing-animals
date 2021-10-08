package com.example.m2testinganimals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalsRepository extends JpaRepository<Animals, Long> {


    List<Animals> findByEspecie(String especie);

    List<Animals> findByEspecieAndName(String especie, String nombre);

}
