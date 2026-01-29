package com.amanda.estoqueAPI.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.boot.archive.spi.AbstractArchiveDescriptor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name= "vendas", schema = "public")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)

public class Venda {

    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @Column (name = "data_hora")
    private LocalDateTime dataHora;

    @Column (name = "valor_bruto")
    private BigDecimal valorBruto;

    @Column (name= "valor_final")
    private BigDecimal valor_final;

    @Enumerated (EnumType.STRING)
    @Column (name= "status")
    private Status status;

    @Column (name = "id_usuario")
    private UUID idUsers;

    @OneToMany (
            mappedBy = "venda",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List <ItemVenda> itens;


}
