package br.ifpr.jogo.main;

import javax.swing.JFrame;

public class Main extends JFrame {
    public Main() {
        super.setVisible(true);
        super.setSize(1980, 1080);
        super.setTitle("OperetaNier");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(ABORT);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
