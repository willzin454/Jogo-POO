package br.ifpr.jogo.modelo;

import java.awt.Graphics2D;
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
    protected static final int QTDE_DE_INIMIGOS = 30;
    protected static final int QTDE_DE_ASTEROIDES = 30;
    protected static final int PONTOS_POR_INIMIGO = 10;
    protected boolean emJogo = true;
    protected Personagem personagem;
    protected ArrayList<Inimigo> inimigos;
    protected ArrayList<Asteroide> asteroides;
    protected Timer timer;
    protected Image fundo;

    public Fase() {
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(this);
    }

    public void inicializaInimigos() {
        inimigos = new ArrayList<Inimigo>();
        for (int i = 0; i < QTDE_DE_INIMIGOS; i++) {
            int x = (int) (Math.random() * 1500 + 150);
            int y = (int) (Math.random() * -1500 + 250);
            Inimigo inimigo = new Inimigo(x, y);
            inimigos.add(inimigo);
        }
    }

    public void inicializaElementosGraficosAdicionais(){
        asteroides = new ArrayList<Asteroide>();
        for (int i = 0; i < QTDE_DE_ASTEROIDES; i++) {
            int x = (int) (Math.random() * LARGURA_DA_JANELA);
            int y = (int) (Math.random() * ALTURA_DA_JANELA);
            Asteroide asteroide = new Asteroide(x, y);
            asteroides.add(asteroide);
        }
    }

    public void desenhaPontuacao(Graphics2D graficos) {
        String textoPontuacao = "PONTOS: " + personagem.getPontuacao();
        graficos.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 22));
        graficos.setColor(new java.awt.Color(255, 255, 255));
        graficos.setColor(java.awt.Color.RED);
        graficos.drawString(textoPontuacao, 20, 25);
    }

    public void desenharVidas(Graphics2D graficos) {
        String textoVidas = "VIDAS: " + personagem.getVidas();
        graficos.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 22));
        graficos.setColor(new java.awt.Color(255, 255, 255));
        graficos.setColor(java.awt.Color.RED);
        graficos.drawString(textoVidas, 200, 25); 
    }

    @Override
    public abstract void keyTyped(KeyEvent e);

    @Override
    public abstract void keyPressed(KeyEvent e);

    @Override
    public abstract void keyReleased(KeyEvent e);

    @Override
    public abstract void actionPerformed(ActionEvent e);
}
