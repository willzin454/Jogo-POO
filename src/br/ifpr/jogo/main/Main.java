package br.ifpr.jogo.main;

import br.ifpr.jogo.modelo.Fase;
import javax.swing.JFrame;

public class Main extends JFrame {
    public Main() {
        Fase fase = new Fase();
        super.add(fase);
        super.setVisible(true);
        super.setSize(1200,800);
        super.setTitle("Operador");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Main();
    }
}