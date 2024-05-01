package com.example.projeto.service;

import com.example.projeto.models.DescontoModel;
import com.example.projeto.models.OfertaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.projeto.repository.DescontoRepository;
import com.example.projeto.repository.OfertaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OfertaService {

    @Autowired
    private OfertaRepository ofertaRepository;

    @Autowired
    private DescontoRepository descontoRepository;

    @Transactional(readOnly = true)
    public List<OfertaModel> buscarOfertasComDesconto() {
        // Unifica os métodos para buscar ofertas com desconto
        return ofertaRepository.findOfertasComDesconto();
    }

    @Transactional(readOnly = true)
    public List<OfertaModel> getAll() {
        return ofertaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public OfertaModel findById(Integer id) {
        Optional<OfertaModel> ofertaOptional = ofertaRepository.findById(id);
        return ofertaOptional.orElse(null);
    }

    @Transactional
    public OfertaModel insert(OfertaModel model) {
        return ofertaRepository.save(model);
    }

    @Transactional
    public OfertaModel update(OfertaModel oferta) {
        return ofertaRepository.save(oferta);
    }

    @Transactional
    public void deleteById(Integer id) {
        ofertaRepository.deleteById(id);
    }

    @Transactional
    public void associarDesconto(OfertaModel oferta, DescontoModel desconto) {
        oferta.addDesconto(desconto);
        ofertaRepository.save(oferta);
    }
}
