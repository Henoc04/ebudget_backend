package com.expertise.ebudget.budget.service;

import com.expertise.ebudget.budget.entity.budget.BudgetResponse;
import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureRequest;
import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureResponse;
import com.expertise.ebudget.budget.mapper.NomenclatureMapper;
import com.expertise.ebudget.budget.repository.NomenclatureCategoryRepository;
import com.expertise.ebudget.budget.repository.NomenclatureRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class NomenclatureService {
    private final NomenclatureRepository repository;
    private final NomenclatureCategoryRepository nomenclatureCategoryRepository;
    private final NomenclatureMapper mapper;

    public Long createNomenclature(@Valid NomenclatureRequest request) {
        var category = nomenclatureCategoryRepository.findById(request.categoryId())
                .orElseThrow(()-> new EntityNotFoundException("Any categories fund with this ID"));
        var nomenclature = mapper.toNomenclature(request);
        nomenclature.setCategory(category);
        return repository.save(nomenclature).getId();
    }

    public List<NomenclatureResponse> getAllNomenclatures() {
        return repository.findAll().stream()
                .map(mapper::fromNomenclature)
                .toList();
    }

    public NomenclatureResponse getNomenclatureById(Long nomenclatureId) {
        var nomenclature = repository.findById(nomenclatureId)
                .orElseThrow(()-> new EntityNotFoundException("This nomenclature don't exist"));
        return mapper.fromNomenclature(nomenclature);
    }

    public NomenclatureResponse updateNomenclature(@Valid NomenclatureRequest request) {
        var nomenclature = repository.findById(request.id())
                .orElseThrow(()-> new EntityNotFoundException("This nomenclature don't exist"));
        var category = nomenclatureCategoryRepository.findById(request.categoryId())
                        .orElseThrow(()-> new EntityNotFoundException("Any categories fund with this ID"));

        nomenclature.setCode(request.code());
        nomenclature.setName(request.name());
        nomenclature.setDescription(request.description());
        nomenclature.setCategory(category);

        repository.save(nomenclature);
        return mapper.fromNomenclature(nomenclature);
    }

    public String deleteNomenclatureById(Long nomenclatureId) {
        var nomenclature = repository.findById(nomenclatureId)
                .orElseThrow(()-> new EntityNotFoundException("This nomenclature don't exist"));
        repository.deleteById(nomenclatureId);
        return "This nomenclature is deleted successfully";
    }

    public List<NomenclatureResponse> getNomenclaturesByCategory(long categoryId) {
        var category = nomenclatureCategoryRepository.findById(categoryId)
                .orElseThrow(()-> new EntityNotFoundException("Any categories fund with this ID"));
        return repository.findByCategoryId(categoryId).stream()
                .map(mapper::fromNomenclature)
                .toList();

    }
}
