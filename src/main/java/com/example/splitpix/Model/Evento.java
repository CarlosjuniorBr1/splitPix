package com.example.splitpix.Model;

import com.example.splitpix.Enum.StatusEvento;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private BigDecimal valorTotal;

    @Column(nullable = false)
    private String chavePix;

    @Column(nullable = false, unique = true)
    private String linkUnico;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEvento status;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public String getLinkUnico() {
        return linkUnico;
    }

    public void setLinkUnico(String linkUnico) {
        this.linkUnico = linkUnico;
    }
}
