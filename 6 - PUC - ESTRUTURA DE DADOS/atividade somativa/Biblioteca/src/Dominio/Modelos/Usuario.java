package Dominio.Modelos;

import Dominio.MinhasEstruturasDeDados.Listas.*;

public class Usuario implements Comparable<Usuario> {

    public Integer ID;
    public String Nome;
    public String CPF;
    public String Senha;
    public Pilha<Livro> historicoNavegacao;

    public Usuario() {
        SetUsuario(0, "", "", "");

    }

    public Usuario(int id, String nome, String cpf, String senha) {
        SetUsuario(id, nome, cpf, senha);

    }

    public void SetUsuario(int id, String nome, String cpf, String senha) {
        this.ID = id;
        this.Nome = nome;
        this.CPF = cpf;
        this.Senha = senha;
        historicoNavegacao = new Pilha<>();
    }

    // mostrar string em formato json
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (var livro : this.historicoNavegacao) {
            sb.append(String.format("Livro:'%s', ", livro.Titulo));
        }

        return String.format("""
                {ID: '%d', Nome: '%s', Senha: '%s', Leituras: [%s]}
                """,
                this.ID,
                this.Nome,
                this.Senha,
                sb.toString());
    }

    @Override
    public int compareTo(Usuario outro) {
        // Verifica se o objeto comparado é nulo
        if (outro == null)
            return 1;

        // Delega a comparação para a implementação de comparação ao tipo
        return this.ID.compareTo(outro.ID);
    }
}
