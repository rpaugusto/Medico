package model;

/**
 * @data 17/06/2015
 * @author RUI PENTEADO
 */
public class modPaciente {
    
    private int id;
    private String nome;
    private String rg;
    private String cpf;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String telefone;
    private String celular;
    private String email;
    private String cadastrado;
    private String atualizado;

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    private String sexo;

    //construtor vazio
    public modPaciente() {
    }
    
    //construtor set campos
    public modPaciente(int id, String nome, String rg, String cpf, String endereco,
            String bairro, String cidade, String uf, String cep, String telefone,
            String celular, String email, String cadastrado, String atualizado, String sexo) {
        
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.cadastrado = cadastrado;
        this.atualizado = atualizado;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCadastrado() {
        return cadastrado;
    }

    public void setCadastrado(String cadastrado) {
        this.cadastrado = cadastrado;
    }

    public String getAtualizado() {
        return atualizado;
    }

    public void setAtualizado(String atualizado) {
        this.atualizado = atualizado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
}
