package controller;

import java.sql.*;
import config.Conexao;
import java.util.ArrayList;
import model.modPlano;

/**
 * @data 19/06/2015
 * @author RUI PENTEADO
 */
public class conPlano {

    //ATRIBUTOS
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    static Conexao con;

    //METODOS
    public boolean insert(modPlano obj) throws SQLException{
        
        con = new Conexao();
        
        this.sql = "INSERT INTO planos (nome, dia, valor) VALUES (?,?,?)";
        
        this.ps = con.openCon().prepareStatement(sql);
        
        this.ps.setString(1, obj.getNome());
        this.ps.setString(2, obj.getDia());
        this.ps.setDouble(3, obj.getValor());
        
        return this.ps.executeUpdate() > 0;
    }
    
}
