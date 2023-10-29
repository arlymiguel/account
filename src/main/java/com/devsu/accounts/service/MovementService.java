package com.devsu.accounts.service;

import java.util.List;

import com.devsu.accounts.model.dto.MovementDto;

public interface MovementService {

	MovementDto create(MovementDto movement);

	MovementDto update(MovementDto movement, Long id);

	void deleteById(Long id);

	MovementDto getById(Long id);

	List<MovementDto> getAll();
}
