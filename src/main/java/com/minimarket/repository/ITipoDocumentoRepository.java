package com.minimarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minimarket.model.TipoDocumento;

@Repository
public interface ITipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer>{

}
