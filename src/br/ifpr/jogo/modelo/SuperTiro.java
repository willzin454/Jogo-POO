package br.ifpr.jogo.modelo;

import javax.swing.ImageIcon;

public class SuperTiro extends ElementoGrafico {

    private static final int VELOCIDADE = 15;

    public SuperTiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
        super.posicaoEmX = posicaoPersonagemEmX;
        super.posicaoEmY = posicaoPersonagemEmY;
    }

    @Override
    protected void carregar() {
        ImageIcon carregando = new ImageIcon("recursos\\.png");
        super.imagem = carregando.getImage();
        super.alturaImage = super.imagem.getWidth(null);
        super.larguraImagem = super.imagem.getHeight(null);
    }

    @Override
    protected void atualizar() {
        super.posicaoEmY = super.posicaoEmY - VELOCIDADE;
    }
}