/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ui.Entidades.TablespaceInfo;
import ui.Entidades.TablespaceSola;

/**
 *
 * @author stefvn
 */
public class prueba {
    
     public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
       
         
         MyOracleTest t = new MyOracleTest();
         
         List<String> comandos =  new ArrayList<>();
         
         comandos.add("BACKUP AS BACKUPSET TABLESPACE A1");
         comandos.add("BACKUP AS BACKUPSET TABLESPACE A2");
         
         String nombre = "cmdfile2";
         
         
         t.atexto(nombre,comandos);
         
    /*    
        System.out.println("Numero de registros en t1 " + t.countTable("T11"));
        
         List<TablespaceInfo> es = t.informacionGeneral();
        
        
        
          for(TablespaceInfo car : es){
          
               
                System.out.println("nombre = " + car.getNombre());
                System.out.println("size = " + car.getSize());
                System.out.println("free = " + car.getFree());
            System.out.println("% Used = " + car.getPorused());
             System.out.println("% Free = " + car.getPorfree());
       }
          
          
          System.out.println("info de tablespace especifica ");
        
        
             List<TablespaceSola> ts = t.informacionTablespace("A1",60);
        
        
        
          for(TablespaceSola car : ts){
          
               
                System.out.println("nombre = " + car.getTablaspace());
                System.out.println("maximo = " + car.getMaximoMB());
                System.out.println("libre = " + car.getLibreMB());
                System.out.println("usado = " + car.getUsadoMB());
            System.out.println("% SP = " + car.getPorSP());
             System.out.println("% saturacion = " + car.getDiasparaSP());
              System.out.println("dias para sat total = " + car.getDiasparaSatTotal());
   
             
       }
          
*/
          
        
    }}
    
    

