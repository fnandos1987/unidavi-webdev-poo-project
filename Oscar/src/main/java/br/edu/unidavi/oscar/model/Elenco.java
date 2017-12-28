/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.oscar.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author fernando.schwambach
 */
public class Elenco implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * pk
     */
    private ElencoPk pk;

    public Elenco() {
    }

    public Elenco(ElencoPk pk) {
        this.pk = pk;
    }

    public ElencoPk getPk() {
        return pk;
    }

    public void setPk(ElencoPk pk) {
        this.pk = pk;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.pk);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Elenco other = (Elenco) obj;
        if (!Objects.equals(this.pk, other.pk)) {
            return false;
        }
        return true;
    }
    
}
