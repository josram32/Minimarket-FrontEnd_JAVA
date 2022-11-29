package com.minimarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minimarket.model.UnidadMedida;

@Repository
public interface IUnidadMedidaRepository extends JpaRepository<UnidadMedida, Integer>{

}
