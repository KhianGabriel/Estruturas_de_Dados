class PilhaEstaticaInvertida : EmpilhavelIn {
    // Variaveis globais
    private var ponteiroTopo: Int
    private var dados: Array<Any?>
    // contrutores
    constructor() : this(10) {}

    constructor(tamanho: Int) {
        /*Como a pilha é inversa, ao inves de começar com -1 e após empilhar vira 0, no caso será o
        tamanho do array, exemplo se o array é de tamanho  = 5 a primeira posição do array será a 5, e depois
        de empilhada o ponteiro será 4.
        A decelarção do array é a mesma
         */
        ponteiroTopo = tamanho
        dados = arrayOfNulls(tamanho)
    }
    // metodos auxiliares
    override fun estaCheia(): Boolean {
        /*A verificação de que a pilha está cheia é a mesma ideia de dados.size -1, o exemplo seria que começaria com
        4,3,2,1,0 e a última posição acessada será o 0 */
        return (ponteiroTopo == 0)
    }
    override fun estaVazia(): Boolean {
        /*A verificação de estar vazia será quando o ponteirTopo for o mesmo valor do tamanho da pilha */
        return (ponteiroTopo == dados.size)
    }
    override fun imprimir(): String {
        /*O imprimir é quase a mesma coisa o que muda é a forma da iteração, que antes era do tamanho do ponteiroTopo
        até 0 que é o inicio da pilha para do ponteiroTopo que será 2 por exemplo até 4 que o tamanho do array-1 */
        var resultado: String = "["
        // Iterar a pilha
        // Palavra to ou downto o downto é do ponteiroTopo até 0 / to seria do 0 até ponteiroTopo só
        // que de forma invertida
        // Caso eu queira que o count fosse mais do que 1, acrescentasse a palvra chave step to e o
        // valor desejado
        for (i in ponteiroTopo..dados.size - 1) {
            if (i == dados.size - 1) {
                resultado += "${dados[i]}"
            } else {
                resultado += "${dados[i]},"
            }
        }
        return "$resultado]"
    }
    // metodos principais
    /*Empilhaer é quase a mesma coisa só muda que ao inves de acrescentar uma posicação, acaba-se decrementando
    pois agora ao inves de ser de 0 a 5 será 5 a 0 ou sejá decrescendo, então primeiro decresce o ponteiro e depois
    aloca o dado na posição  */
    override fun empilhar(dado: Any?) {
        if (!estaCheia()) {
            ponteiroTopo--
            dados[ponteiroTopo] = dado
        } else {
            print("A pilha esta cheia")
        }
    }
    // Remoção dos valores de uma pilha
    /*Desempilhar é quase a mesma coisa, só muda que como inverteu o processo o ponteiroTopo ao inves de ser
    decrementado para a posição anterior como de 3 para 2, agora sera de 2 para 3 até chegar no inicio que seria 5 */
    override fun desempilhar(): Any? {
        var retorno: Any? = null
        if (!estaVazia()) {
            retorno = dados[ponteiroTopo]
            ponteiroTopo++
        } else {
            print("Stack is empty")
        }
        return retorno
    }
    // Verificação do topo da pilha
    /*A função topo é a mesma pois ela não mexe na estrutura da pilha e sim só retorna o valor que esta no topo */
    override fun topo(): Any? {
        var retorno: Any? = null
        if (!estaVazia()) {
            retorno = dados[ponteiroTopo]
        } else {
            print("Stack is empty")
        }
        return retorno
    }
}
