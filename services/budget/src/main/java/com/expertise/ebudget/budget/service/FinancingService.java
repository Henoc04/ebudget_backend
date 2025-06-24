package com.expertise.ebudget.budget.service;

import com.expertise.ebudget.budget.entity.financing.FinancingRequest;
import com.expertise.ebudget.budget.entity.financing.FinancingResponse;
import com.expertise.ebudget.budget.mapper.ActivityMapper;
import com.expertise.ebudget.budget.mapper.FinancingMapper;
import com.expertise.ebudget.budget.repository.ActivityRepository;
import com.expertise.ebudget.budget.repository.BudgetRepository;
import com.expertise.ebudget.budget.repository.FinancingRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FinancingService {

    private final FinancingRepository repository;
    private final FinancingMapper mapper;

    public Long createFinancing(@Valid FinancingRequest request) {
        return repository.save(mapper.toFinancing(request)).getId();
    }

    public List<FinancingResponse> getAllFinancing() {
        return repository.findAll().stream()
                .map(mapper::fromFinancing)
                .toList();
    }

    public FinancingResponse getFinancingById(Long financingId) {
        var financing = repository.findById(financingId)
                .orElseThrow(()-> new EntityNotFoundException("This financing don't exist"));
        return mapper.fromFinancing(financing);
    }

    public FinancingResponse updateFinancing(FinancingRequest request) {
        var financing = repository.findById(request.id())
                .orElseThrow(()-> new EntityNotFoundException("This financing don't exist"));

        financing.setName(request.name());
//        financing.setAmount(request.amount());
        financing.setDescription(request.description());
        repository.save(financing);

        return mapper.fromFinancing(financing);

    }

    public String deleteFinancingById(Long financingId) {
        var financing = repository.findById(financingId)
                .orElseThrow(()-> new EntityNotFoundException("This financing don't exist"));

        repository.deleteById(financing.getId());

        return "This financing is delete successfully ! ";

    }
}
