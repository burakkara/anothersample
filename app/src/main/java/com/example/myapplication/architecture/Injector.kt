package com.example.myapplication.architecture

class Injector private constructor() {
    companion object {
        fun get(): AppComponent =
            MainApplication.get().appComponent
    }
}