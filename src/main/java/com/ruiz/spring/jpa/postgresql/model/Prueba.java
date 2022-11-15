package com.ruiz.spring.jpa.postgresql.model;

import javax.persistence.*;

@Entity
@Table(name = "pruebas")
public class Prueba {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

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
        
       // @Column(name = "porcoxigeno")
	//private String riesgo;
        
	/*@Column(name = "published")
	private boolean published;*/

	

    public Prueba() {
    }

	public Prueba(String nombres, String email, String identificacion, Float porcazucar, Float porcgrasa, Float porcoxigeno) {
                this.nombres = nombres;
		this.email = email;
                this.identificacion = identificacion;
                this.porcazucar = porcazucar;
                this.porcgrasa = porcgrasa;
                this.porcoxigeno = porcoxigeno;
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


	@Override
	public String toString() {
		return "Prueba [ nombres=" + nombres + ", email=" + email + ", identificacion=" + identificacion + "]";
	}

}
