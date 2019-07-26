package com.eduardosantos.projetoshopping.controller;

import com.eduardosantos.projetoshopping.model.Segmento;
import com.eduardosantos.projetoshopping.repository.SegmentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

@Path("/segmentos")
@Component
public class SegmentoController {

    @Autowired
    SegmentoRepository segmentoRepository;

    @Path("/")
    @Produces("application/json")
    @GET
    public Iterable<Segmento> findAll(){
        return segmentoRepository.findAll();
    }

    @Path("/")
    @Produces("application/json")
    @POST
    public Segmento salvar(@QueryParam("tiposegmento")String tipoSegmento, @QueryParam("id") Long id){
        Segmento segmento = new Segmento();
        segmento.setTipoSegmento(tipoSegmento);
        Segmento segmentoSalvo = segmentoRepository.save(segmento);
        return segmentoSalvo;
    }

    @Path("/{id}")
    @Produces("application/json")
    @PUT
    public Segmento atualizar(@PathParam("id") Long id, @QueryParam("tiposegmento") String tipoSegmento){
        Segmento segmento =  segmentoRepository.findOne(id);
        segmento.setTipoSegmento(tipoSegmento);
        Segmento segmentoSalvo = segmentoRepository.save(segmento);
        return segmentoSalvo;
    }
}
