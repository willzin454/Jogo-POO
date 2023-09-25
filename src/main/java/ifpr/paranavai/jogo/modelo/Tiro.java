package ifpr.paranavai.jogo.modelo;

import javax.swing.ImageIcon;

public class Tiro extends ElementoGrafico {

    private static final int VELOCIDADE = 15;

    public Tiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
        super.posicaoEmX = posicaoPersonagemEmX;
        super.posicaoEmY = posicaoPersonagemEmY;
    }

    @Override
    public void carregar() {
        ImageIcon carregando = new ImageIcon(getClass().getResource("/imagen3.png"));
        super.imagem = carregando.getImage();
        super.alturaImage = super.imagem.getWidth(null);
        super.larguraImagem = super.imagem.getHeight(null);
    }

    @Override
    public void atualizar() {
        super.posicaoEmY = super.posicaoEmY - VELOCIDADE;
    }
}