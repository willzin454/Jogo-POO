package ifpr.paranavai.jogo.DAO;

import java.util.List;
import ifpr.paranavai.jogo.modelo.Jogador;

public interface JogadorDAO {
    Jogador buscarPorId(int id);
    List<Jogador> listarTodos();
    void inserir(Jogador Jogador);
    void atualizar(Jogador Jogador);
    void deletar(int id);
}