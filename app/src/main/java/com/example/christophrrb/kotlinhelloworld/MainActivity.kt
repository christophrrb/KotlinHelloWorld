package com.example.christophrrb.kotlinhelloworld

 import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
 import android.content.Context
 import android.content.Intent
 import android.graphics.drawable.Drawable
 import android.view.View
 import android.widget.ImageView
 import android.widget.Toast
 import com.example.christophrrb.kotlinhelloworld.R
import kotlinx.android.synthetic.main.activity_main.*
 import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView.resources.getDrawable(R.drawable.atlanta_jazz_festival_selfie);

        button4.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("dato", nombre.text)
            startActivity(intent)
        }
    }

    fun cambiarTexto(v: View) {
        if (miTexto.text != resources.getString(R.string.button1_text)) {
            miTexto.text = resources.getString(R.string.button1_text);
        } else {
            miTexto.text = resources.getString(R.string.hello_world);
        }
    }

    fun ingresarNombre(v: View) {
        miTexto.text = nombre.text;
    }

    fun hacerVisibleLaFoto(v: View) {
        if (imageView.visibility != View.VISIBLE) {
            imageView.visibility = View.VISIBLE;
        } else {
            imageView.visibility = View.INVISIBLE;
        }
    }

    fun toast(v: View) {
        toast("Tastes so good.");
    }

//    companion object {
//
//        fun segundaActividad(nombre: String, context: Context): Intent {
//            var dato: String = nombre;
//            val intent: Intent = Intent(context, SecondActivity::class.java);
//            intent.putExtra("nombre", nombre);
//            return intent;
//        }
//    }
}
