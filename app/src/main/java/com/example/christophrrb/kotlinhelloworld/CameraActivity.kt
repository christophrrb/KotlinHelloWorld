package com.example.christophrrb.kotlinhelloworld

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v4.content.ContextCompat.checkSelfPermission
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_camera.*
import org.jetbrains.anko.*
import java.util.jar.Manifest
import io.vrinda.kotlinpermissions.PermissionCallBack
import io.vrinda.kotlinpermissions.PermissionsActivity

class CameraActivity : PermissionsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener(View.OnClickListener { view ->
            Snackbar.make(view, "You're in the camera activity!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        })
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        cameraPermission.setOnClickListener {
            requestPermissions(android.Manifest.permission.CAMERA, object : PermissionCallBack {
                override fun permissionGranted() {
                    super.permissionGranted()
                    Log.v("Camera permission", "GRANTED") //It's Log.v because you're logging to verbose.
                    val REQUEST_IMAGE_CAPTURE = 1;
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
                    }
                }

                override fun permissionDenied() {
                    super.permissionDenied()
                    Log.v("Camera permission", "DENIED")
                }
            })
        }

        callPermission.setOnClickListener {
            requestPermissions(android.Manifest.permission.CALL_PHONE, object : PermissionCallBack {
                override fun permissionGranted() {
                    super.permissionGranted()
                    Log.v("Call permission", "Granted")
                    val intent = Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + 1234567890));
                }

                override fun permissionDenied() {
                    super.permissionDenied()
                    Log.v("Call permission", "Denied")
                    alert("This permission must be accepted to make the call", "Call Permission Denied") {
                        positiveButton("OK") {  }
                        negativeButton("Cancel") {  }
                    }.show();
                }
            })
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            var extras:Bundle = data!!.extras;
            var imageBitmap: Bitmap = extras.get("data") as Bitmap;
            imageView2.setImageBitmap(imageBitmap);
            toast("I was called.");
        } else {
            toast("There result came back false.");
        }
    }
}
