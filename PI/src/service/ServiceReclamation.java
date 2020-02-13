/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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
public class ServiceReclamation implements Iservice<Reclamation>{

 private Connection cnx;
    private Statement st;
     private PreparedStatement pst;
     private ResultSet rs;
    public ServiceReclamation() {
        cnx=DataSource.getInstance().getConnection();
        
    }    
    @Override
    public void insert(Reclamation t){
        String req="insert into reclamation(id_reclamation,date_relamation,contenu,note,etat,id_p) values (?,?,?,?,?,?)";
       try {
            pst = cnx.prepareStatement(req);
               pst.setString(1,t.getId_reclamation());
               pst.setDate(2, (Date) t.getDate_reclamation());
                pst.setString(3,t.getContenu());
                 pst.setInt(4,t.getNote());
                  pst.setString(5,t.getEtat());
                   pst.setString(6,t.getId_p());
       } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

    @Override
    public boolean update(Reclamation t) {
   String req="update table reclamation set ";
    try {
            pst=cnx.prepareStatement(req);
            pst.executeUpdate();
            return true;
    }
            catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Reclamation t) {
   String req="DELETE FROM reclamation ";
    try {
            pst=cnx.prepareStatement(req);
            pst.executeUpdate();
            return true;
    }
            catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Reclamation> displayAll() {
    
        String req="Select * from Reclamation";
       List<Reclamation> list=new ArrayList<>();
        try {
            st=cnx.createStatement();
            rs=st.executeQuery(req);
            while (rs.next()){
            list.add(new Reclamation(rs.getInt(4)
                    ,rs.getDate(2),
                    rs.getString(1),
                    rs.getString(3),
                    rs.getString(5),
                    rs.getString(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;    
    }
    
}
