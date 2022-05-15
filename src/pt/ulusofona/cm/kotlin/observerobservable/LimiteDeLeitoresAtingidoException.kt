package pt.ulusofona.cm.kotlin.observerobservable

class LimiteDeLeitoresAtingidoException(private val msg: String) : Exception() {

    override fun toString(): String {
        return msg // TODO: testar
    }

}
