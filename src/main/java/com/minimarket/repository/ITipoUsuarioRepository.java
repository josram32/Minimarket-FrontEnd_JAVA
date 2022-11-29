package com.minimarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minimarket.model.TipoUsuario;

@Repository
public interface ITipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {

}
