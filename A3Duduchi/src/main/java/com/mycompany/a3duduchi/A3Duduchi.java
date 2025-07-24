/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.a3duduchi;


import conexao.Conexao;


/**
 *
 * @author Vitor
 */
public class A3Duduchi {

    public static void main(String[] args) {
       Conexao c = new Conexao();
       c.getConexao();
       try {
            System.out.println("Aplicação iniciada!");
            // Sua lógica aqui
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
