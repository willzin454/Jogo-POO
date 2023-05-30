package br.ifpr.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fase extends JPanel { // toda classe java herda da Object
    private Image imagemfundo;
    private Personagem Personagem;

    public Fase() {
        ImageIcon carregando = new ImageIcon("C:\\Users\\willi\\OneDrive\\Documentos\\Jogo-POO\\Jogo-POO\\src\\recursos\\imagen5.png");
        this.imagemfundo = carregando.getImage();

        this.Personagem = new Personagem();
        this.Personagem.carregar();
    }

    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(this.imagemfundo, 0, 0, null);
        graficos.drawImage(this.Personagem.getImagem(), 0, 0, null);
        g.dispose();
    }

}