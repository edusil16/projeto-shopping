package com.eduardosantos.projetoshopping.controller;

import com.eduardosantos.projetoshopping.service.LojaService;
import com.eduardosantos.projetoshopping.model.Loja;
import com.eduardosantos.projetoshopping.model.Segmento;
import com.eduardosantos.projetoshopping.repository.LojaRepository;
import com.eduardosantos.projetoshopping.repository.SegmentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@Controller
public class LojaController {

    @Autowired
    LojaRepository lojaRepository;
    @Autowired
    SegmentoRepository segmentoRepository;
    @Autowired
    LojaService lojaService;

    @RequestMapping(value = "/loja/create", method = RequestMethod.GET)
    public String createPage(Map<String, Object> model){
        Iterable<Segmento> segmentos = segmentoRepository.findAll();
        model.put("listaSegmentos", segmentos);
        return "loja/create";
    }

    @RequestMapping(value = "/loja/create", method = RequestMethod.POST)
    public void salvar(@RequestParam("cnpj") String cnpj, @RequestParam("numerodoandar") Integer numerodoandar,
                       @RequestParam("id_lojasegmento")Segmento id_lojasegmento, Map<String, Object> model){
        Segmento segmento = segmentoRepository.findOne(id_lojasegmento);
        Loja loja = new Loja();
        loja.setCnpj(cnpj);
        loja.setNumeroDoAndar(numerodoandar);
        loja.setTipoSegmento(segmento);
        lojaRepository.save(loja);

        Iterable<Segmento> segmentos = segmentoRepository.findAll();
        model.put("listaSegmentos", segmentos);
        model.put("message", "Loja" + cnpj + "Criado");
    }

}
