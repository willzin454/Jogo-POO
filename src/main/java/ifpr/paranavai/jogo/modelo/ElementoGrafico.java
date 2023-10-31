package ifpr.paranavai.jogo.modelo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.GenerationType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name= "tb_elemento_grafico")
public abstract class ElementoGrafico implements MetodoElementoGrafico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_elemento_grafico")
    protected int idElementoGrafico;

    @Column(name="posicao_em_x")
    protected int posicaoEmX;

    @Column(name="posicao_em_y")
    protected int posicaoEmY;

    @Column(name="deslocamento_em_x")
    protected int deslocamentoEmX;

    @Column(name="deslocamento_em_y")
    protected int deslocamentoEmY;

    @Column(name="largura_imagem")
    protected int larguraImagem;

    @Column(name="altura_image")
    protected int alturaImage;

    @Column(name="velocidade_deslocamento")
    protected int velocidadeDeslocamento;

    @Transient
    protected Image imagem;

    @Column(name="ehVisivel")
    private boolean ehVisivel = true;

    public Rectangle getRectangle() {
        return new Rectangle(posicaoEmX, posicaoEmY, larguraImagem, alturaImage);
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

    public int getVelocidadeDeslocamento() {
        return this.velocidadeDeslocamento;
    }

    public void setVelocidadeDeslocamento(int velocidadeDeslocamento) {
        this.velocidadeDeslocamento = velocidadeDeslocamento;
    }

    public Image getImagem() {
        return this.imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public boolean isEhVisivel() {
        return this.ehVisivel;
    }

    public boolean getEhVisivel() {
        return this.ehVisivel;
    }

    public void setEhVisivel(boolean ehVisivel) {
        this.ehVisivel = ehVisivel;
    }

    public int getIdElementoGrafico() {
        return idElementoGrafico;
    }

    public void setIdElementoGrafico(int idElementoGrafico) {
        this.idElementoGrafico = idElementoGrafico;
    }
}