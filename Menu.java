package cinedev;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final SalaDeCinema sala;
    private final Scanner scanner;

    public Menu(SalaDeCinema sala) {
        this.sala = sala;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenuLoop() {
        boolean sair = false;
        while (!sair) {
            System.out.println("=== CineDev - Sistema de Gerenciamento ===");
            System.out.println("1. Exibir Mapa de Assentos");
            System.out.println("2. Comprar Ingresso");
            System.out.println("3. Cancelar Compra de Ingresso");
            System.out.println("4. Exibir Relatório de Ocupação");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = lerIntComTratamento();
            switch (opcao) {
                case 1 -> sala.exibirMapa();
                case 2 -> fluxoComprar();
                case 3 -> fluxoCancelar();
                case 4 -> Relatorio.imprimirRelatorio(sala);
                case 5 -> {
                    System.out.println("Encerrando o sistema. Até logo!");
                    sair = true;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void fluxoComprar() {
        System.out.println("--- Comprar Ingresso ---");
        int fileira = pedirNumero("Número da fileira (1-" + sala.getLinhas() + "): ");
        int assento = pedirNumero("Número do assento (1-" + sala.getColunas() + "): ");

        if (!sala.validarPosicao(fileira, assento)) {
            System.out.println("Posição inválida. Verifique os números e tente novamente.");
            return;
        }
        if (!sala.estaLivre(fileira, assento)) {
            System.out.println("Assento já está ocupado. Escolha outro.");
            return;
        }
        boolean ok = sala.comprarIngresso(fileira, assento);
        if (ok) {
            System.out.println("Compra realizada com sucesso!");
        } else {
            System.out.println("Erro ao comprar o ingresso.");
        }
    }

    private void fluxoCancelar() {
        System.out.println("--- Cancelar Compra ---");
        int fileira = pedirNumero("Número da fileira (1-" + sala.getLinhas() + "): ");
        int assento = pedirNumero("Número do assento (1-" + sala.getColunas() + "): ");

        if (!sala.validarPosicao(fileira, assento)) {
            System.out.println("Posição inválida. Verifique os números e tente novamente.");
            return;
        }
        if (sala.estaLivre(fileira, assento)) {
            System.out.println("O assento já está livre. Não há compra para cancelar.");
            return;
        }
        boolean ok = sala.cancelarCompra(fileira, assento);
        if (ok) {
            System.out.println("Compra cancelada. Assento liberado!");
        } else {
            System.out.println("Erro ao cancelar a compra.");
        }
    }

    private int pedirNumero(String mensagem) {
        System.out.print(mensagem);
        return lerIntComTratamento();
    }

    private int lerIntComTratamento() {
        while (true) {
            try {
                int valor = scanner.nextInt();
                scanner.nextLine(); // limpar newline
                return valor;
            } catch (InputMismatchException e) {
                System.out.print("Entrada inválida (digite um número): ");
                scanner.nextLine(); // descarta entrada inválida
            }
        }
    }
}
