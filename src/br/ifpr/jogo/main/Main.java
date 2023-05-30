package br.ifpr.jogo.main;

import br.ifpr.jogo.modelo.Fase;
import javax.swing.JFrame;

public class Main extends JFrame {
    public Main() {
        Fase fase = new Fase();
        super.add(fase);
        super.setVisible(true);
        super.setSize(1980, 1080);
        super.setTitle("Operador");
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(ABORT);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}