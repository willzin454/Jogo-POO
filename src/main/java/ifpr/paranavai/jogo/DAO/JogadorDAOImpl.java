package ifpr.paranavai.jogo.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ifpr.paranavai.jogo.controle.hibernate.conexao.HibernateUtil;
import ifpr.paranavai.jogo.modelo.Jogador;

public class JogadorDAOImpl implements JogadorDAO{
    
    @Override
    public Jogador buscarPorId(int id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Jogador.class, id);
        }
    }

    @Override
    public void deletar(int id) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            Jogador jogador = session.get(Jogador.class, id);
            if (jogador != null) {
                session.delete(jogador);
            }
            transaction.commit();
        }
    }

    @Override
    public List<Jogador> listarTodos() {
        try (Session session = HibernateUtil.getSession()) {
            Query<Jogador> query = session.createQuery("FROM Jogador", Jogador.class);
            return query.list();
        }
    }

    @Override
    public void inserir(Jogador Jogador) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(Jogador);
            transaction.commit();
        }
    }

    @Override
    public void atualizar(Jogador Jogador) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(Jogador);
            transaction.commit();
        }
    }
}