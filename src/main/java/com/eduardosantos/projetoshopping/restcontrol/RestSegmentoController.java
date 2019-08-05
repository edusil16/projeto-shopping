package com.eduardosantos.projetoshopping.restcontrol;

import com.eduardosantos.projetoshopping.model.Segmento;
import com.eduardosantos.projetoshopping.repository.SegmentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestSegmentoController {

    @Autowired
    SegmentoRepository segmentoRepository;

    @RequestMapping(value = "segmento/all", method = RequestMethod.GET)
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

    @RequestMapping(value = "segmento/atualizar", method = RequestMethod.PUT)
    public Segmento atualizar(@RequestParam("id") Long id, @RequestParam("tiposegmento") String tipoSegmento){
        Segmento segmento = segmentoRepository.findOne(id);
        segmento.setTipoSegmento(tipoSegmento);
        Segmento segmentoSalvo = segmentoRepository.save(segmento);
        return segmentoSalvo;
    }

    @RequestMapping(value = "segmento/deleta", method = RequestMethod.DELETE)
    public void apagar(@RequestParam("id") Long id) {
        segmentoRepository.delete(id);
    }
}
