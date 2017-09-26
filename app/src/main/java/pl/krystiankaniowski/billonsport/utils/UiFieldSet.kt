package pl.krystiankaniowski.billonsport.utils

interface UiFieldSet<V> {

    fun value() : V

    fun validation() : Boolean

    fun getError() : String?

}