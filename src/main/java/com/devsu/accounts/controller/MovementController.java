package com.devsu.accounts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.accounts.service.MovementService;

import com.devsu.accounts.model.dto.MovementDto;

@RestController
@RequestMapping("/movements")
public class MovementController {

	@Autowired
	private MovementService movementService;

	@PostMapping
	public MovementDto crear(@RequestBody @Valid MovementDto movement) {
		MovementDto newMovement = movementService.create(movement);

		return newMovement;

	}

	@DeleteMapping("/{idParam}")
	public void delete(@PathVariable(value = "idParam") Long id) {
		movementService.deleteById(id);

	}

	@PutMapping("/{id}")
	public MovementDto update(@RequestBody @Valid MovementDto client, @PathVariable(value = "id") Long id) {
		MovementDto movementUpdated = movementService.update(client, id);
		return movementUpdated;

	}

	@GetMapping("/{id}")
	public MovementDto getByid(@PathVariable(value = "id") Long id) {
		MovementDto movementObtain = movementService.getById(id);
		return movementObtain;
	}

	@GetMapping
	public List<MovementDto> getAll() {

		return movementService.getAll();
	}

}
