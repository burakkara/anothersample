package com.example.myapplication

interface Mapper<in From, out To> {
    fun map(from: From): To
}