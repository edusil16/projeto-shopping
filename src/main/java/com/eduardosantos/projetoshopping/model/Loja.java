package com.eduardosantos.projetoshopping.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lojas")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(name = "cnpj")
    String cnpj;
    @Column(name = "numerodoandar")
    Integer numeroDoAndar;
    @Column(name = "datasaida")
    Date dataSaida;
    @ManyToOne
    @JoinColumn(name = "id_lojasegmento")
    Segmento tipoSegmento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Integer getNumeroDoAndar() {
        return numeroDoAndar;
    }

    public void setNumeroDoAndar(Integer numeroDoAndar) {
        this.numeroDoAndar = numeroDoAndar;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Segmento getTipoSegmento() {
        return tipoSegmento;
    }

    public void setTipoSegmento(Segmento tipoSegmento) {
        this.tipoSegmento = tipoSegmento;
    }
}
