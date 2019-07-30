package com.eduardosantos.projetoshopping.controller;

import com.eduardosantos.projetoshopping.model.Segmento;
import com.eduardosantos.projetoshopping.repository.SegmentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@Component
@RestController
public class SegmentoController {

    @Autowired
    SegmentoRepository segmentoRepository;

    @RequestMapping(value = "segmentos/all", method = RequestMethod.GET)
    public Iterable<Segmento> findAll(){
        return segmentoRepository.findAll();
    }

    @RequestMapping(value = "segmentos/save", method = RequestMethod.POST)
    public Segmento salvar(@RequestParam("tiposegmento")String tipoSegmento, @RequestParam("id") Long id){
        Segmento segmento = new Segmento();
        segmento.setTipoSegmento(tipoSegmento);
        Segmento segmentoSalvo = segmentoRepository.save(segmento);
        return segmentoSalvo;
    }

    @RequestMapping(value = "segmentos/atualizar", method = RequestMethod.PUT)
    public Segmento atualizar(@RequestParam("id") Long id, @RequestParam("tiposegmento") String tipoSegmento){
        Segmento segmento =  segmentoRepository.findOne(id);
        segmento.setTipoSegmento(tipoSegmento);
        Segmento segmentoSalvo = segmentoRepository.save(segmento);
        return segmentoSalvo;
    }

    @RequestMapping(value = "segmentos/deleta", method = RequestMethod.DELETE)
    public void apagar(@RequestParam("id")Long id){
        segmentoRepository.delete(id);
    }
}
