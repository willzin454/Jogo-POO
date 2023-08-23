package br.ifpr.jogo.modelo;

import javax.swing.ImageIcon;

public class SuperTiro extends ElementoGrafico {

    private static final int VELOCIDADE = 5;

    public SuperTiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
        super.posicaoEmX = posicaoPersonagemEmX;
        super.posicaoEmY = posicaoPersonagemEmY;
    }

    @Override
    public void carregar() {
        ImageIcon carregando = new ImageIcon("recursos\\imagen5.png");
        super.imagem = carregando.getImage();
        super.alturaImage = super.imagem.getWidth(null);
        super.larguraImagem = super.imagem.getHeight(null);
    }

    @Override
    public void atualizar() {
        super.posicaoEmY = super.posicaoEmY - VELOCIDADE;
    }
}