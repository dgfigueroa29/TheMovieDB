package com.example.boa.domain.core

/**
 * Base Mapper with standard behaviour. Must be specified class to convert and result class types.
 */
abstract class BaseMapper<I, O> {
    abstract fun map(input: I): O

    fun mapAll(input: Collection<I>?): List<O> {
        val list = ArrayList<O>()
        if (input != null) {
            input.takeIf { it.isNotEmpty() }?.forEach {
                val mapped = map(it)

                if (!list.contains(mapped)) {
                    list.add(mapped)
                }
            }
        }

        return list
    }
}