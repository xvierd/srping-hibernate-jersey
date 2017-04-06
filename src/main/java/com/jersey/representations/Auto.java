package com.jersey.representations;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Xavier Guti&#233;rrez
 *         06/04/17.
 */
@Entity
@Table(name = "auto")
public class Auto extends Base implements Serializable {


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Tipo tipo;

    public Auto() {

    }

    public Auto(Long id, String nombre, float precio) {
        super(id, nombre, precio);
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
