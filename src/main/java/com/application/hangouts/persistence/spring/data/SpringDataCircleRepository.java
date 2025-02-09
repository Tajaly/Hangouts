package com.application.hangouts.persistence.spring.data;

import com.application.hangouts.logic.domain.model.Circle;
import com.application.hangouts.persistence.dto.CircleDto;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface SpringDataCircleRepository extends CrudRepository<CircleDto, Integer> {
    @Override
    Collection<CircleDto> findAll();

    Collection<CircleDto> findByOrganizer(String organizer);

    @Override
    CircleDto save(CircleDto circle);


    Optional<CircleDto> findById(Integer id);

    //List<CircleDto> findByName(String name);




}
