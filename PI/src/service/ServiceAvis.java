/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Avis;
import entity.Reclamation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.DataSource;

/**
 *
 * @author Lenovo
 */
public class ServiceAvis implements Iservice<Avis>{

    
 private Connection cnx;
    private Statement st;
     private PreparedStatement pst;
     private ResultSet rs;
    public ServiceAvis() {
        cnx=DataSource.getInstance().getConnection();
        
    }    
    
    
    @Override
    public void insert(Avis t) {
        String req="insert into Avis(id_avis,date_avis,contenu,note,id_p) values (?,?,?,?,?)";
       try {
            pst = cnx.prepareStatement(req);
               pst.setString(1,t.getId_avis());
               pst.setDate(2, (Date) t.getDate_avis());
                pst.setString(3,t.getContenu());
                 pst.setInt(4,t.getNote());
                   pst.setString(6,t.getId_p());
       } catch (SQLException ex) {
            Logger.getLogger(ServiceAvis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean update(Avis t) {
        String req="update table avis set contenu=?  ";
        
    try {
            pst=cnx.prepareStatement(req);
            pst.executeUpdate();
            return true;
    }
            catch (SQLException ex) {
            Logger.getLogger(ServiceAvis.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Avis t) {
     String req="delete from avis where note=? ";
    try {
            pst=cnx.prepareStatement(req);
            pst.setInt(1,t.getNote());
            pst.executeUpdate();
            return true;
    }
            catch (SQLException ex) {
            Logger.getLogger(ServiceAvis.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }   
    }

    
    @Override
    public List<Avis> displayAll() {
    
        String req="Select * from avis";
       List<Avis> list=new ArrayList<>();
        try {
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            while (rs.next()){
            list.add(new Avis(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(4),
                    rs.getString(3),
                    rs.getDate(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAvis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;    

    }
    
    
}

