package cinedev;

public class SalaDeCinema {
    private final int linhas = 10;
    private final int colunas = 20;
    private final char[][] sala;

    public SalaDeCinema() {
        sala = new char[linhas][colunas];
        inicializarSala();
    }

    private void inicializarSala() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                sala[i][j] = Assento.LIVRE;
            }
        }
    }

    public void exibirMapa() {
        System.out.println();
        System.out.print("     Assentos:");
        for (int j = 1; j <= colunas; j++) {
            System.out.printf(" %2d", j);
        }
        System.out.println();
        for (int i = 0; i < linhas; i++) {
            System.out.printf("Fileira %2d: ", i + 1);
            for (int j = 0; j < colunas; j++) {
                System.out.printf("[%c]", sala[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean validarPosicao(int fileira, int assento) {
        return fileira >= 1 && fileira <= linhas && assento >= 1 && assento <= colunas;
    }

    public boolean estaLivre(int fileira, int assento) {
        if (!validarPosicao(fileira, assento)) return false;
        return sala[fileira - 1][assento - 1] == Assento.LIVRE;
    }

    public boolean comprarIngresso(int fileira, int assento) {
        if (!validarPosicao(fileira, assento)) {
            return false;
        }
        if (sala[fileira - 1][assento - 1] == Assento.OCUPADO) {
            return false;
        }
        sala[fileira - 1][assento - 1] = Assento.OCUPADO;
        return true;
    }

    public boolean cancelarCompra(int fileira, int assento) {
        if (!validarPosicao(fileira, assento)) {
            return false;
        }
        if (sala[fileira - 1][assento - 1] == Assento.LIVRE) {
            return false;
        }
        sala[fileira - 1][assento - 1] = Assento.LIVRE;
        return true;
    }

    public int totalAssentos() {
        return linhas * colunas;
    }

    public int contarOcupados() {
        int cont = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (sala[i][j] == Assento.OCUPADO) cont++;
            }
        }
        return cont;
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    int Assentos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    int TotalAssentos() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}


