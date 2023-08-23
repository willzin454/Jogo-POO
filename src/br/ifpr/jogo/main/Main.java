package br.ifpr.jogo.main;

import br.ifpr.jogo.modelo.FaseUm;

import javax.swing.JFrame;

public class Main extends JFrame {
    public Main() {
        FaseUm fase = new FaseUm();
        super.add(fase);
        super.setVisible(true);
        super.setSize(1920, 1080);
        super.setTitle("Operador");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Main();
    }
}