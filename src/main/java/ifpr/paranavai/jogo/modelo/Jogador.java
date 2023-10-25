package ifpr.paranavai.jogo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Session;

import ifpr.paranavai.jogo.controle.hibernate.conexao.HibernateUtil;

@Entity
@Table(name = "tb_jogador")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_jogador", unique = true, nullable = false)
    private Integer idJogador;

    @Column(name = "nome", unique = true, nullable = false, length = 100)
    private String nome;

    public class TesteHibernate {
        public void main(String[] args) {
            Session sessao = HibernateUtil.getSession();
            sessao.beginTransaction();
            Jogador jogador = new Jogador("willzin");
            sessao.save(jogador);
            sessao.getTransaction().commit();
            HibernateUtil.encerraSession();
        }
    }

    public Jogador(String nome) {
        this.nome = nome;
    }

    public Integer getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(Integer jogadorId) {
        this.idJogador = jogadorId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}