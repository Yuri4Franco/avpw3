package com.example.projeto.repository;

import com.example.projeto.models.OfertaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfertaRepository extends JpaRepository<OfertaModel, Integer> {

    // Adjusted query to find offers with at least one discount
    @Query("SELECT o FROM OfertaModel o JOIN o.descontos d WHERE d IS NOT NULL")
    List<OfertaModel> findOfertasComDesconto();

    // This will effectively do the same as the above query
    @Query("SELECT o FROM OfertaModel o JOIN o.descontos d WHERE d IS NOT NULL")
    List<OfertaModel> findByDescontoIsNotNull();
}
