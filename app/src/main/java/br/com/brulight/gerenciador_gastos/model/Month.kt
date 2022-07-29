package br.com.brulight.gerenciador_gastos.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Month(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String,
    val year: Int
) : Parcelable
