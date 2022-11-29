package com.minimarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minimarket.model.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer>{

}
