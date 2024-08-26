package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Train;
@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {

	
	
}
