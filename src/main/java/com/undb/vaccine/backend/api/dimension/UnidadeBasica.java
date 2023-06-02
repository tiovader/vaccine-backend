package com.undb.vaccine.backend.api.dimension;
import javax.persistence.Table;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "unidade_basica")
public class UnidadeBasica {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @Column
    private String bairro;

    @Column
    private String logradouro;
}