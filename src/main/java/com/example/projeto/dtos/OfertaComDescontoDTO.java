package com.example.projeto.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.example.projeto.models.OfertaModel;

public class OfertaComDescontoDTO {
    private Integer id;
    private double valor;
    private String nomeImovel; // Supondo que existe uma propriedade "descricao" em ImovelModel
    private List<DescontoDTO> descontos;

    public OfertaComDescontoDTO(OfertaModel model) {
        this.id = model.getId();
        this.valor = model.getValor();
        this.nomeImovel = model.getImovelModel().getDescricao(); // Confirmando que você tem uma descrição no ImovelModel
        this.descontos = model.getDescontos().stream()
            .map(DescontoDTO::new)
            .collect(Collectors.toList());
    }

    // Getters e setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNomeImovel() {
        return nomeImovel;
    }

    public void setNomeImovel(String nomeImovel) {
        this.nomeImovel = nomeImovel;
    }

    public List<DescontoDTO> getDescontos() {
        return descontos;
    }

    public void setDescontos(List<DescontoDTO> descontos) {
        this.descontos = descontos;
    }
}
