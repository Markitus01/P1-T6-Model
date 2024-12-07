/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mif.manager.model;

import java.time.LocalDate; // Date funciona, pero és una pedra i LocalDate es millor: https://stackoverflow.com/questions/60144827/difference-between-java-util-date-and-java-time-localdate-in-java
import java.time.Period;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Classe per gestionar les dades de la taula JUGADOR de l'esquema MARK
 * @author markos
 */
public class Jugador
{
    private int id;
    private String nom;
    private String cognoms;
    private String sexe;
    private LocalDate data_naix;
    private String idLegal;
    private String iban;
    private LocalDate any_fi_revi_medica;
    private String adresa;
    private String foto;
    private Equip equip;
    private String titular;
    
    //Expressions regulars per a comprobar DNI o Passaport i l'IBAN
    private final String nifRegex = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$";
    private final String nieRegex = "^[XYZ][0-9]{7}[TRWAGMYFPDXBNJZSQVHLCKE]$";
    private final String ibanRegex = "^(ES)[0-9]{22}$";

    public Jugador(){}

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
            throw new RuntimeException("Nom del jugador obligatori, amb un màxim de 32 caràcters.");
        }
        
        this.nom = nom;
    }

    public String getCognoms()
    {
        return cognoms;
    }

    public void setCognoms(String cognoms)
    {
        if (cognoms == null || cognoms.length() == 0 || cognoms.length() > 64)
        {
            throw new RuntimeException("Cognom/s del jugador obligatori, amb un màxim de 64 caràcters.");
        }
        
        this.cognoms = cognoms;
    }

    public String getSexe()
    {
        return sexe;
    }

    public void setSexe(String sexe)
    {
        if (sexe == null)
        {
            throw new RuntimeException("Sexe es obligatori.");
        }
        
        this.sexe = sexe;
    }

    public LocalDate getData_naix()
    {
        return data_naix;
    }

    public void setData_naix(LocalDate data_naix)
    {
        if (data_naix == null || data_naix.isBefore(LocalDate.parse("1980-01-01")) || data_naix.isAfter(LocalDate.now()))
        {
            throw new RuntimeException("Data de naixement obligatoria, no abans de 1980 i no futura.");
        }
        
        this.data_naix = data_naix;
    }

    public String getIdLegal()
    {
        return idLegal;
    }

    public void setIdLegal(String idLegal)
    {
        // Comprovar si l'idLegal (passaport o dni) es vàlid
        Pattern nifPattern = Pattern.compile(nifRegex);
        Pattern niePattern = Pattern.compile(nieRegex);
        Matcher nifMtx = nifPattern.matcher(idLegal);
        Matcher nieMtx = niePattern.matcher(idLegal);
        boolean nifValid = nifMtx.find();
        boolean nieValid = nieMtx.find();
        
        if (idLegal == null || (!nifValid && !nieValid))
        {
            throw new RuntimeException("Identificació legal es obligatoria amb format correcte, ex: '12345678A'.");
        }
        
        this.idLegal = idLegal;
    }

    public String getIban() // Cambiar en la BBDD a iban de banco
    {
        return iban;
    }

    public void setIban(String iban)
    {
        // Comprovem si l'iban es vàlid
        iban = iban.replaceAll("\\s", ""); // Treiem els espais en blanc
        Pattern ibanPattern = Pattern.compile(ibanRegex);
        Matcher ibanMtx = ibanPattern.matcher(iban);
        boolean ibanValid = ibanMtx.find();
        
        if (iban == null || !ibanValid)
        {
            throw new RuntimeException("L'IBAN es obligatori i ha de cumplir un format vàlid, ex: 'ES00 1111 2222 3333 4444 5555'.");
        }
        this.iban = iban;
    }

    public LocalDate getAny_fi_revi_medica()
    {
        return any_fi_revi_medica;
    }

    public void setAny_fi_revi_medica(LocalDate any_fi_revi_medica)
    {
        if (any_fi_revi_medica == null || any_fi_revi_medica.isBefore(LocalDate.now()))
        {
            throw new RuntimeException("Data de fi de revisió medica obligatoria i no pasada.");
        }
        
        this.any_fi_revi_medica = any_fi_revi_medica;
    }

    public String getAdresa()
    {
        return adresa;
    }

    public void setAdresa(String adresa)
    {
        if (adresa == null || adresa.length() == 0 || adresa.length() > 64)
        {
            throw new RuntimeException("L'adreça es obligatoria, i no més llarg de 64 caràcters.");
        }
        
        this.adresa = adresa;
    }

    public String getFoto()
    {
        return foto;
    }

    public void setFoto(String foto)
    {
        if (foto.length() > 128)
        {
            throw new RuntimeException("EL nom de la foto no pot superar els 128 caràcters.");
        }
        
        this.foto = foto;
    }
    
    public Equip getEquip()
    {
        return equip;
    }

    public void setEquip(Equip equip)
    {
        int edat_jug = Period.between(data_naix, LocalDate.now()).getYears();
        int catEdatMin = equip.getCategoria().getEdat_min();
        int catEdatMax = equip.getCategoria().getEdat_max();
        
        if (catEdatMin > edat_jug || catEdatMax < edat_jug)
        {
            throw new RuntimeException("L'edat del jugador ha d'estar dins el rang de la categoria de l'equip.");
        }
        
        this.equip = equip;
    }
    
    public String getTitular()
    {
        return titular;
    }

    public void setTitular(String titular)
    {
        if (!titular.contains("Convidat") && !titular.contains("Titular"))
        {
            throw new RuntimeException("Tipus de titularitat obligatoria, entre Titular o Convidat.");
        }
        
        this.titular = titular;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
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
        final Jugador other = (Jugador) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nom=" + nom + ",\ncognoms=" + cognoms + ",\nsexe=" + sexe + ",\ndata_naix=" + data_naix + 
               ",\nidLegal=" + idLegal + ",\niban=" + iban + ",\nany_fi_revi_medica=" + any_fi_revi_medica + 
               ",\nadresa=" + adresa + ",\nfoto=" + foto + "\nEquip: " + getEquip().getNom() + '}';
    }
}
