package com.eduardosantos.projetoshopping.restcontrol;

import com.eduardosantos.projetoshopping.controller.CriacaoLojaDTO;
import com.eduardosantos.projetoshopping.model.Loja;
import com.eduardosantos.projetoshopping.model.Segmento;
import com.eduardosantos.projetoshopping.repository.LojaRepository;
import com.eduardosantos.projetoshopping.repository.SegmentoRepository;
import com.eduardosantos.projetoshopping.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestLojaController {

    @Autowired
    LojaRepository lojaRepository;
    @Autowired
    SegmentoRepository segmentoRepository;
    @Autowired
    LojaService lojaService;

    @GetMapping(value = "lojas")
    public Iterable<Loja> findAll() {
        Iterable<Loja> todasLojas = lojaRepository.findAll();
        return todasLojas;
    }

    @PostMapping(value = "lojas")
    public Loja salvar(@RequestBody CriacaoLojaDTO criacaoLoja) {
        Loja loja = new Loja();
        loja.setCnpj(criacaoLoja.cnpj);
        loja.setNumeroDoAndar(criacaoLoja.numeroAndar);
        Segmento segmento = segmentoRepository.findOne(Long.parseLong(criacaoLoja.tipoSegmento));
        loja.setTipoSegmento(segmento);
        lojaRepository.save(loja);
        return loja;
    }

    @PutMapping(value = "lojas")
    public Loja atualizar(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "cnpj",required = false) String cnpj, @RequestParam(value = "numeroandar" ,required = false)
            Integer numeroAndar,@RequestBody Segmento tipoSegmento){
        Loja loja = lojaRepository.findOne(id);
        loja.setCnpj(cnpj);
        loja.setNumeroDoAndar(numeroAndar);
        loja.setTipoSegmento(tipoSegmento);
        lojaRepository.save(loja);
        return loja;
    }

    @DeleteMapping(value = "lojas")
    public void remover(@RequestParam("id") Long id) {
        lojaService.inativar(id);
    }

    @PostMapping(value = "lojas/segmentos")
    public Loja addSegmento(@RequestParam("idloja") Long idLoja, @RequestParam("idsegmento") Long idSegmento) {
        Segmento segmento = segmentoRepository.findOne(idSegmento);
        Loja loja = lojaRepository.findOne(idLoja);
        loja.setTipoSegmento(segmento);
        return lojaRepository.save(loja);
    }

}
