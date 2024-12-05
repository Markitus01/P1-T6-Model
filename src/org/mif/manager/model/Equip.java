/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mif.manager.model;

import java.time.LocalDate;

/**
 *
 * @author markos
 */
public class Equip
{
    private int id;
    private String nom;
    private String tipus;
    private String categoria;
    private LocalDate temporada;

    public Equip(){}
    
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        if (nom == null || nom.length() == 0 || nom.length() > 32)
        {
            throw new RuntimeException("Nom obligatori i no més llarg de 32 caràcters");
        }
        
        this.nom = nom;
    }

    public String getTipus()
    {
        return tipus;
    }

    public void setTipus(String tipus)
    {
        if (tipus == null || tipus.length() != 1)
        {
            throw new RuntimeException("Tipus és obligatori.");
        }
        
        this.tipus = tipus;
    }

    public String getCategoria()
    {
        return categoria;
    }

    public void setCategoria(String categoria)
    {
        if (categoria == null || categoria.isEmpty())
        {
            throw new RuntimeException("Categoria és obligatoria");
        }
        
        this.categoria = categoria;
    }

    public LocalDate getTemporada()
    {
        return temporada;
    }

    public void setTemporada(LocalDate temporada)
    {
        if (temporada == null)
        {
            throw new RuntimeException("Temporada és obligatoria.");
        }
        
        this.temporada = temporada;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
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
        final Equip other = (Equip) obj;
        return this.id == other.id;
    }

    

    @Override
    public String toString() {
        return "Equip{Nom=" + nom + ", Tipus=" + tipus + ", Categoria=" + categoria + ", Temporada=" + temporada + '}';
    }
    
    
}
