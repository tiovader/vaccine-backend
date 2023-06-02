package com.undb.vaccine.backend.api.fact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/api", method = RequestMethod.GET)
public class FactController {
    @Autowired
    private FactService service;

    @RequestMapping(value = "/fact", method = RequestMethod.GET)
    public List<IFactAplicacaoVacina> getFactAplicacaoVacina(
            @RequestParam(defaultValue = "") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd") Date start,
            @RequestParam(defaultValue = "") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd") Date end,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "500") int size
    ) {
        Pageable pageRequest = PageRequest.of(page, size);
        return service.getFactAplicacaoVacina(start, end, pageRequest).toList();
    }
}
