package com.minimarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minimarket.model.Cargo;

@Repository
public interface ICargoRepository extends JpaRepository<Cargo, Integer>{

}
