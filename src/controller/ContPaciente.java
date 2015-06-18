package controller;

import java.sql.*;
import config.Conexao;
import model.modPaciente;

/**
 * @data  17/06/2015
 * @author RUI PENTEADO
 */
public class ContPaciente {
    
    //TRIBUTOS
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    
    
    //METODOS
    public boolean insert(modPaciente obj) throws SQLException{
    
        Conexao con = new Conexao();
        
        this.sql = "INSERT INTO pessoas (nome, endereco, bairro, cep, cidade, estado,"
                + "telefone, celular, cpf, rg, email) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        
        this.ps = con.openCon().prepareCall(this.sql);
        
        this.ps.setString(1, obj.getNome());
        this.ps.setString(2, obj.getEndereco());
        this.ps.setString(3, obj.getBairro());
        this.ps.setString(4, obj.getCep());
        this.ps.setString(5, obj.getCidade());
        this.ps.setString(6, obj.getUf());
        this.ps.setString(7, obj.getTelefone());
        this.ps.setString(8, obj.getCelular());
        this.ps.setString(9, obj.getCpf());
        this.ps.setString(10, obj.getRg());
        this.ps.setString(11, obj.getEmail());
        
    
        return this.ps.executeUpdate() > 0;
    }
    
}
