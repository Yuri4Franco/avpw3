package com.example.projeto.dtos;

import com.example.projeto.models.DescontoModel;

public class OfertaDTO {

    private Integer id;
    // Outros atributos da oferta

    private DescontoModel desconto;

    // Getters e setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Outros getters e setters

    public DescontoModel getDesconto() {
        return desconto;
    }

    public void setDesconto(DescontoModel desconto) {
        this.desconto = desconto;
    }
}
