package br.ifpr.jogo.modelo;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public abstract class Fase extends JPanel implements ActionListener, KeyListener {

    protected static final int DELAY = 5;
    protected static final int deslocamento = 20;
    protected static final int ALTURA_DA_JANELA = 1080;
    protected static final int LARGURA_DA_JANELA = 1920;
    protected static final int QTDE_DE_INIMIGOS = 500;

    protected Image fundo;
    protected Personagem personagem;
    protected ArrayList<Inimigo> inimigos;
    protected Timer timer;

    public Fase() {
        setFocusable(true); // + define o foco inicial do jogo
        setDoubleBuffered(true); // + Otimização computacional
        addKeyListener(this); // + Definindo que a própria classe irá controlar os eventos do teclado
    }

    public abstract void inicializaInimigos();

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public abstract void keyPressed(KeyEvent e);

    @Override
    public abstract void keyReleased(KeyEvent e);

    @Override
    public abstract void actionPerformed(ActionEvent e);
}