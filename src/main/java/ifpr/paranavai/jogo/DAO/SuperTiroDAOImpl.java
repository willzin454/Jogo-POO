package ifpr.paranavai.jogo.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ifpr.paranavai.jogo.controle.hibernate.conexao.HibernateUtil;
import ifpr.paranavai.jogo.modelo.SuperTiro;

public class SuperTiroDAOImpl implements SuperTiroDAO{
    @Override
    public SuperTiro buscarPorId(int id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(SuperTiro.class, id);
        }
    }

    @Override
    public void deletar(int id) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            SuperTiro superTiro = session.get(SuperTiro.class, id);
            if (superTiro != null) {
                session.delete(superTiro);
            }
            transaction.commit();
        }
    }

    @Override
    public List<SuperTiro> listarTodos() {
        try (Session session = HibernateUtil.getSession()) {
            Query<SuperTiro> query = session.createQuery("FROM SuperTiro", SuperTiro.class);
            return query.list();
        }
    }

    @Override
    public void inserir(SuperTiro SuperTiro) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(SuperTiro);
            transaction.commit();
        }
    }

    @Override
    public void atualizar(SuperTiro SuperTiro) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(SuperTiro);
            transaction.commit();
        }
    }
}