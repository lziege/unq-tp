package io.paketo.demo.service

interface GenericService<T> {
    fun save(entity: T): T
    fun read(id: Long): T
}

interface MongoGenericService<T> {
    fun save(entity: T): T
    fun read(id: String): T
}