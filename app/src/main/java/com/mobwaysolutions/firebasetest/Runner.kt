package com.mobwaysolutions.firebasetest

import com.mobwaysolutions.firebasetest.model.Gender

fun main() {
    mostrarGenero(Gender.MASCULINO)
    mostrarGenero(Gender.FEMINNO)
    mostrarGenero(Gender.OUTRO)
}

fun mostrarGenero(g : Gender) {
    println("$g - ${g.name} - ${g.ordinal} === Color: ${g.color}")
}