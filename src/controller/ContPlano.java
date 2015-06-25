package controller;

import java.sql.*;
import config.Conexao;
import java.util.ArrayList;
import model.modPlano;

/**
 * @data 19/06/2015
 * @author RUI PENTEADO
 */
public class ContPlano {

    //ATRIBUTOS
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    static Conexao con = new Conexao();
    private modPlano loc;

    //METODOS
    public boolean insert(modPlano obj) throws SQLException {

        //con = new Conexao();
        this.sql = "INSERT INTO planos (plano, data, valor) VALUES (?,?,?)";

        this.ps = con.openCon().prepareStatement(sql);

        this.ps.setString(1, obj.getNome());
        this.ps.setString(2, obj.getDia());
        this.ps.setDouble(3, obj.getValor());

        return this.ps.executeUpdate() > 0;
    }

    public boolean update(modPlano obj) throws SQLException {

        //con = new Conexao();
        this.sql = "UPDATE planos SET plano = ?, data = ?, valor = ? WHERE id = ?";

        this.ps = con.openCon().prepareStatement(sql);

        this.ps.setString(1, obj.getNome());
        this.ps.setString(2, obj.getDia());
        this.ps.setDouble(3, obj.getValor());
        this.ps.setInt(4, obj.getId());

        return this.ps.executeUpdate() > 0;
    }

    public ArrayList<modPlano> selectAll() throws SQLException {

        //con = new Conexao();
        ArrayList<modPlano> ls = new ArrayList<>();

        this.sql = "SELECT * FROM planos ";
        this.ps = con.openCon().prepareStatement(this.sql);

        this.rs = this.ps.executeQuery();

        if (rs != null) {
            while (rs.next()) {
                loc = new modPlano(
                        rs.getInt("id"),
                        rs.getString("plano"),
                        rs.getDouble("valor"),
                        rs.getString("data")
                );
                ls.add(loc);
            }
            return ls;
        }

        return null;

    }

    public modPlano selectId(int id) throws SQLException {

        this.sql = "SELECT * FROM planos WHERE id = ?";

        this.ps = con.openCon().prepareStatement(this.sql);
        this.ps.setInt(1, id);

        this.rs = this.ps.executeQuery();
        
        if (rs.next()) {

            loc = new modPlano(
                    rs.getInt("id"),
                    rs.getString("plano"),
                    rs.getDouble("valor"),
                    rs.getString("data")
            );
            return loc;
        }

        return null;

    }

}
