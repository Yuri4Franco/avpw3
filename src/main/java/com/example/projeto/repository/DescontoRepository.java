package com.example.projeto.repository;

import com.example.projeto.models.DescontoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescontoRepository extends JpaRepository<DescontoModel, Integer> {
}
