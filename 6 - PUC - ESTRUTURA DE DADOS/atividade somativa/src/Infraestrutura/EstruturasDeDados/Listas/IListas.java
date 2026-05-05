package Infraestrutura.EstruturasDeDados.Listas;

public interface IListas<T> {

    public boolean Inserir(T dado);

    public NoLista<T> GetPrimeiroNo();

    public NoLista<T> GetProximoNo();

    public NoLista<T> GetUltimoNo();

    public boolean ReiniciarPonteiro();

    public boolean MoverPonteiro();

    public T GetPrimeiroDado();

    public T GetDadoAtual();

    public T Get(int i);

    public void Set(int i, T dado);

    public void RemoverNo(int i);

    public T GetUltimoDado();

    public int Tamanho();

    public String toString();
}
