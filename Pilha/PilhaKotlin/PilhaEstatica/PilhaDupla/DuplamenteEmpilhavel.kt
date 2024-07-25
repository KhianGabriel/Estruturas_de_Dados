interface DuplamenteEmpilhavel {
    // Metodos principais
    fun empilhar1(dado1: Any?)
    fun empilhar2(dado2: Any?)
    fun desempilhar1(): Any?
    fun desempilhar2(): Any?
    fun topo1(): Any?
    fun topo2(): Any?
    // Metodos auxiliares
    fun estaCheia1(): Boolean
    fun estaCheia2(): Boolean
    fun estaVazia1(): Boolean
    fun estaVazia2(): Boolean
    fun imprimir1(): String
    fun imprimir2(): String
}
