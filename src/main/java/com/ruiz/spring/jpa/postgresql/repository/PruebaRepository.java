package com.ruiz.spring.jpa.postgresql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruiz.spring.jpa.postgresql.model.Prueba;
import com.ruiz.spring.jpa.postgresql.model.ResponsePruebas;
import org.springframework.data.jpa.repository.Query;

public interface PruebaRepository extends JpaRepository<Prueba, Long> {
 // List<Prueba> findByPublished(boolean published);

  List<Prueba> findBynombresContaining(String nombres);
  
  @Query(value = "SELECT id,email, identificacion, nombres, porcazucar, porcgrasa, porcoxigeno, case when ((porcazucar > 70) and (porcgrasa > 88.5) and (porcoxigeno<60)) then 'ALTA' when ((porcazucar between 50 and 70) and (porcgrasa between 62.2 and 88.5) and (porcoxigeno between 60 and 70)) then 'MEDIA' when ((porcazucar < 50)  and (porcgrasa < 62.2) and (porcoxigeno>70)) then 'BAJA' else 'Ninguno' end as Riesgo FROM  public.pruebas" ,  nativeQuery = true)
  List<Prueba> findPruebasByRiesgo();
  

}
