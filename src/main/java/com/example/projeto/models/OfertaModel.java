package com.example.projeto.models;

import java.io.Serializable;
import java.util.List;

import com.example.projeto.enums.TipoOferta;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ofertas")
public class OfertaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer tipoOferta;
    private double valor;

    @ManyToOne
    @JoinColumn(name="imovel_id")
    @JsonIgnore
    private ImovelModel imovelModel;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UserModel userModel;

    @OneToMany(mappedBy="oferta", cascade = CascadeType.ALL)
    private List<DescontoModel> descontos; // Lista de descontos

    public TipoOferta getTipoOferta() {
        return TipoOferta.toEnum(tipoOferta);
    }

    public void setTipoUsuario(TipoOferta tipoOferta) {
        this.tipoOferta = tipoOferta.getCodigo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Métodos para manipular a lista de descontos
    public List<DescontoModel> getDescontos() {
        return descontos;
    }

    public void setDescontos(List<DescontoModel> descontos) {
        this.descontos = descontos;
    }

    public void addDesconto(DescontoModel desconto) {
        this.descontos.add(desconto);
        desconto.setOferta(this); // Certifique-se de que o desconto sabe a que oferta pertence
    }

    public void removeDesconto(DescontoModel desconto) {
        this.descontos.remove(desconto);
        desconto.setOferta(null); // Desvincular o desconto da oferta
    }
}
