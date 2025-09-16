package cinedev;

public class Principal {
    public static void main(String[] args) {
        SalaDeCinema sala = new SalaDeCinema();
        Menu menu = new Menu(sala);
        menu.exibirMenuLoop();
    }
}
