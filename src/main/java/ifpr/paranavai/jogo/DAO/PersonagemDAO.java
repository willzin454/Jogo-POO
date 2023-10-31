package ifpr.paranavai.jogo.DAO;

import java.util.List;
import ifpr.paranavai.jogo.modelo.Personagem;

public interface PersonagemDAO {
    Personagem buscarPorId(int id);
    List<Personagem> listarTodos();
    void inserir(Personagem Personagem);
    void atualizar(Personagem Personagem);
    void deletar(int id);
}