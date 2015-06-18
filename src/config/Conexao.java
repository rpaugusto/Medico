/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.*;
import java.util.logging.*;
import javax.swing.JOptionPane;

/**
 *
 * @author rui
 */
public class Conexao {

    /* atributos da conexão para acesso ao SQL Server*/
    private String driver   = "net.sourceforge.jtds.jdbc.Driver";   //drive de conexão com o banco de dados
    private String host     = "THOR";                               //endereço ip do servidor
    private String port     = "1433";                               //porta de comunicação com o banco de dados
    private String base     = "q114medico";                         //nome da base de dados
    private String user     = "sql";                                //usuario para logar no banco
    private String pass     = "sql2005";                            //senha para logar no banco
    private String url      = "jdbc:jtds:sqlserver://" + this.host + ":" + this.port + "/" + this.base; 
    
    public Connection con;
   
    public Connection openCon() {
        try {
            //System.setProperty("jdbc.Drivers", this.driver);
            Class.forName(this.driver);
            con = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro: " + e.getMessage());
        }

        return con;
    }
    
    public void cloCon() {

        try {
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
