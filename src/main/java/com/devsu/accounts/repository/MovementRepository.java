package com.devsu.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsu.accounts.model.entity.Movement;

import java.util.Date;
import java.util.List;

public interface MovementRepository extends JpaRepository<Movement, Long>{

    List<Movement> findByDateBetween(Date startDate, Date endDate);

}
