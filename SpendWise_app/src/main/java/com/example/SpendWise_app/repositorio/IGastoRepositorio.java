package com.example.SpendWise_app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpendWise_app.modelos.Gastos;

@Repository
public interface IGastoRepositorio extends JpaRepository<Gastos,Integer> {

    
}