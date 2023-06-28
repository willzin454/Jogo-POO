package br.ifpr.jogo.modelo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Personagem {
    private int posicaoEmX;
    private int posicaoEmY;
    private int deslocamentoEmX;
    private int deslocamentoEmY;
    private Image imagem;
    private int larguraImagem;
    private int alturaImage;
    private int velocidadedeDeslocamento;

    private static final int POSICAO_INICIAL_EM_X = 950;
    private static final int POSICAO_INICIAL_EM_Y = 800;
    private ArrayList<Tiro> tiros;

    public Personagem(int deslocamento) {
        this.posicaoEmX = POSICAO_INICIAL_EM_X;
        this.posicaoEmY = POSICAO_INICIAL_EM_Y;
        this.tiros = new ArrayList<Tiro>();
        this.velocidadedeDeslocamento = deslocamento;
    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon("recursos\\imagen1.png");
        this.imagem = carregando.getImage();
        this.alturaImage = this.imagem.getWidth(null);
        this.alturaImage = this.imagem.getHeight(null);
    }

    public void atualizar() {
        this.posicaoEmX = this.posicaoEmX + this.deslocamentoEmX;
        this.posicaoEmY = this.posicaoEmY + this.deslocamentoEmY;
    }

    public void mover(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch (codigo) {
            case KeyEvent.VK_W:
                this.deslocamentoEmY = -this.velocidadedeDeslocamento;
                break;
            case KeyEvent.VK_S:
                this.deslocamentoEmY = this.velocidadedeDeslocamento;
                break;
            case KeyEvent.VK_A:
                this.deslocamentoEmX = -this.velocidadedeDeslocamento;
                break;
            case KeyEvent.VK_D:
                this.deslocamentoEmX = this.velocidadedeDeslocamento;
                break;
            default:
                break;
        }
    }

    public void parar(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch (codigo) {
            case KeyEvent.VK_W:
                this.deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_S:
                this.deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_A:
                this.deslocamentoEmX = 0;
                break;
            case KeyEvent.VK_D:
                this.deslocamentoEmX = 0;
                break;
            default:
                break;
        }
    }

    public void atirar() {
        int frenteDaNave = this.posicaoEmX + this.larguraImagem;
        int meioDaNave = this.posicaoEmY + (this.alturaImage / 2);
        Tiro tiro = new Tiro(frenteDaNave + -9, meioDaNave + -80);
        this.tiros.add(tiro);
    }

    public int getPosicaoEmX() {
        return this.posicaoEmX;
    }

    public void setPosicaoEmX(int posicaoEmX) {
        this.posicaoEmX = posicaoEmX;
    }

    public int getPosicaoEmY() {
        return this.posicaoEmY;
    }

    public void setPosicaoEmY(int posicaoEmY) {
        this.posicaoEmY = posicaoEmY;
    }

    public int getDeslocamentoEmX() {
        return this.deslocamentoEmX;
    }

    public void setDeslocamentoEmX(int deslocamentoEmX) {
        this.deslocamentoEmX = deslocamentoEmX;
    }

    public int getDeslocamentoEmY() {
        return this.deslocamentoEmY;
    }

    public void setDeslocamentoEmY(int deslocamentoEmY) {
        this.deslocamentoEmY = deslocamentoEmY;
    }

    public Image getImagem() {
        return this.imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public int getLarguraImagem() {
        return this.larguraImagem;
    }

    public void setLarguraImagem(int larguraImagem) {
        this.larguraImagem = larguraImagem;
    }

    public int getAlturaImage() {
        return this.alturaImage;
    }

    public void setAlturaImage(int alturaImage) {
        this.alturaImage = alturaImage;
    }

    public int getVelocidadedeDeslocamento() {
        return this.velocidadedeDeslocamento;
    }

    public void setVelocidadedeDeslocamento(int velocidadedeDeslocamento) {
        this.velocidadedeDeslocamento = velocidadedeDeslocamento;
    }

    public ArrayList<Tiro> getTiros() {
        return this.tiros;
    }

    public void setTiros(ArrayList<Tiro> tiros) {
        this.tiros = tiros;
    }
}