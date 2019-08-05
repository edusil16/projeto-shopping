package com.eduardosantos.projetoshopping.repository;

import com.eduardosantos.projetoshopping.model.Segmento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SegmentoRepository extends CrudRepository<Segmento, Long> {

    Iterable<Segmento> findAll();

    Segmento findOne(Segmento id_lojasegmento);
}
