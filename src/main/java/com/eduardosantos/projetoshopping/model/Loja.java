package com.eduardosantos.projetoshopping.model;

import javax.persistence.*;

@Entity
@Table(name = "lojas")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "cnpj")
    String cnpj;
    @Column(name = "numerodoandar")
    Integer numeroDoAndar;
    @ManyToOne
    @JoinColumn(name = "id_lojasegmento")
    Segmento tipoSegmento;

}
