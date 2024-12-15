/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.mif.manager.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author markos
 */
public class Temporada
{
    private LocalDate anny;

    public Temporada(){}
    
    public Temporada(LocalDate anny)
    {
        this.anny = anny;
    }
    
    public LocalDate getAnny()
    {
        return anny;
    }

    public void setAnny(LocalDate anny)
    {
        if (anny == null)
        {
            throw new RuntimeException("Any és obligatori.");
        }
        
        this.anny = anny;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.anny);
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
        final Temporada other = (Temporada) obj;
        return Objects.equals(this.anny, other.anny);
    }
    
    @Override
    public String toString()
    {
        return "Temporada <" + anny.format(DateTimeFormatter.ofPattern("yyyy")) + ">";
    }
}
