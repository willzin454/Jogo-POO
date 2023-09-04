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
    protected static final int QTDE_DE_INIMIGOS = 1;
    protected static final int QTDE_DE_ASTEROIDES = 40;
    protected boolean emJogo = true;
    protected Personagem personagem;
    protected ArrayList<Inimigo> inimigos;
    protected ArrayList<Asteroide> asteroides;
    protected Timer timer;
    protected Image fundo;

    Personagem P = new Personagem(0);

    public Fase() {
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(this);
    }

    public abstract void inicializaInimigos();

    public abstract void inicializaElementosGraficosAdicionais();

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e){
        if(P.posicaoEmX < -1920){
            P.posicaoEmX = 0;
        }else if(P.posicaoEmX + P.larguraImagem > LARGURA_DA_JANELA){
            P.posicaoEmX = LARGURA_DA_JANELA - P.larguraImagem;
        }
        if(P.posicaoEmY < 1){
            P.posicaoEmY = 1;
        }else if(P.posicaoEmY + P.alturaImage > ALTURA_DA_JANELA){
            P.posicaoEmY = ALTURA_DA_JANELA - P.alturaImage;
        }
    }

    @Override
    public abstract void keyReleased(KeyEvent e);

    @Override
    public abstract void actionPerformed(ActionEvent e);
}