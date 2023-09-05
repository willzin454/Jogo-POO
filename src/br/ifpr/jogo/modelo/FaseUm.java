package br.ifpr.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.Timer;
import javax.swing.ImageIcon;

public class FaseUm extends Fase{

    public FaseUm() {
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        ImageIcon carregando = new ImageIcon("recursos\\imagen2.png");
        this.fundo = carregando.getImage();
        this.personagem = new Personagem(deslocamento);
        personagem.carregar();
        this.inicializaElementosGraficosAdicionais();
        this.inicializaInimigos();
        this.timer = new Timer(DELAY, this);
        this.timer.start();
    }
    
    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        if (emJogo) {
            graficos.drawImage(this.fundo, 0, 0, null);
            graficos.drawImage(this.personagem.getImagem(), this.personagem.getPosicaoEmX(),this.personagem.getPosicaoEmY(), this);
            ArrayList<Tiro> tiros = personagem.getTiros();
            ArrayList<SuperTiro> superAtirar = personagem.getSuperTiro();
            super.desenhaPontuacao(graficos);
            for (Asteroide asteroide : asteroides) {
                graficos.drawImage(asteroide.getImagem(), asteroide.getPosicaoEmX(), asteroide.getPosicaoEmY(), this);
            }
            for (Tiro tiro : tiros) {
                tiro.carregar();
                graficos.drawImage(tiro.getImagem(), tiro.getPosicaoEmX(), tiro.getPosicaoEmY(), this);
            }
            for (Inimigo inimigo : inimigos) {
                inimigo.carregar();
                graficos.drawImage(inimigo.getImagem(), inimigo.getPosicaoEmX(), inimigo.getPosicaoEmY(), this);
            }
            for (SuperTiro superTiro : superAtirar) {
                superTiro.carregar();
                graficos.drawImage(superTiro.getImagem(), superTiro.getPosicaoEmX(), superTiro.getPosicaoEmY(), this);
            }
        } else {
            ImageIcon fimDeJogo = new ImageIcon("recursos\\imagen6.png");
            graficos.drawImage(fimDeJogo.getImage(), 500, 300, this);
        }
        g.dispose();
    }

    public void verficarColisoes() {
        Rectangle formaPersonagem = this.personagem.getRectangle();
        for (int i = 0; i < this.inimigos.size(); i++) {
            Inimigo inimigo = inimigos.get(i);
            Rectangle formaInimigo = inimigo.getRectangle();
            if (formaInimigo.intersects(formaPersonagem)) {
                this.personagem.setEhVisivel(false);
                inimigo.setEhVisivel(false);
                emJogo = false;
            }
            ArrayList<Tiro> tiros = this.personagem.getTiros();
            for (int j = 0; j < tiros.size(); j++) {
                Tiro tiro = tiros.get(j);
                Rectangle formaTiro = tiro.getRectangle();
                if (formaInimigo.intersects(formaTiro)) {
                    int pontuacaoAtual = this.personagem.getPontuacao();
                    this.personagem.setPontuacao(pontuacaoAtual + PONTOS_POR_INIMIGO);
                    inimigo.setEhVisivel(false);
                    tiro.setEhVisivel(false);
                }
            }
            ArrayList<SuperTiro> superAtirar = this.personagem.getSuperTiro();
            for (int j = 0; j < superAtirar.size(); j++) {
                SuperTiro superTiro = superAtirar.get(j);
                Rectangle formasuperTiro = superTiro.getRectangle();
                if (formaInimigo.intersects(formasuperTiro)) {
                    inimigo.setEhVisivel(false);
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
        else if(e.getKeyCode() == KeyEvent.VK_Q)
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

        for (Asteroide asteroide : this.asteroides) {
            asteroide.atualizar();
        }

        ArrayList<Tiro> tiros = personagem.getTiros();
        for (int i = 0; i < tiros.size(); i++) {
            Tiro tiro = tiros.get(i);
            if (tiros.get(i).getPosicaoEmY() > LARGURA_DA_JANELA || !tiro.getEhVisivel())
                tiros.remove(i);
            else
                tiros.get(i).atualizar();
        }

        ArrayList<SuperTiro> superAtirar = personagem.getSuperTiro();
        for (int i = 0; i < superAtirar.size(); i++){
            SuperTiro superTiro = superAtirar.get(i);
            if (superAtirar.get(i).getPosicaoEmY() > LARGURA_DA_JANELA || !superTiro.getEhVisivel())
                superAtirar.remove(i);
            else if
                (superAtirar.get(i).getPosicaoEmY() != inimigos.size())
                superTiro.setEhVisivel(false);
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
            } else
                inimigo.atualizar();
        }
        this.verficarColisoes();
        repaint();
    }
}