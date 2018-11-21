package com.example.aparecido.myapplication

interface BasePresenter<V> {
    fun attach(view: V)
    fun detach()
}