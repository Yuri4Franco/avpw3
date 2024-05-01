package com.example.projeto.service;

import com.example.projeto.dtos.DescontoDTO;
import com.example.projeto.models.DescontoModel;
import com.example.projeto.repository.DescontoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DescontoService {

    @Autowired
    private DescontoRepository descontoRepository;

    public List<DescontoModel> getAll() {
        return descontoRepository.findAll();
    }

    public DescontoModel findById(Integer id) {
        Optional<DescontoModel> descontoOptional = descontoRepository.findById(id);
        return descontoOptional.orElse(null);
    }

    public DescontoModel create(DescontoModel desconto) {
        return descontoRepository.save(desconto);
    }

    public DescontoModel update(DescontoModel desconto) {
        return descontoRepository.save(desconto);
    }

    public void deleteById(Integer id) {
        descontoRepository.deleteById(id);
    }

      public DescontoModel criarDesconto(DescontoDTO descontoDTO) {
        // Criar uma instância de DescontoModel e preencher com os dados do DTO
        DescontoModel descontoModel = new DescontoModel();
        descontoModel.setValor(descontoDTO.getValor());
        descontoModel.setTipo(descontoDTO.getTipo());
        descontoModel.setDataExpiracao(descontoDTO.getDataExpiracao());

        // Salvar o novo desconto no banco de dados
        return descontoRepository.save(descontoModel);
    }

    public DescontoModel buscarDescontoPorId(Integer id) {
        // Buscar o desconto pelo ID no banco de dados
        return descontoRepository.findById(id).orElse(null);
    }

    public DescontoModel atualizarDesconto(Integer id, DescontoDTO descontoDTO) {
        // Verificar se o desconto com o ID especificado existe no banco de dados
        DescontoModel descontoModel = descontoRepository.findById(id).orElse(null);
        if (descontoModel != null) {
            // Atualizar os dados do desconto com base no DTO
            descontoModel.setValor(descontoDTO.getValor());
            descontoModel.setTipo(descontoDTO.getTipo());
            descontoModel.setDataExpiracao(descontoDTO.getDataExpiracao());

            // Salvar as alterações no banco de dados
            return descontoRepository.save(descontoModel);
        } else {
            // Se o desconto não for encontrado, retornar null
            return null;
        }
    }

    public void deletarDesconto(Integer id) {
        // Deletar o desconto pelo ID
        descontoRepository.deleteById(id);
    }
}
