package cinedev;
public class Relatorio {

    public static void imprimirRelatorio(SalaDeCinema sala) {
        int total = sala.TotalAssentos();
        int ocupados = sala.contarOcupados();
        int livres = total - ocupados;
        double percentual = ((double) ocupados / total) * 100.0;

        System.out.println();
        System.out.println("====== Relatório de Ocupação ======");
        System.out.printf("Total de assentos: %d%n", total);
        System.out.printf("Assentos ocupados: %d%n", ocupados);
        System.out.printf("Assentos livres   : %d%n", livres);
        System.out.printf("Percentual de ocupação: %.2f%%%n", percentual);
        System.out.println("===================================");
        System.out.println();
    }
}

