package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface ViagemRepository extends CrudRepository<Viagem, Long>{

	Viagem getViagemById(long id);
}
