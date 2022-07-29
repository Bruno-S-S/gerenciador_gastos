package br.com.brulight.gerenciador_gastos.converter

import androidx.room.TypeConverter
import java.math.BigDecimal

class Converters {

    @TypeConverter
    fun doubleToBigDecimal(value: Double?): BigDecimal {
        return value?.let { BigDecimal(value.toString()) } ?: BigDecimal.ZERO
    }

    @TypeConverter
    fun bigDecimlaToDouble(value: BigDecimal?): Double? {
        return value?.let { value.toDouble() }
    }
}