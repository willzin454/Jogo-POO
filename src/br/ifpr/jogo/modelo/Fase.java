package br.ifpr.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fase extends JPanel implements ActionListener, KeyListener {

    private Image fundo;
    private Personagem personagem;
    private Timer timer;
    private boolean emJogo = true;

    private static final int DELAY = 5;
    private static final int deslocamento = 20;
    private static final int ALTURA_DA_JANELA = 1080;
    private static final int LARGURA_DA_JANELA = 1920;
    private static final int QTDE_DE_INIMIGOS = 10;
    private ArrayList<Inimigo> inimigos;

    public Fase() {
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        ImageIcon carregando = new ImageIcon("recursos\\imagen2.png");
        this.fundo = carregando.getImage();
        this.personagem = new Personagem(deslocamento);
        personagem.carregar();
        this.inicializaInimigos();
        this.addKeyListener(this);
        this.timer = new Timer(DELAY, this);
        this.timer.start();
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

    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        if (emJogo) {
            graficos.drawImage(this.fundo, 0, 0, null);
            graficos.drawImage(this.personagem.getImagem(), this.personagem.getPosicaoEmX(),
                    this.personagem.getPosicaoEmY(), null);
            ArrayList<Tiro> tiros = personagem.getTiros();
            for (Tiro tiro : tiros) {
                tiro.carregar();
                graficos.drawImage(tiro.getImagem(), tiro.getPosicaoEmX(), tiro.getPosicaoEmY(), this);
            }
            for (Inimigo inimigo : inimigos) {
                inimigo.carregar();
                graficos.drawImage(inimigo.getImagem(), inimigo.getPosicaoEmX(), inimigo.getPosicaoEmY(), this);
            }
        } else {
            ImageIcon fimDeJogo = new ImageIcon("recursos\\imagen6.png");
            graficos.drawImage(fimDeJogo.getImage(), 0, 0, null);
        }
        g.dispose();
    }

    public void verficarColisoes() {
        Rectangle formaPersonagem = personagem.getRectangle();
        for (int i = 0; i < this.inimigos.size(); i++) {
            Inimigo inimigo = inimigos.get(i);
            Rectangle formaInimigo = inimigo.getRectangle();
                if (formaPersonagem.intersects(formaInimigo)) {
                    personagem.setEhVisivel(false);
                    inimigo.setEhVisivel(false);
                    emJogo = false;
                }
            ArrayList<Tiro> tiros = this.personagem.getTiros();
            for (int j = 0; j < tiros.size(); j++) {
                Tiro tiro = tiros.get(j);
                Rectangle formaTiro = tiro.getRectangle();
                if (formaInimigo.intersects(formaTiro)) {
                    inimigo.setEhVisivel(false);
                    tiro.setEhVisivel(false);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.personagem.mover(e);
        if (e.getKeyCode() == KeyEvent.VK_SPACE) 
            personagem.atirar();
        if (e.getKeyCode() == KeyEvent.VK_F) 
            personagem.superAtirar();
        else
            personagem.mover(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.personagem.parar(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.personagem.atualizar();
        ArrayList<Tiro> tiros = personagem.getTiros();
        for (int i = 0; i < tiros.size(); i++) {
            Tiro tiro = tiros.get(i);
            if (tiros.get(i).getPosicaoEmX() > LARGURA_DA_JANELA || !tiro.getEhVisivel())
                tiros.remove(i);
            else
                tiros.get(i).atualizar();
        }

        for (int i = 0; i < this.inimigos.size(); i++) {
            Inimigo inimigo = this.inimigos.get(i);
            if ((inimigo.getPosicaoEmY() >= ALTURA_DA_JANELA) != !inimigo.getEhVisivel()) {
                inimigo.setPosicaoEmY(0 + (int) (Math.random() * -1500 + 250));
                inimigo.setPosicaoEmX(0 + (int) (Math.random() * 1500 + 150));
                inimigo.atualizar();
                if (inimigo.getPosicaoEmY() >= ALTURA_DA_JANELA || !inimigo.getEhVisivel()) {
                    inimigos.remove(i);
                }
            }
            else
                inimigo.atualizar();
        }
        this.verficarColisoes();
        repaint();
    }
}