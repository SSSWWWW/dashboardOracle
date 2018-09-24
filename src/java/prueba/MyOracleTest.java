/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ui.Entidades.TablespaceInfo;
import ui.Entidades.TablespaceSola;


public class MyOracleTest {
    
    public void atexto(String path, List<String> listaComandos)
    
    {
    
    try {
			File file = new File(path+".txt");
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("RUN {");
                        
                        for(String column : listaComandos)
                         { 
                        fileWriter.write(column + ";");
                        
                             }
                        fileWriter.write("}");
                         fileWriter.write("EXIT;");
			fileWriter.flush();
			fileWriter.close();
                        
                        
                        File file1 = new File("backup.bat");
			FileWriter fileWriter1 = new FileWriter(file1);
			fileWriter1.write("rman target=/ @"+path+".txt");

			fileWriter1.flush();
			fileWriter1.close();
                        
                        
                        
		} catch (IOException e) {
			e.printStackTrace();
		}
    
    }
    
    
          private TablespaceInfo TablespaceInfo(ResultSet rs){
        try {
            TablespaceInfo ec= new TablespaceInfo();
          
                ec.setNombre(rs.getString("Tablespace"));
                ec.setSize(rs.getInt("Size (MB)"));
                ec.setFree(rs.getInt("Free (MB)"));
                ec.setPorfree(rs.getInt("% Free"));
                ec.setPorused(rs.getInt("% Used"));
      
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
    
          
          
             private TablespaceSola TablespaceSola(ResultSet rs){
        try {
            TablespaceSola ec= new TablespaceSola();
          
                ec.setTablaspace(rs.getString("Tablaspace"));
                ec.setMaximoMB(rs.getInt("Maximo MB"));
                ec.setLibreMB(rs.getFloat("Libre MB"));
                ec.setUsadoMB(rs.getFloat("Usado MB"));
                ec.setPorSP(rs.getInt("% SP"));
                ec.setDiasparaSP(rs.getInt("Dias para SP"));
                ec.setDiasparaSatTotal(rs.getInt("Dias para Sat. Total"));
      
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }
          
          
    
    
    public  List<TablespaceInfo> informacionGeneral() throws ClassNotFoundException, SQLException{
    
     Class.forName("oracle.jdbc.OracleDriver");
        TablespaceInfo tabinfo = new TablespaceInfo();
        String username = "sys as sysdba";
        String password = "admin";
        Connection conn = null;
            ResultSet rs      = null;
        Statement st = null;
        
          List<TablespaceInfo>  estados = new ArrayList<>();
        
        try{
            conn = DriverManager.getConnection("jdbc:oracle:thin:" + username + "/" + password + "@localhost:1521:xe");
            st = conn.createStatement();
          
            
            String command = "SELECT /* + RULE */  df.tablespace_name \"Tablespace\",  df.bytes / (1024 * 1024) \"Size (MB)\",\n" +
"       SUM(fs.bytes) / (1024 * 1024) \"Free (MB)\", Nvl(Round(SUM(fs.bytes) * 100 / df.bytes),1) \"% Free\", Round((df.bytes - SUM(fs.bytes)) * 100 / df.bytes) \"% Used\"\n" +
"  FROM dba_free_space fs, (SELECT tablespace_name,SUM(bytes) bytes\n" +
"          FROM dba_data_files\n" +
"         GROUP BY tablespace_name) df\n" +
" WHERE fs.tablespace_name (+)  = df.tablespace_name\n" +
" GROUP BY df.tablespace_name,df.bytes\n" +
"UNION ALL\n" +
"SELECT /* + RULE */ df.tablespace_name tspace,\n" +
"       fs.bytes / (1024 * 1024), SUM(df.bytes_free) / (1024 * 1024), Nvl(Round((SUM(fs.bytes) - df.bytes_used) * 100 / fs.bytes), 1), Round((SUM(fs.bytes) - df.bytes_free) * 100 / fs.bytes)\n" +
"  FROM dba_temp_files fs, (SELECT tablespace_name,bytes_free,bytes_used\n" +
"          FROM v$temp_space_header\n" +
"         GROUP BY tablespace_name,bytes_free,bytes_used) df\n" +
" WHERE fs.tablespace_name (+)  = df.tablespace_name\n" +
" GROUP BY df.tablespace_name,fs.bytes,df.bytes_free,df.bytes_used\n" +
" ORDER BY 4 DESC";
            rs = st.executeQuery(command);
           
           
            while (rs.next()) {
                
                //System.out.println(rs.getString(1));
                //tabinfo.setNombre(());
                estados.add(TablespaceInfo(rs));
            }
        } catch (SQLException ex) { }
        
        return estados; 
        

    }
    
    
    
    
    public  List<TablespaceSola> informacionTablespace(String nom, int porcen) throws ClassNotFoundException, SQLException, Exception{
    
            
             Class.forName("oracle.jdbc.OracleDriver");
        TablespaceInfo tabinfo = new TablespaceInfo();
        String username = "sys as sysdba";
        String password = "admin";
        Connection conn = null;
            ResultSet rs      = null;
        Statement st = null;
            
       List<TablespaceSola>  estados = new ArrayList<>();
        
        try{
            conn = DriverManager.getConnection("jdbc:oracle:thin:" + username + "/" + password + "@localhost:1521:xe");
            st = conn.createStatement();
          
            
            String command = "select x.c.tabla as \"Tablaspace\", x.c.maximo as \"Maximo MB\",x.c.free as \"Libre MB\", x.c.used as \"Usado MB\",x.c.por_sp as \"% SP\",x.c.dias_para_sat_a_sp as \"Dias para SP\", x.c.dias_para_sat_total as \"Dias para Sat. Total\" from (select tiempo_saturacion6('"+nom+"',"+porcen+") c from dual) x";
            rs = st.executeQuery(command);
           
           
            while (rs.next()) {
                
                //System.out.println(rs.getString(1));
                //tabinfo.setNombre(());
                estados.add(TablespaceSola(rs));
            }
        } catch (SQLException ex) { }
        
        return estados; 
        

    }
    
    
    
    
    
    
 
      
    
    public  String countTable(String t) throws ClassNotFoundException, SQLException{
    
     Class.forName("oracle.jdbc.OracleDriver");
        String username = "sys as sysdba";
        String password = "admin";
        Connection conn = null;
            ResultSet rset      = null;
        Statement st = null;
        try{
            conn = DriverManager.getConnection("jdbc:oracle:thin:" + username + "/" + password + "@localhost:1521:xe");
            st = conn.createStatement();
            String command = "select count(*) from "+ t;
            rset = st.executeQuery(command);
            rset.next();
            return rset.getString(1);
           // System.out.println("      Database User  -> " + rset.getString(1));
            
        }finally{
        if(st != null){
            st.close();
        }
        if(conn != null){
            conn.close();
        }
        }

    }
    
    
    
}
    
    
    
    

  