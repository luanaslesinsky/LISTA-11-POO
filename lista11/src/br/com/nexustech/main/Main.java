package br.com.nexustech.main;

import br.com.nexustech.exception.BanidoException;
import br.com.nexustech.exception.NivelInsuficienteException;
import br.com.nexustech.model.Masmorra;
import br.com.nexustech.model.Matchmaker;
import br.com.nexustech.model.ModoCasual;
import br.com.nexustech.model.ModoJogo;
import br.com.nexustech.model.ModoRanqueado;

public class Main {

    public static void main(String[] args) {

        // ===== Exercicios 1 e 2: O Bug do K/D =====
        // Sem tratamento, kills / deaths com deaths = 0 lanca ArithmeticException: / by zero.
        // Aqui ja fica a versao "consertada" do Exercicio 2.
        int kills = 15;
        int deaths = 0;
        try {
            System.out.println(kills / deaths);
        } catch (ArithmeticException e) {
            System.out.println("Taxa K/D: Jogador Invicto!");
        }

        // ===== Exercicio 3: O Inventario Bugado =====
        String[] inventario = new String[3];
        try {
            inventario[5] = "Espada";
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Inventario cheio!");
        }

        // ===== Exercicio 4: O Fantasma (NullPointerException) =====
        // Regra do chefe: nada de try-catch aqui, apenas programacao defensiva.
        String jogador = null;
        if (jogador != null) {
            System.out.println(jogador);
        } else {
            System.out.println("Jogador desconectado");
        }

        // ===== Exercicios 5, 6 e 7: Servidor obrigatorio + finally =====
        try {
            conectarServidor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Fechando portas de rede do jogo...");
        }

        // ===== Exercicio 9: A Masmorra Fechada =====
        Masmorra masmorra = new Masmorra();
        try {
            masmorra.entrar(20);
        } catch (NivelInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        // ===== Nivel Boss: O Arquiteto Matchmaker (Exercicios 10 a 14) =====
        Matchmaker matchmaker = new Matchmaker();
        ModoJogo casual = new ModoCasual();
        ModoJogo ranqueado = new ModoRanqueado();

        try {
            matchmaker.encontrarSala(casual, false);
            matchmaker.encontrarSala(ranqueado, false);
            matchmaker.encontrarSala(ranqueado, true); // jogador banido -> deve lancar BanidoException
        } catch (BanidoException e) {
            System.out.println(e.getMessage());
        }
    }

    // ===== Exercicio 5: metodo com throws =====
    public static void conectarServidor() throws Exception {
        throw new Exception("Servidor caiu!");
    }
}
