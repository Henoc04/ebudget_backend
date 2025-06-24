package com.expertise.ebudget.budget.service;

import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureCategoryRequest;
import com.expertise.ebudget.budget.entity.nomenclature.NomenclatureCategoryResponse;
import com.expertise.ebudget.budget.mapper.NomenclatureCategoryMapper;
import com.expertise.ebudget.budget.repository.NomenclatureCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class NomenclatureCategoryService {

    private final NomenclatureCategoryRepository repository;
    private final NomenclatureCategoryMapper mapper;

    public Long createNomenclatureCategory(@Valid NomenclatureCategoryRequest request) {
        return repository.save(mapper.toNomenclatureCategory(request)).getId();
    }

    public List<NomenclatureCategoryResponse> getAllNomenclatureCategories() {
        return repository.findAll().stream()
                .map(mapper::fromNomenclatureCategory)
                .toList();
    }

    public NomenclatureCategoryResponse updateNomenclatureCategory(@Valid NomenclatureCategoryRequest request) {
        var category = repository.findById(request.id())
                .orElseThrow(()-> new EntityNotFoundException("This category don't exist"));
        category.setName(request.name());
        repository.save(category);
        return mapper.fromNomenclatureCategory(category);
    }

    public NomenclatureCategoryResponse getNomenclatureCategoryById(Long categoryId) {
        var category = repository.findById(categoryId)
                .orElseThrow(()-> new EntityNotFoundException("This category don't exist"));
        return mapper.fromNomenclatureCategory(category);
    }

    public String deleteNomenclatureCategoryById(Long categoryId) {
        var category = repository.findById(categoryId)
                .orElseThrow(()-> new EntityNotFoundException("This category don't exist"));
        repository.deleteById(categoryId);
        return "This nomenclature category is deleted successfully";
    }
}
