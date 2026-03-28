package Dominio.Modelos;
import Dominio.Entidades.*;
public class Livro{

    public int ID;
    public String Titulo;
    public String Autor;
    public String Categoria;
    public int Ano;
    
    public FileDeEspera filaEspera;


    public Livro(String titulo, String autor, int ano){
        this.Titulo=titulo;
        this.Autor=autor;
        this.Ano=ano;
    }

    public String toString(){
        return this.ID+" [Titulo]:"+this.Titulo+" [Autor]: "+this.Autor+" [Ano]:"+this.Ano+" ";
    }
}


