package ifpr.paranavai.jogo.modelo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.swing.ImageIcon;

@Entity
@Table(name="tb_tiro")
public class Tiro extends ElementoGrafico {

    private static final int VELOCIDADE = 15;

    @ManyToOne
    @JoinColumn(name = "fk_personagem")
    private Personagem personagem;

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

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
}