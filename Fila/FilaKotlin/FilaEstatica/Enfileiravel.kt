interface Enfileiravel{
   
    //Metodos principais
    /* Metodo para enfileirar um novo dado no fim da fila
       Diferença do metodo empilhar da pilha, no empilhar o dado é alocado no inicio do array, já na fila
       é ao contrario é alocado no final da estrutura
     */
    fun enfileirar(dado: Any?)
    /*Metodo para desenfileirar o dado do começo da fila, diferente do metodo desempilhar da pilha,
    que desempilha o último dado da estrutura - LIFO(Last in first out), ou seja, o último dado a entrar
    é o primeiro a sair. Porém na fila é diferente FIFO(First in, first out), ou seja, o primeiro dado
    a entrar é o primeiro a sair */
    fun desenfileirar(): Any?
    /* Modifica o dado da posicao selecionada, também pode ser utilizado na pilha da mesma forma*/
    fun atualizar(dado: Any?)
    /* Metodo que verifica o dado que esta no inicio da fila, muito parecido com o metodod topo da 
    estrutura pilha*/
    fun espiar(): Any?

    //Metodos auxiliares
    //Verificar se a estrutura esta cheia
    fun estaCheia(): Boolean
    //Verificar se a estrutura esta vazia
    fun estaVazia(): Boolean
    //Imprimir a estrutura, imprimindo do primeiro valor ao último
    fun imprimir(): String

    /*
    // Metodos principais Pilha x Fila
    fun empilhar(dado: Any?) = fun enfileirar(dado: Any?)
    fun desempilhar(): Any? = fun desenfileirar(): Any?
    fun topo(): Any? = fun espiar(): Any?
    // Metodos auxiliares
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
    */

}