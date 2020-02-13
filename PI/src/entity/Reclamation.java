/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;



/**
 *
 * @author mahdi
 */
public class Reclamation {
    private int note ;
    private Date date_reclamation;
    private String id_reclamation,contenu,etat,id_p ;
  
                               
    public Reclamation() {
    }

    public Reclamation(int note, Date date_reclamation, String id_reclamation, String contenu, String etat, String id_p) {
        this.note = note;
        this.date_reclamation = date_reclamation;
        this.id_reclamation = id_reclamation;
        this.contenu = contenu;
        this.etat = etat;
        this.id_p = id_p;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Date getDate_reclamation() {
        return date_reclamation;
    }

    public void setDate_reclamation(Date date_reclamation) {
        this.date_reclamation = date_reclamation;
    }

    public String getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(String id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getId_p() {
        return id_p;
    }

    public void setId_p(String id_p) {
        this.id_p = id_p;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "note=" + note + ", date_reclamation=" + date_reclamation + ", id_reclamation=" + id_reclamation + ", contenu=" + contenu + ", etat=" + etat + ", id_p=" + id_p + '}';
    }

    
    
}
