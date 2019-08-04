package com.eduardosantos.projetoshopping.repository;

import com.eduardosantos.projetoshopping.model.Loja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojaRepository extends CrudRepository<Loja, Long> {

}

