package br.com.brulight.gerenciador_gastos.extensions

import java.security.InvalidParameterException

fun Int.monthNumberToText(): String {

    return when (this) {
        0 -> "Janeiro"
        1 -> "Fevereiro"
        2 -> "Março"
        3 -> "Abril"
        4 -> "Maio"
        5 -> "Junho"
        6 -> "Julho"
        7 -> "Agosto"
        8 -> "Setembro"
        9 -> "Outubro"
        10 -> "Novembro"
        11 -> "Dezembro"

        else -> {
            throw InvalidParameterException("Mês selecionado inválido")
        }
    }
}