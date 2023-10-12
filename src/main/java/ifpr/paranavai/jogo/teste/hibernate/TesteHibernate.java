package ifpr.paranavai.jogo.teste.hibernate;

import org.hibernate.Session;
import ifpr.paranavai.jogo.conexao.HibernateUtil;
import ifpr.paranavai.jogo.modelo.Jogador;

public class TesteHibernate {
    public static void main(String[] args) {
        Session sessao = HibernateUtil.getSession();
        sessao.beginTransaction();
        Jogador jogador = new Jogador("willzin");

        sessao.save(jogador);

        sessao.getTransaction().commit();
        HibernateUtil.encerraSession();
    }
}
