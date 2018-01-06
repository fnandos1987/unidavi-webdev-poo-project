package br.edu.unidavi.oscar.model;

import java.io.Serializable;
import java.util.Set;

/**
 * Model class of pessoa.
 *
 * @author generated by ERMaster
 * @version $Id$
 */
public class Pessoa implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * pesCodigo.
     */
    private Integer pesCodigo;

    /**
     * nome.
     */
    private String nome;

    /**
     * sexo.
     */
    private String sexo;

    /**
     * anosCarreira.
     */
    private Integer anosCarreira;

    /**
     * nomeacoes.
     */
    private Integer nomeacoes;

    /**
     * conquistas.
     */
    private Integer conquistas;

    /**
     * The set of elenco.
     */
    private Set<ElencoPk> elencoSet;

    /**
     * Constructor.
     */
    public Pessoa() {

    }

    public Pessoa(Integer pesCodigo, String nome) {
        this.pesCodigo = pesCodigo;
        this.nome = nome;
    }

    public Pessoa(Integer pesCodigo, String nome, String sexo, Integer anosCarreira, Integer nomeacoes,
            Integer conquistas) {
        super();
        this.pesCodigo = pesCodigo;
        this.nome = nome;
        this.sexo = sexo;
        this.anosCarreira = anosCarreira;
        this.nomeacoes = nomeacoes;
        this.conquistas = conquistas;
    }

    /**
     * Set the pesCodigo.
     *
     * @param pesCodigo pesCodigo
     */
    public void setPesCodigo(Integer pesCodigo) {
        this.pesCodigo = pesCodigo;
    }

    /**
     * Get the pesCodigo.
     *
     * @return pesCodigo
     */
    public Integer getPesCodigo() {
        return this.pesCodigo;
    }

    /**
     * Set the nome.
     *
     * @param nome nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Get the nome.
     *
     * @return nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Set the sexo.
     *
     * @param sexo sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Get the sexo.
     *
     * @return sexo
     */
    public String getSexo() {
        return this.sexo;
    }

    /**
     * Set the anosCarreira.
     *
     * @param anosCarreira anosCarreira
     */
    public void setAnosCarreira(Integer anosCarreira) {
        this.anosCarreira = anosCarreira;
    }

    /**
     * Get the anosCarreira.
     *
     * @return anosCarreira
     */
    public Integer getAnosCarreira() {
        return this.anosCarreira;
    }

    /**
     * Set the nomeacoes.
     *
     * @param nomeacoes nomeacoes
     */
    public void setNomeacoes(Integer nomeacoes) {
        this.nomeacoes = nomeacoes;
    }

    /**
     * Get the nomeacoes.
     *
     * @return nomeacoes
     */
    public Integer getNomeacoes() {
        return this.nomeacoes;
    }

    /**
     * Set the conquistas.
     *
     * @param conquistas conquistas
     */
    public void setConquistas(Integer conquistas) {
        this.conquistas = conquistas;
    }

    /**
     * Get the conquistas.
     *
     * @return conquistas
     */
    public Integer getConquistas() {
        return this.conquistas;
    }

    /**
     * Set the set of the elenco.
     *
     * @param elencoSet The set of elenco
     */
    public void setElencoSet(Set<ElencoPk> elencoSet) {
        this.elencoSet = elencoSet;
    }

    /**
     * Add the elenco.
     *
     * @param elenco elenco
     */
    public void addElenco(ElencoPk elenco) {
        this.elencoSet.add(elenco);
    }

    /**
     * Get the set of the elenco.
     *
     * @return The set of elenco
     */
    public Set<ElencoPk> getElencoSet() {
        return this.elencoSet;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pesCodigo == null) ? 0 : pesCodigo.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
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
        Pessoa other = (Pessoa) obj;
        if (pesCodigo == null) {
            if (other.pesCodigo != null) {
                return false;
            }
        } else if (!pesCodigo.equals(other.pesCodigo)) {
            return false;
        }
        return true;
    }

}
