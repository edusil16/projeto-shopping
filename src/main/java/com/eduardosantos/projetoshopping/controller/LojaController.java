package com.eduardosantos.projetoshopping.controller;

import com.eduardosantos.projetoshopping.model.Loja;
import com.eduardosantos.projetoshopping.model.Segmento;
import com.eduardosantos.projetoshopping.repository.LojaRepository;
import com.eduardosantos.projetoshopping.repository.SegmentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LojaController {

    @Autowired
    LojaRepository lojaRepository;
    @Autowired
    SegmentoRepository segmentoRepository;

    @RequestMapping(value = "loja/all", method = RequestMethod.GET)
    public Iterable<Loja> findAll() {
        Iterable<Loja> todasLojas = lojaRepository.findAll();
        return todasLojas;
    }

    @RequestMapping(value = "loja/salvar", method = RequestMethod.POST)
    public Loja salvar(@RequestParam("cnpj") String cnpj, @RequestParam("numeroandar") Integer numeroAndar,
                       @RequestParam("datasaida") Date dataSaida, @RequestParam("tiposegmento") Segmento tipoSegmento) {
        Loja loja = new Loja();
        loja.setCnpj(cnpj);
        loja.setNumeroDoAndar(numeroAndar);
        loja.setDataSaida(dataSaida);
        loja.setTipoSegmento(tipoSegmento);
        lojaRepository.save(loja);
        return loja;
    }

    @RequestMapping(value = "/loja/atualizar", method = RequestMethod.PUT)
    public Loja atualizar(@RequestParam("cnpj") String cnpj, @RequestParam("numeroandar") Integer numeroAndar,
                          @RequestParam("datasaida") Date dataSaida, @RequestParam("tiposegmento") Segmento tipoSegmento,
                          @RequestParam("id") Long id) {
        Loja loja = lojaRepository.findOne(id);
        loja.setCnpj(cnpj);
        loja.setNumeroDoAndar(numeroAndar);
        loja.setTipoSegmento(tipoSegmento);
        loja.setDataSaida(dataSaida);
        lojaRepository.save(loja);
        return loja;
    }

    @RequestMapping(value = "/loja/remover", method = RequestMethod.DELETE)
    public String remover(@RequestParam("id") Long id){
        lojaRepository.delete(id);
        return "Loja com ID" + id + "deletada";
    }

    @RequestMapping(value = "loja/adcsegmento", method = RequestMethod.POST)
    public Loja addSegmento(@RequestParam("idLoja")Long idLoja, @RequestParam("idSegmento") Long idSegmento){
        Segmento segmento = segmentoRepository.findOne(idSegmento);
        Loja loja = lojaRepository.findOne(idLoja);
        loja.setTipoSegmento(segmento);
        return lojaRepository.save(loja);
    }

}
