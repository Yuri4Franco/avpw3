package com.example.projeto.repository;

import com.example.projeto.models.ImovelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImovelRepository extends JpaRepository<ImovelModel, Integer> {
    // Altere a query para verificar se a lista de descontos não está vazia
    List<ImovelModel> findDistinctByOfertas_DescontosIsNotEmpty();
}
