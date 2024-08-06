package com.prueba_tecnica.fondo_pensiones.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prueba_tecnica.fondo_pensiones.model.GeneralFund;

/**
 * Repository interface for General Fund entities.
 * This interface provides methods to perform CRUD operations on general funds entities on MongoDB.
 */
public interface GeneralFundRepository extends MongoRepository<GeneralFund, String>{
	
	Optional<GeneralFund> findByFundId(String fundId);
}
