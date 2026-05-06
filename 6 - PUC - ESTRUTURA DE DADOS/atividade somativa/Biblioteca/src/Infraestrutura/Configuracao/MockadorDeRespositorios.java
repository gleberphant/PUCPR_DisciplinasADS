package Infraestrutura.Configuracao;

import Adaptadores.Repositorios.EmMemoria.RepositorioLivros;
import Adaptadores.Repositorios.EmMemoria.RepositorioRecomendacoes;
import Adaptadores.Repositorios.EmMemoria.RepositorioUsuarios;
import Dominio.Modelos.Livro;
import Dominio.Modelos.Usuario;

public class MockadorDeRespositorios {

        public static void Mockar(
                        RepositorioLivros repositorioLivros,
                        RepositorioUsuarios repositorioUsuarios,
                        RepositorioRecomendacoes respositorioRecomendacoes) {
                // mockar dados

                System.out.println("\n::: Mockando Livros :::");
                int numLivros = 5 + (int) (Math.random() * 50);
                for (int i = 0; i <= numLivros; i++) {
                        // gera um id aleatorio
                        var idLivro = ((int) (Math.random() * 50));

                        // verifica se o id ja existe, se existe, gera outro
                        while (repositorioLivros.BuscarLivroPorID(idLivro) != null) {
                                idLivro = ((int) (Math.random() * 50));
                        }

                        var novoLivro = new Livro(idLivro, "Livro " + idLivro, "Autor " + idLivro, "");

                        repositorioLivros.InserirLivro(novoLivro);
                        // testa se consegue buscar o livro inserido e exibe falha
                        if (repositorioLivros.BuscarLivroPorID(idLivro) != null)
                                System.out.println("ID" + idLivro + " Livro:" + novoLivro);

                }

                System.out.println("\n::: Mockando RECOMENDAÇÕES :::");
                int numRecomendacoes = 5 + (int) (Math.random() * 10);
                for (int i = 0; i < numRecomendacoes; i++) {

                        // criar conexoes aleatorias
                        var livro1 = repositorioLivros.BuscarLivroAleatorio();
                        var livro2 = repositorioLivros.BuscarLivroAleatorio();

                        // se forem iguais re rola ate fica diferente
                        while (livro1.compareTo(livro2) == 0 || livro1 == null || livro2 == null) {
                                livro1 = repositorioLivros.BuscarLivroAleatorio();
                                livro2 = repositorioLivros.BuscarLivroAleatorio();
                        }

                        // chance de repetir a ligação para criar pesos

                        do {
                                respositorioRecomendacoes.InserirRecomendacao(livro1, livro2);
                                System.out.println("Livro: " + livro1.ID + " conectado ao livro " + livro2.ID);
                        } while (Math.random() < 0.6);
                }

                System.out.println("\n::: Mockando USUARIOS :::");
                int numUsuarios = 4;
                for (int i = 1; i <= numUsuarios; i++) {
                        var idUsuario = i;
                        var novoUsuario = new Usuario(idUsuario, "Nome " + i, "cpf" + i, "senha");

                        repositorioUsuarios.Inserir(novoUsuario);

                        // testa se consegue buscar o livro inserido e exibe falha
                        if (repositorioUsuarios.BuscarUsuarioPorID(i) != null)
                                System.out.println(" Usuario :" + novoUsuario);

                }

        }

}
