/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mif.manager.model;

/**
 *
 * @author markos
 */
public class Categoria
{
    private int id;
    private String nom;
    private Integer edat_min;
    private Integer edat_max;

    public Categoria(){}

    public int getId()
    {
        return id;
    }
    
    // No cal comprovar correcte asignació d'id ja que es genera automàticament a la bbdd
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
        if (nom == null || nom.length() == 0 || nom.length() > 16)
        {
            throw new RuntimeException("Nom de Categoria obligatori i amb 16 caràcters o menys");
        }
        
        this.nom = nom;
    }

    public int getEdat_min()
    {
        return edat_min;
    }

    public void setEdat_min(Integer edat_min)
    {
        if (edat_min == null || edat_min == 0 || edat_min > 99)
        {
            throw new RuntimeException("Edat mínima no pot ser 0 ni tampoc més gran de 99");
        }
        
        this.edat_min = edat_min;
    }

    public int getEdat_max()
    {
        return edat_max;
    }

    public void setEdat_max(Integer edat_max)
    {
        if (edat_max == 0 || edat_max > 99)
        {
            throw new RuntimeException("Edat màxima no pot ser 0 ni tampoc més gran de 99");
        }
        
        this.edat_max = edat_max;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
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
        final Categoria other = (Categoria) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Categoria{" + "Nom=" + nom + ", Edat mínima=" + edat_min + ", Edat màxima=" + edat_max + '}';
    }
}
