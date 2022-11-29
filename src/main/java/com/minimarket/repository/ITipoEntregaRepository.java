package com.minimarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minimarket.model.TipoEntrega;

@Repository
public interface ITipoEntregaRepository extends JpaRepository<TipoEntrega, Integer>{

}
