package com.ruiz.spring.jpa.postgresql.controller;


import com.ruiz.spring.jpa.postgresql.model.Prueba;
import com.ruiz.spring.jpa.postgresql.model.ResponsePruebas;
import com.ruiz.spring.jpa.postgresql.repository.PruebaRepositorioList;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ruiz.spring.jpa.postgresql.repository.PruebaRepository;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PruebaController {

	@Autowired
	PruebaRepository pruebaRepository;
        
        @Autowired
	PruebaRepositorioList pruebaRepositorioList;

	@GetMapping("/pruebas")
	public ResponseEntity<List<ResponsePruebas>> getAllPruebas(@RequestParam(required = false) String nombres) {
		try {
			//List<Prueba> pruebas = new ArrayList<Prueba>();
                        List<ResponsePruebas> res = new ArrayList<ResponsePruebas>();
                       

			if (nombres == null)
				pruebaRepositorioList.findPruebasByRiesgo().forEach(res::add);
                        
                                        //.findAll().forEach(pruebas::add);
			else
				pruebaRepositorioList.findBynombresContaining(nombres).forEach(res::add);

			if (res.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
        
     

	@GetMapping("/pruebas/{id}")
	public ResponseEntity<Prueba> getPruebasById(@PathVariable("id") long id) {
		Optional<Prueba> tutorialData = pruebaRepository.findById(id);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/pruebas")
	public ResponseEntity<Prueba> createPruebas(@RequestBody Prueba prueba) {
		try {
			Prueba _prueba= pruebaRepository
					.save(new Prueba(prueba.getNombres(), prueba.getEmail(), prueba.getIdentificacion(), prueba.getPorcazucar(), prueba.getPorcgrasa(), prueba.getPorcoxigeno()));
			return new ResponseEntity<>(_prueba, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/pruebas/{id}")
	public ResponseEntity<Prueba> updatePruebas(@PathVariable("id") long id, @RequestBody Prueba prueba) {
		Optional<Prueba> tutorialData = pruebaRepository.findById(id);

		if (tutorialData.isPresent()) {
			Prueba _prueba = tutorialData.get();
			_prueba.setNombres(prueba.getNombres());
			_prueba.setEmail(prueba.getEmail());
                        _prueba.setIdentificacion(prueba.getIdentificacion());
                        _prueba.setPorcazucar(prueba.getPorcazucar());
                        _prueba.setPorcgrasa(prueba.getPorcgrasa());
                        _prueba.setPorcoxigeno(prueba.getPorcoxigeno());
			return new ResponseEntity<>(pruebaRepository.save(_prueba), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/pruebas/{id}")
	public ResponseEntity<HttpStatus> deletePruebas(@PathVariable("id") long id) {
		try {
			pruebaRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/pruebas")
	public ResponseEntity<HttpStatus> deleteAllPruebas() {
		try {
			pruebaRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
