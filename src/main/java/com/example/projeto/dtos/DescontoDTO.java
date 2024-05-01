package com.example.projeto.dtos;

import com.example.projeto.models.DescontoModel;
import java.time.LocalDateTime;

public class DescontoDTO {

    private Double valor;
    private String tipo;
    private LocalDateTime dataExpiracao;

    // Adicionando construtor que aceita DescontoModel
    public DescontoDTO(DescontoModel model) {
        this.valor = model.getValor();
        this.tipo = model.getTipo();
        this.dataExpiracao = model.getDataExpiracao();
    }

    // Getters e setters
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDateTime dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }
}
