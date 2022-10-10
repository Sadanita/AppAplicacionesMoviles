package com.example.diceroller
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    /*El metodo es llamada una vez que las actividades esten creadas */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Encontrar el boton dentro de la plantilla
        val rollButton: Button = findViewById(R.id.button)
        // Cuando se hace clic se envia la orden que mantiene la funcion roll
        rollButton.setOnClickListener { rollDice() }
        // Se llama a la funcion
        rollDice()
    }
    /*Se actualizan los resultados*/
    private fun rollDice() {
        // Creando un nuevo dado de 6 caras
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Se encuentra la imagen en la UI
        val diceImage: ImageView = findViewById(R.id.imageView)
        // Nos basamos en las caracteristicas del dado
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Se actualiza el resultado del dado
        diceImage.setImageResource(drawableResource)
        // Se actualiza la descripcion
        diceImage.contentDescription = diceRoll.toString()
    }
}
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}