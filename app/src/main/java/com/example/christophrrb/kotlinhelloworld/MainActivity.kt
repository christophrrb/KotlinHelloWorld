package com.example.christophrrb.kotlinhelloworld

 import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
 import android.content.Context
 import android.graphics.drawable.Drawable
 import android.view.View
 import android.widget.ImageView
 import android.widget.Toast
 import com.example.christophrrb.kotlinhelloworld.R
import kotlinx.android.synthetic.main.activity_main.*
 import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView.resources.getDrawable(R.mipmap.atlanta_jazz_festival_selfie);
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
}
