package com.example.aplicacion_cuadrado

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.text.toFloat
import android.graphics.Color

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var botonArriba: Button =findViewById<Button>(R.id.Arriba)

        var botonDerecha: Button =findViewById<Button>(R.id.Derecha)

        var botonAbajo: Button =findViewById<Button>(R.id.Abajo)

        var botonIzquierda: Button =findViewById<Button>(R.id.Izquierda)

        var CambiarTamaño: Button =findViewById<Button>(R.id.CambiarTamaño)

        var CambiarColor: Button =findViewById<Button>(R.id.CambiarColor)

        // Encuentras la vista del cuadrado rojo
        val miVistaCuadrado = findViewById<View>(R.id.view)

        // Instancias tu objeto de la clase Cuadrado pasándole la vista
        val miObjetoCuadrado = Cuadrado(miVistaCuadrado)

        val reiniciar : Button = findViewById<Button>(R.id.Reiniciar)



        botonArriba.setOnClickListener {
            miObjetoCuadrado.moverArriba(50)
        }
        botonAbajo.setOnClickListener {
            miObjetoCuadrado.moverAbajo(50)
        }

        botonIzquierda.setOnClickListener{
            miObjetoCuadrado.moverIzquierda(50)
        }

        botonDerecha.setOnClickListener{
            miObjetoCuadrado.moverDerecha(50)
        }

        CambiarTamaño.setOnClickListener {
            miObjetoCuadrado.cambiarTamaño(500,500)
        }



        CambiarColor.setOnClickListener {
            miObjetoCuadrado.cambiarColor(Color.parseColor("BLUE"))
        }
        reiniciar.setOnClickListener {
            miObjetoCuadrado.reiniciar(0,0,Color.parseColor("RED"))
        }

        }
    }

//Definimos una vista que va a funcionar como nuestros ojos
class Cuadrado(val vistaReal: View){
//Cualquier elemento visual tiene parametros de diseño
    //creamos los metodos de nuestro objeto

    //Mover arriba
    fun moverArriba(pixeles: Int){
    //Como empieza en 0 debemos restarle pixeles para que suba y el float es porque es decimal

        vistaReal.translationY-=pixeles.toFloat()
    }
    //Mover a la Derecha
    fun moverDerecha(pixeles: Int){
        vistaReal.translationX+=pixeles.toFloat()
    }
    //Mover Abajo
    fun moverAbajo(pixeles: Int){
        vistaReal.translationY+=pixeles.toFloat()
    }
    //Mover a la Izquierda
    fun moverIzquierda(pixeles: Int){
        vistaReal.translationX-=pixeles.toFloat()
    }
    //Cambiar el tamaño
    fun cambiarTamaño(nuevoAncho: Int, nuevoAlto: Int){
        val params = vistaReal.layoutParams

        params.width = nuevoAncho
        params.height = nuevoAlto
        vistaReal.layoutParams = params
    }
    //Cambiar el color
    fun cambiarColor(nuevoColor: Int){
        vistaReal.setBackgroundColor(nuevoColor)
    }
    fun reiniciar(nuevoAncho: Int, nuevoAlto: Int,nuevoColor: Int){
        vistaReal.translationY=0.toFloat();

        vistaReal.translationX=0.toFloat();
        vistaReal.setBackgroundColor(nuevoColor);
        val params = vistaReal.layoutParams

        params.width = nuevoAncho
        params.height = nuevoAlto
        vistaReal.layoutParams = params

    }
}