//package com.example.myapplication
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val button1 = findViewById<Button>(R.id.encrypt_button)
//        button1.setOnClickListener {
//            val intent = Intent(this, encrypt_page ::class.java)
//            startActivity(intent)
//        }
//
//        val button2 = findViewById<Button>(R.id.decrypt_button)
//        button2.setOnClickListener {
//            val intent = Intent(this, decrypt_page ::class.java)
//            startActivity(intent)
//        }
//    }
//}
package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var button: Button
    private val pickImage = 100
    private var imageUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "ImageSteg"
        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.encrypt_button)
        button.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }
    }

    //This override needs to be checked
    /*override*/ fun OnActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            imageView.setImageURI(imageUri)
        }
    }
}