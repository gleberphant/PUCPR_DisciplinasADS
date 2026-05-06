package Dominio.Modelos;

public class Emprestimo {
    public int id;
    public Usuario locador;
    public Livro livro;
    public String dataEmprestimo;
    public StatusEmprestimo status;
}
