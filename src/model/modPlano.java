package model;

import java.util.Date;

/**
 * @data 19/06/12015
 * @author RUI PENTEADO
 */

public class modPlano {

    private int id;
    private String nome;
    private double valor;
    private String dia;

    public modPlano(int id, String nome, double valor, String dia) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.dia = dia;
    }

    public modPlano() {
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    
}
