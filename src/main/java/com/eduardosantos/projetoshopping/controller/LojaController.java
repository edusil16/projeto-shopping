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
    public String createPage(Map<String, Object> model) {
        Iterable<Segmento> segmentos = segmentoRepository.findAll();
        model.put("listaSegmentos", segmentos);
        return "/loja/create";
    }

    @RequestMapping(value = "/loja/create", method = RequestMethod.POST)
    public void salvar(@RequestParam("cnpj") String cnpj, @RequestParam("numerodoandar") Integer numerodoandar,
                       @RequestParam("id_lojasegmento")Long id_lojasegmento, Map<String, Object> model) {
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

    @RequestMapping(value = "/loja/listar", method = RequestMethod.GET)
    public String listarPage(Map<String, Object> model) {
        Iterable<Loja> lojas = lojaRepository.findAll();
        model.put("lojaList", lojas);
        return "/loja/listar";
    }

    @RequestMapping(value = "/loja/editar", method = RequestMethod.GET)
    public String editarPage(@RequestParam("id") Long id, Map<String, Object> model) {
        Loja lojas = lojaRepository.findOne(id);
        model.put("lojaList", lojas);

        Iterable<Segmento> segmentos = segmentoRepository.findAll();
        model.put("listaSegmento", segmentos);
        return "loja/editar";
    }

    @RequestMapping(value = "/loja/editar", method = RequestMethod.POST)
    public void atualizar(@RequestParam("cnpj")String cnpj, @RequestParam("numerodoandar")Integer numeroDoAndar,
                          @RequestParam("idLoja")Long idLoja, @RequestParam("idSegmento")Long idSegmento,
                          Map<String, Object> model){
        Segmento segmento = segmentoRepository.findOne(idSegmento);
        Loja loja = lojaRepository.findOne(idLoja);
        loja.setCnpj(cnpj);
        loja.setNumeroDoAndar(numeroDoAndar);
        loja.setTipoSegmento(segmento);
        lojaRepository.save(loja);

        Iterable<Segmento> segmentos = segmentoRepository.findAll();
        model.put("listaSegmentos", segmentos);
        model.put("loja", loja);
        model.put("Mensagem", "Loja" + cnpj + "Editado");
    }

    @RequestMapping(value = "person/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id")Long id){
        lojaRepository.delete(id);
        return "redirect:/person/list";
    }


}

