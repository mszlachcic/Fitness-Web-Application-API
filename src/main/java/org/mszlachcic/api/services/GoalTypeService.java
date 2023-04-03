package org.mszlachcic.api.services;

import org.mszlachcic.api.dtos.GoalTypeDto;
import org.mszlachcic.api.entities.GoalType;
import org.mszlachcic.api.repository.GoalTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoalTypeService {

    private final GoalTypeRepository goalTypeRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public GoalTypeService(GoalTypeRepository goalTypeRepository) {
        this.goalTypeRepository = goalTypeRepository;
    }

    public List<GoalTypeDto> getGoalTypes(){
        List<GoalType> goalTypeList = goalTypeRepository.findAll();
        List<GoalTypeDto> goalTypeDtoList;

        goalTypeDtoList = goalTypeList.stream()
                .map(goalType ->
                        modelMapper.map(goalType,GoalTypeDto.class))
                .collect(Collectors.toList());

        return goalTypeDtoList;
    }
}
