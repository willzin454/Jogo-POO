package br.ifpr.jogo.modelo;

import java.awt.Image;

public abstract class ElementoGrafico extends MetodoElementoGrafico {
    protected int posicaoEmX;
    protected int posicaoEmY;
    protected int deslocamentoEmX;
    protected int deslocamentoEmY;
    protected int larguraImagem;
    protected int alturaImage;
    protected int velocidadedeDeslocamento;
    protected Image imagem;

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
}
