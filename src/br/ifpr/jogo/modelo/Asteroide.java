package br.ifpr.jogo.modelo;

import javax.swing.ImageIcon;

public class Asteroide extends ElementoGrafico{
    private static int VELOCIDADE = 1;

    public Asteroide(int xAleatorio, int yAleatorio) {
        this.carregar();
        super.setPosicaoEmX(xAleatorio);
        super.setPosicaoEmY(yAleatorio);
    }

    @Override
    protected void carregar() {
        ImageIcon carregando = new ImageIcon("recursos\\imagen5.png");
        setImagem(carregando.getImage());
    }

    @Override
    protected void atualizar() {
        if (this.getPosicaoEmX() < 0) {
            int y = (int) (Math.random() * Fase.ALTURA_DA_JANELA);
            super.setPosicaoEmX(Fase.LARGURA_DA_JANELA);
            super.setPosicaoEmY(y);
        } else {
            super.setPosicaoEmX(super.getPosicaoEmX() - VELOCIDADE);
        }
    }    
}
