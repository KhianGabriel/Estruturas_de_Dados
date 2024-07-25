interface Listavel {
    // Metodos principais

    //Adiciona o dado na última posição
    fun anexar(dado: Any?)
    //Insere um dado em uma posição que não esteja ocupada
    fun inserir(posicao: Int, dado: Any?)
    //
    fun selecionar(posicao: Int): Any?
    //
    fun selecionarTodos(): Array<Any?>
    //Troca o valor da posicao informada pela a que foi passada
    fun atualizar(posicao: Int, dado: Any?)
    fun apagar(posicao: Int): Any?

    // Metodos auxiliares
    //Identico da fila os três metodos auxiliares
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}