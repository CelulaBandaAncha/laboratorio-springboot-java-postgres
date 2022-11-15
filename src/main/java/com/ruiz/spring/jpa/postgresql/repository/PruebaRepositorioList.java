package com.ruiz.spring.jpa.postgresql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruiz.spring.jpa.postgresql.model.Prueba;
import com.ruiz.spring.jpa.postgresql.model.ResponsePruebas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PruebaRepositorioList extends JpaRepository<ResponsePruebas, Long> {
 // List<Prueba> findByPublished(boolean published);
  @Query(value = "SELECT id,email, identificacion, nombres, porcazucar, porcgrasa, porcoxigeno, case when ((porcazucar > 70) and (porcgrasa > 88.5) and (porcoxigeno<60)) then 'ALTA' when ((porcazucar between 50 and 70) and (porcgrasa between 62.2 and 88.5) and (porcoxigeno between 60 and 70)) then 'MEDIA' when ((porcazucar < 50)  and (porcgrasa < 62.2) and (porcoxigeno>70)) then 'BAJA' else 'Ninguno' end as Riesgo FROM  public.pruebas WHERE nombres=:nombres" ,  nativeQuery = true)
  List<ResponsePruebas> findBynombresContaining(@Param("nombres")String nombres);
  
//@Query("SELECT c FROM Prueba c WHERE c.model = :model")
//@Query("SELECT email, identificacion, nombres, porcazucar, porcgrasa, porcoxigeno, case when ((porcazucar > 70) and (porcgrasa > 88.5) and (porcoxigeno<60)) then 'ALTA' when ((porcazucar between 50 and 70) and (porcgrasa between 62.2 and 88.5) and (porcoxigeno between 60 and 70)) then 'MEDIA' when ((porcazucar < 50)  and (porcgrasa < 62.2) and (porcoxigeno>70)) then 'BAJA' else 'Ninguno' end as Riesgo FROM  public.pruebas")
@Query(value = "SELECT id,email, identificacion, nombres, porcazucar, porcgrasa, porcoxigeno, case when ((porcazucar > 70) and (porcgrasa > 88.5) and (porcoxigeno<60)) then 'ALTA' when ((porcazucar between 50 and 70) and (porcgrasa between 62.2 and 88.5) and (porcoxigeno between 60 and 70)) then 'MEDIA' when ((porcazucar < 50)  and (porcgrasa < 62.2) and (porcoxigeno>70)) then 'BAJA' else 'Ninguno' end as Riesgo FROM  public.pruebas" ,  nativeQuery = true)
  List<ResponsePruebas> findPruebasByRiesgo();
}
