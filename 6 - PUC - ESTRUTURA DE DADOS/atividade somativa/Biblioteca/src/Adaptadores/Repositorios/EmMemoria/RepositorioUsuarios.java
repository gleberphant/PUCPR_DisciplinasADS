package Adaptadores.Repositorios.EmMemoria;

import java.util.Iterator;

import Dominio.MinhasEstruturasDeDados.Grafos.GrafoHash;
import Dominio.MinhasEstruturasDeDados.Listas.Lista;
import Dominio.Modelos.Usuario;
import Aplicacao.Interfaces.IRepositorioUsuarios;

public class RepositorioUsuarios implements IRepositorioUsuarios {
    protected final Lista<Usuario> lista;
    public final GrafoHash<Usuario> conexoes;
    int contagem;

    public Lista<Usuario> GetLista() {
        return lista;
    }

    public RepositorioUsuarios() {
        lista = new Lista<>();
        conexoes = new GrafoHash<>();
        contagem = 0;
    }

    public int Contagem() {
        return contagem;
    }

    public int Inserir(Usuario dado) {
        lista.Inserir(dado);
        return contagem++;

    }

    public Lista<Usuario> Listar() {
        return lista;
    }

    public Usuario BuscarUsuarioPorID(int ID) {

        for (Usuario usuario : lista) {
            if (usuario.ID == ID) {
                return usuario;
            }
        }

        return null;

    }

    public Usuario BuscarNome(String nome) {
        for (Usuario usuario : lista) {
            if (usuario.Nome.equals(nome)) {
                return usuario;
            }
        }

        return null;
    }

    // remove item por indice
    public boolean Remover(int ID) {
        int indice = 0;

        for (var usuario : lista) {

            if (usuario.ID == ID) {
                lista.Remover(indice);
                return true;
            }
            indice++;
        }
        return false;

    }

    public int Tamanho() {
        return lista.Tamanho();
    }

    public String toString() {
        return lista.toString();
    }

    // percorre a fila sem remover
    @Override
    public Iterator<Usuario> iterator() {
        return lista.iterator();
    }

}
