/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ruiz.spring.jpa.postgresql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author JuanRuiz
 */
@Entity
public class ResponsePruebas {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
        
        @Column(name = "nombres")
	private String nombres;
        
        @Column(name = "email")
	private String email;
        
        @Column(name = "identificacion")
	private String identificacion;
        
        @Column(name = "porcazucar")
	private Float porcazucar;
        
        @Column(name = "porcgrasa")
	private Float porcgrasa;
        
        @Column(name = "porcoxigeno")
	private Float porcoxigeno;
        
        @Column(name = "riesgo")
	private String riesgo;
        
	/*@Column(name = "published")
	private boolean published;*/

	

    public ResponsePruebas() {
    }

	public ResponsePruebas(Long id, String nombres, String email, String identificacion, Float porcazucar, Float porcgrasa, Float porcoxigeno, String riesgo) {
	        this.id = id;	
                this.nombres = nombres;
		this.email = email;
                this.identificacion = identificacion;
                this.porcazucar = porcazucar;
                this.porcgrasa = porcgrasa;
                this.porcoxigeno = porcoxigeno;
                this.riesgo= riesgo;
		//this.published = published;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
        
        public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
        
        public Float getPorcazucar() {
		return porcazucar;
	}

	public void setPorcazucar(Float porcazucar) {
		this.porcazucar = porcazucar;
	}
        
         public Float getPorcgrasa() {
		return porcgrasa;
	}

	public void setPorcgrasa(Float porcgrasa) {
		this.porcgrasa = porcgrasa;
	}
        
         public Float getPorcoxigeno() {
		return porcoxigeno;
	}

	public void setPorcoxigeno(Float porcoxigeno) {
		this.porcoxigeno = porcoxigeno;
	}

	
        public String getRiesgo() {
        return riesgo;

	}

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }
	@Override
	public String toString() {
		return "Prueba [nombres=" + nombres + ", email=" + email + ", identificacion=" + identificacion + "]";
	}

   

}

