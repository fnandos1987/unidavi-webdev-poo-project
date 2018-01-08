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

    private static final long serialVersionUID = 1L;

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
        int hash = 7;
        return 41 * hash + Objects.hashCode(this.pk);
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
        return Objects.equals(this.pk, other.pk);
    }
    
    
}