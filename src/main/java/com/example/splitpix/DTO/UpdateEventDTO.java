package com.example.splitpix.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public class UpdateEventDTO {

   @NotBlank(message = "O nome do evento é obrigatório.")
   private String nome;

   @NotBlank(message = "O valor total é obrigatório.")
   private BigDecimal valorTotal;

   @NotBlank(message = "A chave Pix é obrigatória.")
   private String chavePix;

   @NotBlank(message = "O link único é obrigatório.")
   private String linkUnico;

   @NotBlank(message = "O status do evento é obrigatório.")
   private String status;

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

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }
}
