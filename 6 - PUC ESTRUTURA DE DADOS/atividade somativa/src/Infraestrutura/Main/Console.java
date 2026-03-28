package Infraestrutura.Main;

import Adaptadores.Controladores.*;
import Adaptadores.Repositorios.*;
import Aplicacao.CasosDeUso.*;
import Dominio.Entidades.ListaDeLivros;

public class Console {

    public static void main(String[] args) {

    

        // configura aplicação
        Console app = new Console(new BibliotecaLivros(new ListaDeLivros()));

        // mocar dados
        // Livro[] livrosMocados = {
        // new Livro("Livro 1", "Autor 1", 1),
        // new Livro("Livro 2", "Autor 2", 2),
        // new Livro("Livro 3", "Autor 3", 3),
        // };

        // roda aplicação
        app.Run();

    }

}
