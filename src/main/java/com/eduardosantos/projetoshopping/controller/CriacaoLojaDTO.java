package com.eduardosantos.projetoshopping.controller;

public class CriacaoLojaDTO {
    public String cnpj;
    public Integer numeroAndar;
    public String tipoSegmento;

    public CriacaoLojaDTO(String cnpj, Integer numeroAndar, String tipoSegmento) {
        this.cnpj = cnpj;
        this.numeroAndar = numeroAndar;
        this.tipoSegmento = tipoSegmento;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Integer getNumeroAndar() {
        return numeroAndar;
    }

    public void setNumeroAndar(Integer numeroAndar) {
        this.numeroAndar = numeroAndar;
    }

    public String getTipoSegmento() {
        return tipoSegmento;
    }

    public void setTipoSegmento(String tipoSegmento) {
        this.tipoSegmento = tipoSegmento;
    }
}
