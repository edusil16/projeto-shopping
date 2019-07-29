package com.eduardosantos.projetoshopping.controller;

import com.eduardosantos.projetoshopping.service.LojaService;
import com.eduardosantos.projetoshopping.model.Loja;
import com.eduardosantos.projetoshopping.model.Segmento;
import com.eduardosantos.projetoshopping.repository.LojaRepository;
import com.eduardosantos.projetoshopping.repository.SegmentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import java.util.Date;

@Path("/lojas")
@Component
public class LojaController {

    @Autowired
    LojaRepository lojaRepository;
    @Autowired
    SegmentoRepository segmentoRepository;
    @Autowired
    LojaService lojaService;


    @GET
    @Produces("application/json")
    public Iterable<Loja> findAll() {
        Iterable<Loja> todasLojas = lojaRepository.findAll();
        return todasLojas;
    }

    @POST
    @Produces("application/json")
    public Loja salvar(@QueryParam("cnpj") String cnpj, @QueryParam("numeroandar")Integer numeroAndar,
                       @QueryParam("datasaida")Date dataSaida, @QueryParam("tiposegmento")Segmento tipoSegmento){
        Loja loja = new Loja();
        loja.setCnpj(cnpj);
        loja.setNumeroDoAndar(numeroAndar);
        loja.setDataSaida(dataSaida);
        loja.setTipoSegmento(tipoSegmento);
        lojaRepository.save(loja);
        return loja;
    }

    @PUT
    @Produces("application/json")
    public Loja atualizar(@QueryParam("cnpj") String cnpj, @QueryParam("numeroandar")Integer numeroAndar,
                          @QueryParam("datasaida")Date dataSaida, @QueryParam("tiposegmento")Segmento tipoSegmento,
                          @QueryParam("id") Long id){
        Loja loja = lojaRepository.findOne(id);
        loja.setCnpj(cnpj);
        loja.setNumeroDoAndar(numeroAndar);
        loja.setTipoSegmento(tipoSegmento);
        loja.setDataSaida(dataSaida);
        lojaRepository.save(loja);
        return loja;
    }

    @DELETE
    @Produces("application/json")
    public void remover(@QueryParam("id")Long id){
        lojaService.inativar(id);
    }

    @POST
    @Produces("application/json")
    public Loja addSegmento(@QueryParam("idloja")Long idLoja, @QueryParam("idsegmento")Long idSegmento){
        Segmento segmento = segmentoRepository.findOne(idSegmento);
        Loja loja = lojaRepository.findOne(idLoja);
        loja.setTipoSegmento(segmento);
        return lojaRepository.save(loja);
    }



}
