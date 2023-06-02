package com.undb.vaccine.backend.api.dimension;
import javax.persistence.Table;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_regiao")
    private Regiao regiao;

    @Column
    private String nome;

    @Column
    private String sigla;
}
