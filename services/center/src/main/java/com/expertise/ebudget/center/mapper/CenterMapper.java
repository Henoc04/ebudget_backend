package com.expertise.ebudget.center.mapper;

import com.expertise.ebudget.center.entity.CenterRequest;
import com.expertise.ebudget.center.entity.Center;
import com.expertise.ebudget.center.entity.CenterResponse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class CenterMapper {
    public Center toCenter(@Valid CenterRequest request) {
        return Center.builder()
                .id(request.id())
                .name(request.name())
                .location(request.location())
                .manager(request.manager())
                .amount(request.amount())
                .iban(request.iban())
                .build();
    }

    public CenterResponse fromCenter(Center center) {

        return new CenterResponse(
                center.getId(),
                center.getName(),
                center.getLocation(),
                center.getManager(),
                center.getAmount(),
                center.getIban()
        );
    }
}
