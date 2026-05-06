package Aplicacao.Servicos;

import java.util.NoSuchElementException;

import Dominio.Modelos.Livro;
import Dominio.Modelos.Usuario;
import Dominio.MeusAlgoritmos.CifraDeCesar;
import Dominio.MinhasEstruturasDeDados.Listas.Lista;
import Dominio.MinhasEstruturasDeDados.Listas.Pilha;

import Aplicacao.Interfaces.*;

public class ServicoUsuarios {
    IRepositorioUsuarios repositorioUsuarios;
    Usuario usuarioLogado;

    public ServicoUsuarios(IRepositorioUsuarios repositorio) {
        repositorioUsuarios = repositorio;

    }

    public int Adicionar(Usuario usuario) {
        // definir o ID
        usuario.ID = repositorioUsuarios.Contagem();

        // encriptar a senha
        IEncriptador encriptador = new CifraDeCesar();
        usuario.Senha = encriptador.Encriptar(usuario.Senha);

        repositorioUsuarios.Inserir(usuario);
        return usuario.ID;

    }

    public Usuario Visualizar(String stringID) {

        int ID = validaID(stringID);

        Usuario usuario = repositorioUsuarios.BuscarUsuarioPorID(ID);

        if (usuario == null)
            throw new NoSuchElementException("Usuario não encontrado");
        else
            return usuario;
    }

    public Lista<Usuario> Listar() {

        return repositorioUsuarios.Listar();

    }

    public Usuario Editar(Usuario novoUsuario) {

        Usuario usuario = repositorioUsuarios.BuscarUsuarioPorID(novoUsuario.ID);

        if (usuario == null)
            throw new NoSuchElementException("Usuario não encontrado");

        usuario.Nome = novoUsuario.Nome;
        usuario.CPF = novoUsuario.CPF;
        usuario.Senha = novoUsuario.Senha;

        return usuario;

    }

    public void Remover(String stringID) {

        int ID = validaID(stringID);

        if (!repositorioUsuarios.Remover(ID))
            throw new NoSuchElementException("Usuario não encontrado");

    }

    public Usuario Login(String login, String senha) {

        Usuario usuario = repositorioUsuarios.BuscarNome(login);

        if (usuario == null)
            throw new NoSuchElementException("Login inválido");

        IEncriptador encriptador = new CifraDeCesar();

        if (usuario.Senha.equals(encriptador.Encriptar(senha)))
            usuarioLogado = usuario;

        else
            throw new NoSuchElementException("Senha inválida");

        return usuarioLogado;
    }

    public Usuario GetUsuarioLogado() {
        return usuarioLogado;
    }

    private int validaID(String stringID) {

        try {
            int ID = Integer.parseInt(stringID);

            if (ID < 0)
                throw new IllegalArgumentException("ID inválido: deve ser um número positivo.");

            return ID;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID deve ser no formato numérico");
        }
    }

    public void RegistrarHistórico(Livro livro) {

        usuarioLogado.historicoNavegacao.Inserir(livro);
        return;
    }

    public Pilha<Livro> ListarHistoricoNavegacao(String stringID) {
        int ID = validaID(stringID);
        Usuario usuario = repositorioUsuarios.BuscarUsuarioPorID(ID);

        if (usuario == null)
            throw new NoSuchElementException("Usuario não encontrado");
        else
            return usuario.historicoNavegacao;

    }

}
