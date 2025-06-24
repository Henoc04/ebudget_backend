package com.expertise.ebudget.center.service;

import com.expertise.ebudget.center.entity.Center;
import com.expertise.ebudget.center.entity.CenterRequest;
import com.expertise.ebudget.center.entity.CenterResponse;
import com.expertise.ebudget.center.mapper.CenterMapper;
import com.expertise.ebudget.center.repository.CenterRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CenterService {

    private final CenterRepository repository;
    private final CenterMapper mapper;

    public Long createCenter(@Valid CenterRequest request) {
        Center center = mapper.toCenter(request);
        return repository.save(center).getId();
    }

    public List<CenterResponse> getAllCenters() {
        return repository.findAll().stream()
                .map(mapper::fromCenter)
                .toList();
    }

    public CenterResponse getCenter(Long id) {
        Center center = repository.findById(id)
                .orElseThrow( ()-> new EntityNotFoundException("No Center found with this id"));
        return mapper.fromCenter(center);
    }

    public CenterResponse update(@Valid CenterRequest request) {
        Center center = repository.findById(request.id())
                .orElseThrow(()-> new EntityNotFoundException("Not Center found with this id"));
        center.setName(request.name());
        center.setLocation(request.location());
        center.setManager(request.manager());
        center.setAmount(request.amount());
        repository.save(center);
        return mapper.fromCenter(center);
    }

    public String deleteCenterById(Long id) {
        Center center = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Not Center found with this id"));
        repository.deleteById(center.getId());
        return "The center " + id +" was deleted successfully";
    }
}
