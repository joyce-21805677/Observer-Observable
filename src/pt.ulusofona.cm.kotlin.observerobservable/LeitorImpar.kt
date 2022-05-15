package pt.ulusofona.cm.kotlin.observerobservable

class LeitorImpar(nome: String) : Leitor(nome), OnNumeroListener {

    var lista: MutableList<Int> = mutableListOf()

    fun imprimeNumeros(): String{
        return "$nome leu os seguintes numeros impares: ${lista.toString()}"
    }
    
    override fun onReceiveNumero(numero: Int) {
        lista.add(numero)
    }

}
