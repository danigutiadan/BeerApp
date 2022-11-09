package com.danigutiadan.mo2o_test.ui

import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.reflect.KProperty

abstract class BaseViewModel : ViewModel() {
    val lazyMgr = resettableManager()

    fun resetValues() {
        lazyMgr.reset()
    }

    abstract fun isValid(): ViewModelValidation
}

class ResettableLazyManager {
    // we synchronize to make sure the timing of a reset() call and new inits do not collide
    private val managedDelegates = LinkedList<Resettable>()

    fun register(managed: Resettable) {
        synchronized(managedDelegates) {
            managedDelegates.add(managed)
        }
    }

    fun reset() {
        synchronized(managedDelegates) {
            managedDelegates.forEach { it.reset() }
            managedDelegates.clear()
        }
    }
}

interface Resettable {
    fun reset()
}

class ResettableLazy<T>(private val manager: ResettableLazyManager, val init: () -> T) :
    Resettable {
    @Volatile
    var lazyHolder = makeInitBlock()

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return lazyHolder.value
    }

    override fun reset() {
        lazyHolder = makeInitBlock()
    }

    private fun makeInitBlock(): Lazy<T> {
        return lazy {
            manager.register(this)
            init()
        }
    }
}

fun <T> resettableLazy(manager: ResettableLazyManager, init: () -> T): ResettableLazy<T> {
    return ResettableLazy(manager, init)
}

fun resettableManager(): ResettableLazyManager = ResettableLazyManager()

data class ViewModelValidation(var valid: Boolean = false, var reason: String? = null)