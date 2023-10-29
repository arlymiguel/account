package com.devsu.accounts.mapper;

import org.springframework.stereotype.Component;

import com.devsu.accounts.model.dto.MovementDto;
import com.devsu.accounts.model.entity.Movement;

@Component
public class MovementMapper {

	public Movement toMovement(MovementDto movementDto) {
		Movement movement = new Movement();

		movement.setBalance(movementDto.getBalance());
		movement.setDate(movementDto.getDate());
		movement.setType(movementDto.getType());
		movement.setValue(movementDto.getValue());

		return movement;
	}

	public MovementDto toMovementDto(Movement movement) {
		MovementDto movementDto = new MovementDto();

		movementDto.setBalance(movement.getBalance());
		movementDto.setDate(movement.getDate());
		movementDto.setType(movement.getType());
		movementDto.setValue(movement.getValue());

		return movementDto;
	}

}
