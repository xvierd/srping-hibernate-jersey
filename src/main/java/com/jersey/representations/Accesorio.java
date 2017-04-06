package com.jersey.representations;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Xavier Guti&#233;rrez
 *         06/04/17.
 */
@Entity
@Table(name = "accesorio")
public class Accesorio extends Base implements Serializable {


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "accesorio_tipo",
            joinColumns = {@JoinColumn(name = "accesorio_id")},
            inverseJoinColumns = {@JoinColumn(name = "tipo_id")})
    private Set<Tipo> tipos = new HashSet<Tipo>();

    public Accesorio() {
    }

    public Accesorio(Long id, String nombre, float precio) {
        super(id, nombre, precio);
    }


    public Set<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(Set<Tipo> tipos) {
        this.tipos = tipos;
    }
}
