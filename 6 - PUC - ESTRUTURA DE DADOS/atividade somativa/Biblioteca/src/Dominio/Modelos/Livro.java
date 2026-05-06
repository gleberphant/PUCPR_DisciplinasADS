package Dominio.Modelos;

import java.lang.Comparable;

import Dominio.MinhasEstruturasDeDados.Listas.Fila;

public class Livro implements Comparable<Livro> {

    // eu pretendia utilizar UUID mas isso vai dificultar os testes
    public Integer ID;

    public String Titulo;
    public String Autor;
    public String Ano;
    public String Categoria;
    public boolean Disponivel;

    public Usuario Locador;
    public Fila<Usuario> FilaEspera; // FILA DE ESPERA VAI RECEBER USUARIOS

    public Livro() {
        SetLivro(0, "titulo", "autor", "ano");
        this.Disponivel = true;
    }

    public Livro(int id, String titulo, String autor, String ano) {

        SetLivro(id, titulo, autor, ano);

    }

    public Livro(String id, String titulo, String autor, String ano) {

        SetLivro(Integer.parseInt(id), titulo, autor, ano);

    }

    public void SetLivro(int id, String titulo, String autor, String ano) {

        this.ID = id;
        this.Titulo = titulo;
        this.Autor = autor;
        this.Ano = ano;
        FilaEspera = new Fila<>();

    }

    // mostrar string em formato json
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (var usuario : this.FilaEspera) {
            sb.append(String.format("Usuario: '%s', ", usuario.Nome));
        }

        return String.format("""
                { ID:'%s', Titulo:'%s', Autor:'%s', Ano:'%s', Locado Para:'%s', Fila Espera:[%s] }
                """,
                this.ID,
                this.Titulo,
                this.Autor,
                this.Ano,
                (this.Locador != null ? this.Locador.Nome : "'Ninguém'"),
                (this.FilaEspera.Tamanho() > 0 ? sb.toString() : "'Sem espera'"));
    }

    @Override
    // compara apenas o ID
    public int compareTo(Livro outro) {
        // Verifica se o objeto comparado é nulo
        if (outro == null)
            return 1;

        // comapara o id
        if (ID == outro.ID)
            return 0;
        if (ID > outro.ID)
            return 1;
        else
            return -1;
        // return this.ID.compareTo(outro.ID);
    }
}
