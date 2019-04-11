package me.james.language

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * copyright：
 * author： James
 * date：2019/4/11 16:00
 * description：
 */
object DelegatesExt {

    fun<T> notNullSingleValue():ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
}

class NotNullSingleValueVar<T> :ReadWriteProperty<Any?, T>{

    private var value:T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("${property.name} not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value else throw IllegalStateException("${property.name} not initialized")
    }
}