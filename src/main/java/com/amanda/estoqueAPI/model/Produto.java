package com.amanda.estoqueAPI.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;
import java.util.UUID;

@Entity
@Table (name = "produto", schema = "public")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Produto {

    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    @Column (name = "nome", length = 100, nullable = false)
    private String nome;

    @Column (name = "tamanho", length = 20, nullable = false)
    private String tamanho;

    @Column (name = "quantidade")
    private int quantidade;

    @OneToMany (mappedBy = "produto")
    private List<ItemVenda> itens;

    @Column (name = "cor", length = 20, nullable = true )
    private String cor;

    @Column (name = "estampa", length = 100, nullable = true)
    private String estampa;

    @Column (name = "descricao", length = 100, nullable = true)
    private String descricao;


    public String toString (){
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tamanho=" + tamanho +
                ", quantidade=" + quantidade + '\'' +
                '}';
    }

}
