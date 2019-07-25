package com.eduardosantos.projetoshopping.controller;

import com.eduardosantos.projetoshopping.model.Segmento;
import com.eduardosantos.projetoshopping.repository.SegmentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SegmentoController {

    @Autowired
    SegmentoRepository segmentoRepository;

    @RequestMapping(value = "/segmento/all", method = RequestMethod.GET)
    public Iterable<Segmento> findAll(){
        return segmentoRepository.findAll();
    }

    @RequestMapping(value = "/segmento/salvar", method = RequestMethod.POST)
    public Segmento salvar(@RequestParam("tiposegmento") String tipoSegmento){
        Segmento segmento = new Segmento();
        segmento.setTipoSegmento(tipoSegmento);
        Segmento segmentoSalvo = segmentoRepository.save(segmento);
        return segmentoSalvo;
    }

    @RequestMapping(value = "segmento/atualizar", method = RequestMethod.GET)
    public Segmento atualizar(@RequestParam("tiposegmento") String tipoSegmento, @RequestParam("id") Long id){
        Segmento segmento =  segmentoRepository.findOne(id);
        segmento.setTipoSegmento(tipoSegmento);
        Segmento segmentoSalvo = segmentoRepository.save(segmento);
        return segmentoSalvo;

    }

}