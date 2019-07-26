package com.eduardosantos.projetoshopping.service;

import com.eduardosantos.projetoshopping.model.Loja;
import com.eduardosantos.projetoshopping.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LojaService {

    @Autowired
    private LojaRepository lojaRepository;

    public void inativar(Long idLoja){
        Loja loja = lojaRepository.findOne(idLoja);
        loja.setDataSaida(new Date());
        lojaRepository.save(loja);
    }
}
