/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import controller.ContPaciente;
import view.frmPessoa;

/**
 *
 * @author rui
 */
public class TesteConect {

    public static void main(String[] args) {

        Conexao c = new Conexao();
        System.out.println(c.openCon());
     
    }

}
