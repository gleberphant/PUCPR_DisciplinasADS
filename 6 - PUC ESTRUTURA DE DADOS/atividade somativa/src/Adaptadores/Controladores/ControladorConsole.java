package Adaptadores.Controladores;

import Aplicacao.Interfaces.IControlador;
import Dominio.Modelos.Livro;
import Aplicacao.Interfaces.ICasodeUso;

public class ControladorConsole implements IControlador {

    public ICasodeUso servico;

    public ControladorConsole(ICasodeUso servico) {
        this.Config(servico);
    }

    private void Config(ICasodeUso servico) {
        this.servico = servico;
    }

    public void Run() {

        // loop principal
        while (true) {
            int select = Home();

            switch (select) {
                case 1:
                    AdicionarLivro();
                    break;
                case 2:
                    VisualizarLivro();
                    break;
                case 3:
                    ListarLivros();
                    break;
                case 0: // Opção explícita de saída
                    Sair();
                    return; // Quebra o loop e sai do método
                default:
                    // Tratamento de opção inválida
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    public int Home() {
        System.out.println("Biblioteca de livros");
        System.out.println(".......... MENU ..........");
        System.out.println(". 1.Usuarios  ");
        System.out.println(". 1.1-> Adicionar USUÁRIO   ");
        System.out.println(". 1.2-> Visualizar USUÁRIO ");
        System.out.println(". 1.3-> Editar USUÁRIO ");
        System.out.println(". 1.4-> Listar todos USUÁRIOS  ");
        System.out.println(". 2.Livros  ");
        System.out.println(". 2.1-> Adicionar um livro   ");
        System.out.println(". 2.2-> Visualizar um  livro ");
        System.out.println(". 2.3-> Editar um  livro ");
        System.out.println(". 2.4-> Listar todos livros  ");
        System.out.println(". 2.5-> Listar todas categorias  ");
        System.out.println(". 3.Fila de Espera  ");
        System.out.println(". 3.1-> Adicionar usuario a a fila de um livro ");
        System.out.println(". 3.2-> Visualizar a fila de um livro");    
        System.out.println(". 4.Historico Navegação  ");
        System.out.println(". 4.1-> Visualizar historico navegação ");
        System.out.println(". 5.Recomendações  ");
        System.out.println(". 5.1-> Adicionar Leitura a um usuário ");
        System.out.println(". 5.2-> Visualizar Leituras de um usuário ");
        System.out.println(". 5.3-> Visualizar Recomendações por Livro ");
        System.out.println(". 5.4-> Visualizar Recomendações por Usuario");
        System.out.println("..........................");

        int select = 0;

        return select;
    }

    public void AdicionarLivro() {

        System.out.println("Informe os dados do livro");

        String titulo = "Livro ";// ler titulo
        String autor = "Autor ";// ler autor
        int ano = 2026;// ler ano

        servico.AdicionarLivro(new Livro(titulo, autor, ano));

    }

    public void EditarLivro() {

        System.out.println("Informe o ID do livro para editar");

        int id = 0; // ler dados

        Livro livroEditado = servico.VisualizarLivro(id);

        System.out.println("Informe os novos dados do livro");

        livroEditado.titulo = "Novo Livro ";// ler titulo
        livroEditado.autor = "Novo Autor ";// ler autor
        livroEditado.ano = 0;// ler ano

        servico.EditarLivro(livroEditado);

    }

    public void VisualizarLivro() {

        System.out.println("Informe o ID do livro para pesquisar");

        int id = 0; // ler dados

        Livro livro = servico.VisualizarLivro(id);

        System.out.println("Visualizando o livro > " + id);
        System.out.println(livro);
    }

    public void ListarLivros() {

        System.out.println("Listando todos os livros");
        Livro[] livros = servico.ListarLivros();

        for (Livro livro : livros) {
            System.out.println(" ** " + livro.toString() + " ");
        }

    }

    public void RemoverLivro() {

        System.out.println("Informe o ID do livro para remover");

        int id = 0; // ler dados

        servico.RemoverLivro(id);

        System.out.println("Removendo o livro > " + id);

    }

    public void Sair() {
        System.out.println("Saindo da Aplicação");

    }
}