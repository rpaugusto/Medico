package controller;

import config.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.modFuncionario;

/**
 *
 * @author rui
 */
public class ContFuncionario {

    //ATRIBUTOS
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;

    //METODOS
    public boolean insert(modFuncionario obj) throws SQLException {

        Conexao con = new Conexao();

        this.sql = "INSERT INTO funcionarios (nome, endereco, bairro, cep, cidade, "
                + "estado, telefone, celular, cpf, rg, email, sexo, funcao, conselho, "
                + "login, senha) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
        this.ps.setString(12, obj.getSexo());
        this.ps.setString(13, obj.getFuncao());
        this.ps.setString(14, obj.getConselho());
        this.ps.setString(15, obj.getLogin());
        this.ps.setString(16, obj.getSenha());

        return this.ps.executeUpdate() > 0;

    }

    public boolean update(modFuncionario obj) throws SQLException {

        Conexao con = new Conexao();

        this.sql = "UPDATE funcionarios SET nome = ?, endereco = ?, bairro = ?,"
                + " cep = ?, cidade = ?, estado = ?, telefone = ?, celular = ?,"
                + " cpf = ?, rg = ?, email = ?, sexo = ? WHERE id = ?";

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
        this.ps.setString(12, obj.getEmail());
        this.ps.setInt(13, obj.getId());

        return this.ps.executeUpdate() > 0;

    }

    public boolean delete(modFuncionario obj) throws SQLException {

        Conexao con = new Conexao();

        this.sql = "DELETE FOM funcionarios WHERE id = ?";

        this.ps = con.openCon().prepareStatement(this.sql);
        this.ps.setInt(1, obj.getId());

        return this.ps.executeUpdate() > 0;

    }

    public modFuncionario selectId(int id) throws SQLException {

        modFuncionario loc = null;

        Conexao con = new Conexao();

        this.sql = "SELECT * FROM funcionarios WHERE id = ?";

        this.ps = con.openCon().prepareStatement(this.sql);
        this.ps.setInt(1, id);

        this.rs = this.ps.executeQuery();

        if (rs.next()) {
            loc = new modFuncionario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("rg"),
                    rs.getString("cpf"),
                    rs.getString("sexo"),
                    rs.getString("endereco"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("cep"),
                    rs.getString("telefone"),
                    rs.getString("celular"),
                    rs.getString("email"),
                    rs.getString("funcao"),
                    rs.getString("conselho"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    rs.getString("cadastrado"),
                    rs.getString("atualizado")
            );
        }

        return loc;
    }

    public modFuncionario selectCpf(String cpf) throws SQLException {

        modFuncionario loc = null;

        Conexao con = new Conexao();
        this.sql = "SELECT * FROM funcionarios WHERE cpf = ?";
        this.ps = con.openCon().prepareStatement(this.sql);
        this.ps.setString(1, cpf);

        this.rs = this.ps.executeQuery();

        if (rs.next()) {
            loc = new modFuncionario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("rg"),
                    rs.getString("cpf"),
                    rs.getString("sexo"),
                    rs.getString("endereco"),
                    rs.getString("bairro"),
                    rs.getString("cidade"),
                    rs.getString("estado"),
                    rs.getString("cep"),
                    rs.getString("telefone"),
                    rs.getString("celular"),
                    rs.getString("email"),
                    rs.getString("funcao"),
                    rs.getString("conselho"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    rs.getString("cadastrado"),
                    rs.getString("atualizado")
            );
        }

        return loc;

    }

    public ArrayList<modFuncionario> selectAll() throws SQLException {

        modFuncionario loc;

        Conexao con = new Conexao();

        ArrayList<modFuncionario> lsPac = new ArrayList<>();

        this.sql = "SELECT * FROM funcionarios";
        this.ps = con.openCon().prepareStatement(this.sql);

        this.rs = this.ps.executeQuery();

        if (rs != null) {
            while (rs.next()) {
                loc = new modFuncionario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("rg"),
                        rs.getString("cpf"),
                        rs.getString("sexo"),
                        rs.getString("endereco"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("cep"),
                        rs.getString("telefone"),
                        rs.getString("celular"),
                        rs.getString("email"),
                        rs.getString("funcao"),
                        rs.getString("conselho"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getString("cadastrado"),
                        rs.getString("atualizado")
                );
                lsPac.add(loc);
            }
            return lsPac;
        }

        return null;

    }
}
