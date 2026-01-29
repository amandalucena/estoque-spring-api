package com.amanda.estoqueAPI.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table (name = "item_venda", schema = "public")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class ItemVenda {

    @EmbeddedId //Diz que a chave primária é um objeto composto
    private ItemVendaId id;

    @ManyToOne
    @MapsId ("produtoID")
    @JoinColumn (name ="produto_id", nullable = false)
    private Produto produto;

    @ManyToOne
    @MapsId ("vendaID")
    @JoinColumn (name= "venda_id", nullable = false)
    private Venda venda;
}
