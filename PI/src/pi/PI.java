/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

import service.ServiceReclamation;

/**
 *
 * @author Lenovo
 */
public class PI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
      
           ServiceReclamation pst=new ServiceReclamation();
            pst.displayAll().forEach(System.out::println);
  
    
    
    }
    
}
