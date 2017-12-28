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

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * pk
     */
    private IndicacaoPk pk;
    
    /**
     * pessoa
     */
    private Pessoa pessoa;

    /**
     * The set of vencedor.
     */
    private Set<Vencedor> vencedorSet;

    /**
     * Constructor.
     */
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
    

    /**
     * Set the set of the vencedor.
     *
     * @param vencedorSet The set of vencedor
     */
    public void setVencedorSet(Set<Vencedor> vencedorSet) {
        this.vencedorSet = vencedorSet;
    }

    /**
     * Add the vencedor.
     *
     * @param vencedor vencedor
     */
    public void addVencedor(Vencedor vencedor) {
        this.vencedorSet.add(vencedor);
    }

    /**
     * Get the set of the vencedor.
     *
     * @return The set of vencedor
     */
    public Set<Vencedor> getVencedorSet() {
        return this.vencedorSet;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.pk);
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
        if (!Objects.equals(this.pk, other.pk)) {
            return false;
        }
        return true;
    }
}
