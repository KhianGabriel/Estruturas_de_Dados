package Lista.ListaJava.ListaEstatica;

public interface Listavel {
    

    //Metodos Principais
    public void anexar(Object dado);
    public void inserir(int posicao, Object dado);
    public Object selecionar(int posicao);
    public Object[] selecionarTodos();
    public void atualizar(int posicao, Object dado);
    public Object apagar(int posicao);

    //Metodos Auxiliares
    public boolean estaVazia();
    public boolean estaCheia();
    public String imprimir();
 }
