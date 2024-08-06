package com.prueba_tecnica.fondo_pensiones.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.prueba_tecnica.fondo_pensiones.model.Client;

/**
 * Repository interface for Clients entities.
 * This interface provides methods to perform CRUD operations on Client entities in MongoDB.
 */
public interface ClientRepository extends MongoRepository<Client, String> {
	
	/**
	 * Finds a client by their name;
	 * @param name The name of the client to search for.
	 * @return The client entity with the specified name, or null if no client is found.
	 */
	Client findByName(String name);
	
    Optional<Client> findByClientId(String clientId);
}
