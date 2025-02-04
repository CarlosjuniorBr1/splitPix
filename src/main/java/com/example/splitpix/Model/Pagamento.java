package com.example.splitpix.Model;

import com.example.splitpix.Enum.StatusEvento;
import com.example.splitpix.Enum.StatusPagamento;
import jakarta.persistence.*;

@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    @Column(nullable = false)
    private String nomePagador;

    @Lob
    @Column(name = "comprovante", nullable = false)
    private byte[] comprovante;  // Armazenar a imagem como BLOB (byte array)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPagamento status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getNomePagador() {
        return nomePagador;
    }

    public void setNomePagador(String nomePagador) {
        this.nomePagador = nomePagador;
    }

    public byte[] getComprovante() {
        return comprovante;
    }

    public void setComprovante(byte[] comprovante) {
        this.comprovante = comprovante;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }
}
