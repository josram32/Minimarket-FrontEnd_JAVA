package com.minimarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minimarket.model.TipoComprobante;

@Repository
public interface ITipoComprobanteRepository extends JpaRepository<TipoComprobante, Integer>{

}
