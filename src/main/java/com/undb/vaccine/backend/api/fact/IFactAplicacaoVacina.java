package com.undb.vaccine.backend.api.fact;

import java.util.Date;

public interface IFactAplicacaoVacina {
    long getIdUnidadeBasica();
    Date getDataAplicacao();
    long getIdadeSemanas();
    String getGenero();
    long getCount();
}

