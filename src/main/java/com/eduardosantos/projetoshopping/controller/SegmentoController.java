package com.eduardosantos.projetoshopping.controller;

import com.eduardosantos.projetoshopping.model.Segmento;
import com.eduardosantos.projetoshopping.repository.SegmentoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Map;

@Controller
public class SegmentoController {

    @Autowired
    SegmentoRepository segmentoRepository;

    @RequestMapping(value = "/segmento/create", method = RequestMethod.GET)
    public String createPage(){
        return "segmento/create";
    }

    @RequestMapping(value = "/segmento/create", method = RequestMethod.POST)
    public void salvar(@RequestParam("tiposegmento") String tipoSegmento, Map<String, Object> model){
        Segmento segmento = new Segmento();
        segmento.setTipoSegmento(tipoSegmento);
        segmentoRepository.save(segmento);
        model.put("message", "Segmento" + tipoSegmento + "Criado");
    }

    @RequestMapping(value = "/segmento/listar", method = RequestMethod.GET)
    public String listarTodos(Map<String, Object> model){
        Iterable<Segmento> all = segmentoRepository.findAll();
        model.put("listaSegmentos", all);
        return "segmento/listar";
    }

    @RequestMapping(value = "/segmento/editar", method = RequestMethod.GET)
    public String editarPage(@RequestParam("id")Long id, Map<String, Object> model){
        Segmento segmento = segmentoRepository.findOne(id);
        model.put("novosegmento", segmento);
        return "segmento/editar";
    }

    @RequestMapping(value = "/segmento/editar", method = RequestMethod.POST)
    public void atualizar(@RequestParam("tiposegmento")String tipoSegmento, @RequestParam("id")Long id,
                          Map<String, Object> model){
        Segmento segmento = segmentoRepository.findOne(id);
        segmento.setTipoSegmento(tipoSegmento);
        segmentoRepository.save(segmento);
        model.put("Mensagem", "Segmento" + tipoSegmento + "editado");
    }

}

