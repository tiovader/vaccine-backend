package com.undb.vaccine.backend.api.fact;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.*;

import java.time.LocalDate;
import java.util.Date;

@Transactional
@Service
public class FactService {
    @Autowired
    private AplicacaoVacinaRepository repository;

    public Page<IFactAplicacaoVacina> getFactAplicacaoVacina(Date start, Date end, Pageable pageRequest) {
        if (start == null) start = java.sql.Date.valueOf(LocalDate.of(2020, 1, 1));
        if (end == null) end = java.sql.Date.valueOf(LocalDate.now());
        return repository.getFactAplicacaoVacina(start, end, pageRequest);
    }
}
