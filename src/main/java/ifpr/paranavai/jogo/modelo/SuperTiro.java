package ifpr.paranavai.jogo.modelo;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.swing.ImageIcon;

public class SuperTiro extends ElementoGrafico {

    @ManyToOne
    @JoinColumn(name = "fk_personagem")
    private Personagem personagem;

    public SuperTiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
        super.posicaoEmX = posicaoPersonagemEmX;
        super.posicaoEmY = posicaoPersonagemEmY;
    }

    @Override
    public void carregar() {
        ImageIcon carregando = new ImageIcon(getClass().getResource("/imagenT.png"));
        super.imagem = carregando.getImage();
        super.alturaImage = super.imagem.getWidth(null);
        super.larguraImagem = super.imagem.getHeight(null);
    }

    @Override
    public void atualizar() {
        super.posicaoEmY = super.posicaoEmY;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
}