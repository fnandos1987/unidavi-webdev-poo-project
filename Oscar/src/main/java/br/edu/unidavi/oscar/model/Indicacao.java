package br.edu.unidavi.oscar.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * Model class of indicacao.
 *
 * @author fernando.schwambach
 */
public class Indicacao implements Serializable {
    
    private static final long serialVersionUID = 1L;    
    private IndicacaoPk pk;
    private Pessoa pessoa;
    private Set<Vencedor> vencedorSet;

    public Indicacao() {
    }

    public Indicacao(IndicacaoPk pk, Pessoa pessoa) {
        this.pk = pk;
        this.pessoa = pessoa;
    }

    public IndicacaoPk getPk() {
        return pk;
    }

    public void setPk(IndicacaoPk pk) {
        this.pk = pk;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Set<Vencedor> getVencedorSet() {
        return vencedorSet;
    }

    public void setVencedorSet(Set<Vencedor> vencedorSet) {
        this.vencedorSet = vencedorSet;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.pk);
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
        final Indicacao other = (Indicacao) obj;
        return Objects.equals(this.pk, other.pk);
    }    
}
