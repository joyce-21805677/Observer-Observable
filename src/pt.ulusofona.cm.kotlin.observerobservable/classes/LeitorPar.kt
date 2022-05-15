package pt.ulusofona.cm.kotlin.observerobservable.classes

import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNumeroListener

class LeitorPar(nome: String) : Leitor(nome), OnNumeroListener {

    var lista: MutableList<Int> = mutableListOf()

    fun imprimeNumeros(): String{
        return "$nome leu os seguintes numeros pares: ${lista.toString()}"
    }


    override fun onReceiveNumero(numero: Int) {
        lista.add(numero)
    }
}
