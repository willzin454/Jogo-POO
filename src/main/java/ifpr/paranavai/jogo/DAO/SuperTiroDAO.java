package ifpr.paranavai.jogo.DAO;

import java.util.List;
import ifpr.paranavai.jogo.modelo.SuperTiro;

public interface SuperTiroDAO {
    SuperTiro buscarPorId(int id);
    List<SuperTiro> listarTodos();
    void inserir(SuperTiro SuperTiro);
    void atualizar(SuperTiro SuperTiro);
    void deletar(int id);
}