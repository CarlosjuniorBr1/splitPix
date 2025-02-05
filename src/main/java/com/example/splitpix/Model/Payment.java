package com.example.splitpix.Model;

import com.example.splitpix.Enum.StatusPayment;
import jakarta.persistence.*;

@Entity
@Table(name = "pagamento")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Event event;

    @Column(nullable = false)
    private String nomePagador;

    @Lob
    @Column(name = "comprovante", nullable = false)
    private byte[] comprovante;  // Armazenar a imagem como BLOB (byte array)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPayment status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvento() {
        return event;
    }

    public void setEvento(Event event) {
        this.event = event;
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

    public StatusPayment getStatus() {
        return status;
    }

    public void setStatus(StatusPayment status) {
        this.status = status;
    }
}
