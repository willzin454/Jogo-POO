package ifpr.paranavai.jogo.modelo;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.swing.ImageIcon;

@Entity
@Table(name= "tb_personagem")
public class Personagem extends ElementoGrafico {

    @Column(name = "posicao_inicial_em_x")
    protected static final int POSICAO_INICIAL_EM_X = 950;

    @Column(name = "posicao_inicial_em_y")
    protected static final int POSICAO_INICIAL_EM_Y = 800;

    @Column(name = "pontuacao")
    protected int pontuacao;

    @Column(name = "vidas")
    protected int vidas = 3;
        
    @OneToMany(mappedBy = "personagem")
    protected List<Tiro> tiros;

    @OneToMany(mappedBy = "personagem")
    protected List<SuperTiro> superTiro;

    public Personagem(int deslocamento) {
        super.posicaoEmX = POSICAO_INICIAL_EM_X;
        super.posicaoEmY = POSICAO_INICIAL_EM_Y;
        this.tiros = new ArrayList<Tiro>();
        this.superTiro = new ArrayList<SuperTiro>();
        super.velocidadedeDeslocamento = deslocamento;
    }

    @Override
    public void carregar() {
        ImageIcon carregando = new ImageIcon(getClass().getResource("/imagen1.png"));
        super.imagem = carregando.getImage();
        super.larguraImagem = super.imagem.getWidth(null);
        super.alturaImage = super.imagem.getHeight(null);
    }

    @Override
    public void atualizar() {
        if (super.posicaoEmX < 0) {
            super.posicaoEmX = 0;
        } else if (super.posicaoEmX + larguraImagem > Fase.LARGURA_DA_JANELA) {
            super.posicaoEmX = Fase.LARGURA_DA_JANELA - larguraImagem;
        } else if (super.posicaoEmY < 0) {
            super.posicaoEmY = 0;
        } else if (super.posicaoEmY + alturaImage > Fase.ALTURA_DA_JANELA) {
            super.posicaoEmY = (Fase.ALTURA_DA_JANELA - alturaImage) + -80;
        } else {
            super.posicaoEmX += this.deslocamentoEmX;
            super.posicaoEmY += this.deslocamentoEmY;
        }
    }

    public void mover(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch (codigo) {
            case KeyEvent.VK_W:
                super.deslocamentoEmY = -super.velocidadedeDeslocamento;
                break;
            case KeyEvent.VK_S:
                super.deslocamentoEmY = super.velocidadedeDeslocamento;
                break;
            case KeyEvent.VK_A:
                super.deslocamentoEmX = -super.velocidadedeDeslocamento;
                break;
            case KeyEvent.VK_D:
                super.deslocamentoEmX = super.velocidadedeDeslocamento;
                break;
            default:
                break;
        }
    }

    public void parar(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch (codigo) {
            case KeyEvent.VK_W:
                super.deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_S:
                super.deslocamentoEmY = 0;
                break;
            case KeyEvent.VK_A:
                super.deslocamentoEmX = 0;
                break;
            case KeyEvent.VK_D:
                super.deslocamentoEmX = 0;
                break;
            default:
                break;
        }
    }
   
    public void atirar() {
        int frenteDaNave = super.posicaoEmX + super.larguraImagem;
        int meioDaNave = super.posicaoEmY + (super.alturaImage / 2);
        Tiro tiro = new Tiro(frenteDaNave + -70, meioDaNave + -80);
        this.tiros.add(tiro);
    }

    public void superAtirar() {
        int frenteDaNave = super.posicaoEmX + super.larguraImagem;
        int meioDaNave = super.posicaoEmY + (super.alturaImage / 2);
        SuperTiro superTiro = new SuperTiro(frenteDaNave + -62, meioDaNave + -750);
        this.superTiro.add(superTiro);
    }

    public List<Tiro> getTiros() {
        return this.tiros;
    }

    public void setTiros(List<Tiro> tiros) {
        this.tiros = tiros;
    }

    public List<SuperTiro> getSuperTiro() {
        return this.superTiro;
    }

    public void setSuperTiro(List<SuperTiro> superTiro) {
        this.superTiro = superTiro;
    }

    public int getPontuacao() {
        return this.pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getVidas() {
        return this.vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
}
