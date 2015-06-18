package controller;

import java.sql.*;
import config.Conexao;
import java.util.ArrayList;
import model.modPaciente;

/**
 * @data 17/06/2015
 * @author RUI PENTEADO
 */
public class ContPaciente {

    //TRIBUTOS
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;

    //METODOS
    public boolean insert(modPaciente obj) throws SQLException {

        Conexao con = new Conexao();

        this.sql = "INSERT INTO pessoas (nome, endereco, bairro, cep, cidade, "
                + "estado, telefone, celular, cpf, rg, email) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        this.ps = con.openCon().prepareStatement(this.sql);

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

    public boolean update(modPaciente obj) throws SQLException {

        Conexao con = new Conexao();

        this.sql = "UPDATE pessoas SET (nome = ?, endereco = ?, bairro = ?,"
                + " cep = ?, cidade = ?, estado = ?, telefone = ?, celular = ?,"
                + " cpf = ?, rg = ?, email = ?) WHERE id = ?";

        this.ps = con.openCon().prepareStatement(this.sql);

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
        this.ps.setInt(12, obj.getId());

        return this.ps.executeUpdate() > 0;

    }

    public boolean delete(modPaciente obj) throws SQLException{
        
        Conexao con = new Conexao();

        this.sql = "DELETE FOM pessoas WHERE id = ?";

        this.ps = con.openCon().prepareStatement(this.sql);
        this.ps.setInt(1, obj.getId());

        return this.ps.executeUpdate() > 0;
        
    }

    public modPaciente select(modPaciente obj) throws SQLException {

        modPaciente loc = null;

        Conexao con = new Conexao();

        this.sql = "SELECT * FROM pessoas WHERE cpf = ?";

        this.ps = con.openCon().prepareStatement(this.sql);
        this.ps.setString(1, obj.getCpf());

        this.rs = this.ps.executeQuery();

        if (rs.next()) {
            loc = new modPaciente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("rg"),
                    rs.getString("cpf"),
                    rs.getString("endereco"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("cep"),
                    rs.getString("telefone"),
                    rs.getString("celular"),
                    rs.getString("email"),
                    rs.getString("cadastrado"),
                    rs.getString("atualizado"),
                    rs.getString("sexo")
            );
        }

        return loc;

    }
    
    public ArrayList<modPaciente> selectAll(modPaciente obj) throws SQLException {
        
        modPaciente loc;
        
        Conexao con = new Conexao();
        
        ArrayList<modPaciente> lsPac = new ArrayList<>();
        if (obj.getNome().equals(null)) {
            this.sql = "SELECT * FROM pessoas";
            this.ps = con.openCon().prepareStatement(this.sql);
        } else {    
            this.sql = "SELECT * FROM pessoas WHERE nome LIKE ?";
            this.ps = con.openCon().prepareStatement(this.sql);
            this.ps.setString(1, (obj.getNome()+"%"));
        }        
        
        this.rs = this.ps.executeQuery();
        
        if (rs != null) {
            while (rs.next()) {
                loc = new modPaciente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("rg"),
                    rs.getString("cpf"),
                    rs.getString("endereco"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("cep"),
                    rs.getString("telefone"),
                    rs.getString("celular"),
                    rs.getString("email"),
                    rs.getString("cadastrado"),
                    rs.getString("atualizado"),
                    rs.getString("sexo")
                );
                lsPac.add(loc);
            }
            return lsPac;
        }
        
        return null;
    
    }

}
