package br.com.nexustech.exception;

// Herda de Exception (checked), e nao de RuntimeException, conforme pedido no Ex.12
public class BanidoException extends Exception {

    public BanidoException() {
        super("Jogador Banido!");
    }
}
