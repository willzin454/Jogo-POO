package br.ifpr.jogo.modelo;

import javax.swing.ImageIcon;

public class Inimigo extends ElementoGrafico {

    private static final int VELOCIDADE = 2;

    public Inimigo(int xAleatorio, int yAleatorio) {
        super.posicaoEmX = xAleatorio;
        super.posicaoEmY = yAleatorio;
    }

    @Override
    protected void carregar() {
        ImageIcon carregando = new ImageIcon("recursos\\imagen4.png");
        super.imagem = carregando.getImage();
        super.alturaImage = super.imagem.getWidth(null);
        super.larguraImagem = super.imagem.getHeight(null);
    }

    @Override
    protected void atualizar() {
        super.posicaoEmY = super.posicaoEmY + VELOCIDADE;
    }

}