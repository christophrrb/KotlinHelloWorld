package com.example.christophrrb.kotlinhelloworld

 import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
 import android.content.Context
 import android.content.Intent
 import android.graphics.drawable.Drawable
 import android.text.Editable
 import android.text.TextWatcher
 import android.view.View
 import android.widget.ImageView
 import android.widget.Toast
 import com.example.christophrrb.kotlinhelloworld.R
 import com.pawegio.kandroid.textWatcher
 import kotlinx.android.synthetic.main.activity_main.*
 import kotlinx.android.synthetic.main.activity_scroll.*
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

            /*Use a bundle to transfer bigger/more complicated data between activities.

            var intent = Intent(this@MainActivity, ActivityToGoTo);
            var bundle = Bundle();

            bundle.putInt("myInt", 1);
            bundle.putString("myString", "1");
            bundle.putBoolean("myBoolean", true);
            bundle.putChar("myChar", "a");
            bundle.putDouble("myDouble", 1.00);

            intent.putExtra("bun", bundle);
            startActivity(intent);

            Some of the put..()s might be wrong, but it's not too far off. It might be something like putBool() instead of putBoolean().
             */
        }

        nombre.textWatcher {
                beforeTextChanged { charSequence, i, j, k ->  }
                onTextChanged { charSequence, i, j, k -> toast("Text was changed."); }
                afterTextChanged { charSequence -> }
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
}
