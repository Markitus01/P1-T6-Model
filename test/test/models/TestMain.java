/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test.models;

import java.time.LocalDate;
import org.mif.manager.model.*;

/**
 *
 * @author markos
 */
public class TestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Temporada t = new Temporada();
        Categoria c = new Categoria();
        Equip e = new Equip();
        Jugador j = new Jugador();
        
        t.setAnny(LocalDate.parse("2024-01-01"));
        
        System.out.println(t.toString());
        
        c.setId(0);
        c.setNom("Test");
        c.setEdat_min(10);
        c.setEdat_max(30);
        
        System.out.println(c.toString());
        
        e.setId(0);
        e.setNom("Malakas FC");
        e.setTipus("M");
        e.setTemporada(t);
        e.setCategoria(c);
        
        System.out.println(e.toString());
        
        j.setId(0);
        j.setNom("Mark");
        j.setCognoms("Sandiumenge Villoria");
        j.setAdresa("Carrer Montseny 1132");
        j.setData_naix(LocalDate.parse("2000-04-07"));
        j.setSexe("H");
        j.setIdLegal("47131376Y");
        j.setIban("ES00 11112222333344445555");
        j.setAny_fi_revi_medica(LocalDate.parse("2026-01-01"));
        j.setEquip(e);
        j.setFoto("ruta/ala/foto.jpg");
        j.setTitular("Titular");
        
        System.out.println(j.toString());
    }
    
}
