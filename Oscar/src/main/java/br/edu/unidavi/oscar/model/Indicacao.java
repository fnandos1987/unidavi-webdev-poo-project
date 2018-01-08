package br.edu.unidavi.oscar.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Model class of indicacao.
 *
 * @author fernando.schwambach
 */
public class Indicacao implements Serializable {
    
    private static final long serialVersionUID = 1L;    
    private IndicacaoPk pk;
    private Pessoa pessoa;
    
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

    @Override
    public int hashCode() {
        int hash = 5;
        return 97 * hash + Objects.hashCode(this.pk);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Indicacao other = (Indicacao) obj;
        if (!Objects.equals(this.pk, other.pk)) {
            return false;
        }
        return Objects.equals(this.pessoa, other.pessoa);
    }
    
}
