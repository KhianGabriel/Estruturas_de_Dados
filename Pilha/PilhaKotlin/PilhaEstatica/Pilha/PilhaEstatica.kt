class PilhaEstatica : Empilhavel {
    // variaveis globais
    // val x var = val -> valor da variavel é constante == final em java / var -> variavel
    private var ponteiroTopo: Int
    private var dados: Array<Any?>
    // contrutores
    constructor() : this(10) {}

    constructor(tamanho: Int) {
        // Ponteiro topo começa com -1 pois o array ainda esta vazio, assim que for incrementado
        // um valor no array o ponteiro topo passa para 0 e assim sucessivamente
        ponteiroTopo = -1
        // Forma de declaração de um array em kotlin, passando o parametro tamanho que será passado
        // pelo o úsuario
        dados = arrayOfNulls(tamanho)
    }
    // metodos auxiliares
    override fun estaCheia(): Boolean {
        /* Verificação do array esta cheio, onde se o ponteiroTopo atingir o limite do tamanho
        do array identifica-se que o array esta cheio e a função retornara true, se não false*/
        return (ponteiroTopo == dados.size - 1)
    }
    override fun estaVazia(): Boolean {
        /*Verificação do array esta vazio, o ponteiroTopo é inicializado com -1, ou seja
        quando o array não apresenta nenhum valor, ou seja se ponteiroTopo for o mesmo valor que
        ele foi inicializado, logo o array estará vazio, onde a função retornará true */
        return (ponteiroTopo == -1)
    }
    override fun imprimir(): String {
        /* Variavel resultado que inicializa com colchetes para deixar da forma [, , , ] a impressão
        do array */
        var resultado: String = "["
        // Iterar a pilha
        // Palavra to ou downto o downto é do ponteiroTopo até 0 / to seria do 0 até ponteiroTopo só
        // que de forma invertida
        // Caso eu queira que o count fosse mais do que 1, acrescentasse a palvra chave step to e o
        // valor desejado
        /*Laço para iteração do array, onde o meu contador i que vai do valor do ponteiroTopo
        até 0 ou seja enquanto ponteiroTopo > 0 faça, caso o contrario utiliza-se a palavra chave .. */
        for (i in ponteiroTopo downTo 0) {
            if (i == 0) {
                /*Laço if para não por a , no último elemento do array, e a String resultado
                vai sendo adicionada cada elemento do arrray e depois a função retorna o resultado
                com o fechamento do ] */
                resultado += "${dados[i]}"
            } else {
                resultado += "${dados[i]},"
            }
        }
        return "$resultado]"
    }
    // metodos principais
    /*Função empilhar para adicionar dados a pilha, onde para adicionar um valor deve-se saber
    se a pilha esta cheia com a função estaCheia(), após isso a incrementação do ponteiro para o novo
    valor ser alocado em uma posição nula e não sobrescrever um dado, e após isso a alocação do
    novo dado no array com a seguinte formula array[ponteiroTopo] = dado, e caso o array esteja
    cheio será retornado uma mensagem avisando */
    override fun empilhar(dado: Any?) {
        if (!estaCheia()) {
            ponteiroTopo++
            dados[ponteiroTopo] = dado
        } else {
            print("A pilha esta cheia")
        }
    }
    // Remoção dos valores de uma pilha
    /*Função desempilhar para remover um dado da pilha, onde para desempilhar deve-se saber se o
    array não está vazio, porque da e não têm como retirar nenhum dado. Inicialmente se cria uma
    variavel para receber o valor que foi desempilhado, para mostrar para o úsuario e em seguida faz-se a veri
    ficação do array com o metodo estaVazia, e caso não esteja a variavel retorno recebera o valor do topo da pilha
    e em seguida a valor de ponteiroTopo será decrementado fazendo com que o dado da posição anterior se torne o novo
    topo, e caso esteja vazia será retornado ao úsuario uma mensagem */
    override fun desempilhar(): Any? {
        var retorno: Any? = null
        if (!estaVazia()) {
            retorno = dados[ponteiroTopo]
            ponteiroTopo--
        } else {
            print("Stack is empty")
        }
        return retorno
    }
    // Verificação do topo da pilha
    /*Função do topo que retorna qual elemento está no topo, primeiramente criando-se uma variavel que irá
    retornar qual o elemento que está no topo e em seguida faz-se a verificação e que a pilha não está vazia
    e passa o elemento que está no topo para a variavel que armazenará o valor que está no topo e retornará para
    o úsuario o valor */
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
