package com.aps.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aps.api.model.DenunciaDespesa;

@Repository
public interface IDenunciaDespesaRepository extends JpaRepository<DenunciaDespesa, Long> {

}
