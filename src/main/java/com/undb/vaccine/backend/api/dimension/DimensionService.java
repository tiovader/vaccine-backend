package com.undb.vaccine.backend.api.dimension;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.*;

@Transactional
@Service
public class DimensionService {
    @Autowired
    private UnidadeBasicaRepository repository;

    public Page<UnidadeBasica> listAll(Pageable pageRequest) {
        return repository.findAll(pageRequest);
    }
    public Page<IDimensionFilial> getDimensionFilial(Pageable pageRequest) {
        return repository.getDimensionFilial(pageRequest);
    }

    public Optional<UnidadeBasica> get(Long id) {
        return repository.findById(id);
    }


    public UnidadeBasica get(String nomeFantasia) {
        return repository.findByNomeFantasiaLike("%" + nomeFantasia + "%");
    }

    public Page<UnidadeBasica> listByEstado(String nome, Pageable pageRequest) {
        return repository.findByMunicipioEstadoNomeLike("%" + nome + "%", pageRequest);
    }

    public Page<UnidadeBasica> listByMunicipio(String nome, Pageable pageRequest) {
//        PageRequest pageRequest = PageRequest.of(pageNum, size, );
        return repository.findByMunicipioNomeLike("%" + nome + "%", pageRequest);
    }

    public Page<UnidadeBasica> listByMunicipioAndEstado(String nomeMunicipio, String nomeEstado, Pageable pageRequest) {
        return repository.findByMunicipioNomeLikeAndMunicipioEstadoNomeLike("%" + nomeMunicipio + "%", "%" + nomeEstado + "%", pageRequest
        );
    }

    public void create(UnidadeBasica unidadeBasica) {
        repository.save(unidadeBasica);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
