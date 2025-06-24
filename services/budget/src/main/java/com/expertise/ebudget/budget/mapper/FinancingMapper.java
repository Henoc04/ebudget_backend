package com.expertise.ebudget.budget.mapper;

import com.expertise.ebudget.budget.entity.financing.Financing;
import com.expertise.ebudget.budget.entity.financing.FinancingRequest;
import com.expertise.ebudget.budget.entity.financing.FinancingResponse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class FinancingMapper {
    public Financing toFinancing(@Valid FinancingRequest request) {
        return Financing.builder()
                .name(request.name())
//                .amount(request.amount())
                .description(request.description())
                .build();
    }

    public FinancingResponse fromFinancing(Financing financing) {

        return new FinancingResponse(
                financing.getId(),
                financing.getName(),
//                financing.getAmount(),
                financing.getDescription()
        );
    }
}
