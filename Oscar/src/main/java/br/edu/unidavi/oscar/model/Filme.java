package br.edu.unidavi.oscar.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Model class of filme.
 *
 * @author fernando.schwambach
 */
public class Filme implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * filCodigo.
     */
    private Integer filCodigo;

    /**
     * titulo.
     */
    private String titulo;

    /**
     * genero.
     */
    private Short genero;

    /**
     * paisOrigem.
     */
    private String paisOrigem;
    
    /**
     * estreia
     */
    private Date estreia;
    
    /**
     * duracao
     */
    private Short duracao;
    
    /**
     * sinopse
     */
    private String sinopse;

    /**
     * The set of elenco.
     */
    private Set<ElencoPk> elencoSet;

    /**
     * The set of indicacao.
     */
    private Set<Indicacao> indicacaoSet;

    /**
     * Constructor.
     */
    public Filme() {        
    }

    public Filme(Integer filCodigo, String titulo) {
        this.filCodigo = filCodigo;
        this.titulo = titulo;
    }

    public Filme(Integer filCodigo, String titulo, Short genero, String paisOrigem, Date estreia, Short duracao, String sinopse) {
        this.filCodigo = filCodigo;
        this.titulo = titulo;
        this.genero = genero;
        this.paisOrigem = paisOrigem;
        this.estreia = estreia;
        this.duracao = duracao;
        this.sinopse = sinopse;
    }   
    

    /**
     * Set the filCodigo.
     *
     * @param filCodigo filCodigo
     */
    public void setFilCodigo(Integer filCodigo) {
        this.filCodigo = filCodigo;
    }

    /**
     * Get the filCodigo.
     *
     * @return filCodigo
     */
    public Integer getFilCodigo() {
        return this.filCodigo;
    }

    /**
     * Set the titulo.
     *
     * @param titulo titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Get the titulo.
     *
     * @return titulo
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Set the genero.
     *
     * @param genero genero
     */
    public void setGenero(Short genero) {
        this.genero = genero;
    }

    /**
     * Get the genero.
     *
     * @return genero
     */
    public Short getGenero() {
        return this.genero;
    }
    
    /**
     * Retorna a descrição do genero da enum GeneroFilme
     * @return String
     */
    public String getDescricaoGenero(){        
        return GeneroFilme.getById(this.genero.intValue()).getDescricao();
    }

    /**
     * Set the paisOrigem.
     *
     * @param paisOrigem paisOrigem
     */
    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    /**
     * Get the paisOrigem.
     *
     * @return paisOrigem
     */
    public String getPaisOrigem() {
        return this.paisOrigem;
    }

    public Date getEstreia() {
        return estreia;
    }

    public void setEstreia(Date estreia) {
        this.estreia = estreia;
    }

    public Short getDuracao() {
        return duracao;
    }

    public void setDuracao(Short duracao) {
        this.duracao = duracao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
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
     * Set the set of the indicacao.
     *
     * @param indicacaoSet The set of indicacao
     */
    public void setIndicacaoSet(Set<Indicacao> indicacaoSet) {
        this.indicacaoSet = indicacaoSet;
    }

    /**
     * Add the indicacao.
     *
     * @param indicacao indicacao
     */
    public void addIndicacao(Indicacao indicacao) {
        this.indicacaoSet.add(indicacao);
    }

    /**
     * Get the set of the indicacao.
     *
     * @return The set of indicacao
     */
    public Set<Indicacao> getIndicacaoSet() {
        return this.indicacaoSet;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((filCodigo == null) ? 0 : filCodigo.hashCode());
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
        Filme other = (Filme) obj;
        if (filCodigo == null) {
            if (other.filCodigo != null) {
                return false;
            }
        } else if (!filCodigo.equals(other.filCodigo)) {
            return false;
        }
        return true;
    }

}
