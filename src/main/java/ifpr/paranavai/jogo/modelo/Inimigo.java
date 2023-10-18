package ifpr.paranavai.jogo.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.swing.ImageIcon;

@Entity
@Table(name = "tb_inimigo")
public class Inimigo extends ElementoGrafico {

    private static final int VELOCIDADE = 5;

    public Inimigo(int xAleatorio, int yAleatorio) {
        super.posicaoEmX = xAleatorio;
        super.posicaoEmY = yAleatorio;
    }

    @Override
    public void carregar() {
        ImageIcon carregando = new ImageIcon(getClass().getResource("/imagen4.png"));
        super.imagem = carregando.getImage();
        super.alturaImage = super.imagem.getWidth(null);
        super.larguraImagem = super.imagem.getHeight(null);
    }

    @Override
    public void atualizar() {
        super.posicaoEmY = super.posicaoEmY + VELOCIDADE;
    }

}