package com.eduardosantos.projetoshopping.repository;

import com.eduardosantos.projetoshopping.model.Segmento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SegmentoRepository extends CrudRepository<Segmento, Long> {

}
