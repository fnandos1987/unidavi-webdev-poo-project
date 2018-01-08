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
public class IndicacaoPk implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    /**
     * ano
     */
    private Short ano;

    /**
     * categoria.
     */
    private Categoria categoria;

    /**
     * filme.
     */
    private Filme filme;

    public IndicacaoPk() {
    }
    
    public IndicacaoPk(Short ano, Categoria categoria, Filme filme) {
        this.ano = ano;
        this.categoria = categoria;
        this.filme = filme;
    }   
    

    public Short getAno() {
        return ano;
    }

    public void setAno(Short ano) {
        this.ano = ano;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return 47 * hash + (Objects.hashCode(this.ano) + Objects.hashCode(this.categoria) + Objects.hashCode(this.filme));
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
        final IndicacaoPk other = (IndicacaoPk) obj;
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        return Objects.equals(this.filme, other.filme);
    }    
}