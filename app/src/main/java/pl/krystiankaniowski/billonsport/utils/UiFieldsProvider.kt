package pl.krystiankaniowski.billonsport.utils

class UiFieldsProvider {

    companion object {

        fun <V> justOk(value: V): UiFieldSet<V> = object : UiFieldSet<V> {
            override fun value(): V = value
            override fun validation(): Boolean = true
            override fun getError(): String? = null
        }

    }

}