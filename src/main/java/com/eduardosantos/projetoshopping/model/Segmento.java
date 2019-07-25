package com.eduardosantos.projetoshopping.model;

import javax.persistence.*;
@Entity
@Table(name = "segmentos")
public class Segmento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "tiposegmento")
    String tipoSegmento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoSegmento() {
        return tipoSegmento;
    }

    public void setTipoSegmento(String tipoSegmento) {
        this.tipoSegmento = tipoSegmento;
    }
}
