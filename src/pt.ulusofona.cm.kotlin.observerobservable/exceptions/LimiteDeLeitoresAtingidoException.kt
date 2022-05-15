package pt.ulusofona.cm.kotlin.observerobservable.exceptions

class LimiteDeLeitoresAtingidoException(private val msg: String) : Exception() {

    override fun toString(): String {
        return msg // TODO: testar
    }

}
