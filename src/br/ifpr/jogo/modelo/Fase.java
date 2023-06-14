package br.ifpr.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fase extends JPanel implements ActionListener, KeyListener {

    private Image fundo;
    private Image imagemfundo;
    private Personagem personagem;
    private Timer timer;
    private static final int DELAY = 5;

    public Fase() {
        setFocusable(true);
        setDoubleBuffered(true);
        ImageIcon carregando = new ImageIcon("C:\\Users\\Aluno\\Desktop\\Jogo\\Jogo-POO\\src\\recursos\\imagen5.png");
        this.imagemfundo = carregando.getImage();
        fundo = carregando.getImage();
        this.personagem = new Personagem();
        this.personagem.carregar();
        addKeyListener(this);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(this.imagemfundo, 0, 0, null);
        graficos.drawImage(this.personagem.getImagem(), 0, 0, null);
        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}