/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Lenovo
 */

import java.util.Date;

/**
 *
 * @author mahdi
 */
public class Avis {
    private int note;
    private String id_avis,Contenu,id_p ;
    private  Date date_avis ;

    public Avis() {
    }

    public Avis(int note, String id_avis, String Contenu, String id_p, Date date_avis) {
        this.note = note;
        this.id_avis = id_avis;
        this.Contenu = Contenu;
        this.id_p = id_p;
        this.date_avis = date_avis;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getId_avis() {
        return id_avis;
    }

    public void setId_avis(String id_avis) {
        this.id_avis = id_avis;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    public String getId_p() {
        return id_p;
    }

    public void setId_p(String id_p) {
        this.id_p = id_p;
    }

    public Date getDate_avis() {
        return date_avis;
    }

    public void setDate_avis(Date date_avis) {
        this.date_avis = date_avis;
    }

    @Override
    public String toString() {
        return "Avis{" + "note=" + note + ", id_avis=" + id_avis + ", Contenu=" + Contenu + ", id_p=" + id_p + ", date_avis=" + date_avis + '}';
    }
    

    
}
