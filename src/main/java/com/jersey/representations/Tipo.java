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
@Table(name = "tipo")
public class Tipo extends Base implements Serializable {


    @OneToMany(fetch = FetchType.LAZY)
    private Set<Auto> autos = new HashSet<Auto>();

    @ManyToMany(mappedBy = "tipos")
    private Set<Accesorio> accesorios = new HashSet<Accesorio>();

    public Tipo() {

    }

    public Tipo(Long id, String nombre, float precio) {
        super(id, nombre, precio);
    }

    public Set<Accesorio> getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(Set<Accesorio> accesorios) {
        this.accesorios = accesorios;
    }

    public Set<Auto> getAutos() {
        return autos;
    }

    public void setAutos(Set<Auto> autos) {
        this.autos = autos;
    }
}
