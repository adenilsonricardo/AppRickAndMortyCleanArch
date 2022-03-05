package com.example.apprickandmortycleanarch.utils

interface Mapper<S,T> {
    fun map(source: S): T
}