package br.ifpr.jogo.modelo;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Personagem extends ElementoGrafico {

    protected static final int POSICAO_INICIAL_EM_X = 950;
    protected static final int POSICAO_INICIAL_EM_Y = 800;
    protected ArrayList<Tiro> tiros;
    protected ArrayList<SuperTiro> superTiro;
    private int pontuacao;

    public Personagem(int deslocamento) {
        super.posicaoEmX = POSICAO_INICIAL_EM_X;
        super.posicaoEmY = POSICAO_INICIAL_EM_Y;
        this.tiros = new ArrayList<Tiro>();
        this.superTiro = new ArrayList<SuperTiro>();
        super.velocidadedeDeslocamento = deslocamento;
    }

    @Override
    public void carregar() {
        ImageIcon carregando = new ImageIcon("recursos\\imagen1.png");
        super.imagem = carregando.getImage();
        super.larguraImagem = super.imagem.getWidth(null);
        super.alturaImage = super.imagem.getHeight(null);
    }

    @Override
    public void atualizar() {
        super.posicaoEmX = super.posicaoEmX + super.deslocamentoEmX;
        super.posicaoEmY = super.posicaoEmY + super.deslocamentoEmY;
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
   
    public void Limite() {     //Ainda não esta funcional.
        if (posicaoEmX < 1) {
            this.posicaoEmX = posicaoEmX + 3;
        } else if (posicaoEmX > -1000) {
            this.posicaoEmX = posicaoEmX - 3;
        } else if (posicaoEmY < 1) {
            this.posicaoEmY = posicaoEmY + 3;
        } else if (posicaoEmY > 240) {
            this.posicaoEmY = posicaoEmY - 3;
        } else {
            this.posicaoEmX += this.deslocamentoEmX;
            this.posicaoEmY += this.deslocamentoEmY;
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

    public ArrayList<Tiro> getTiros() {
        return this.tiros;
    }

    public void setTiros(ArrayList<Tiro> tiros) {
        this.tiros = tiros;
    }

    public ArrayList<SuperTiro> getSuperTiro() {
        return this.superTiro;
    }

    public void setSuperTiro(ArrayList<SuperTiro> superTiro) {
        this.superTiro = superTiro;
    }

    public int getPontuacao() {
        return this.pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    
}
