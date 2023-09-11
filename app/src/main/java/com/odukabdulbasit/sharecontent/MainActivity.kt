package com.odukabdulbasit.sharecontent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shareButton = findViewById<Button>(R.id.shareButton)

        shareButton.setOnClickListener {
            shareContent("Hello, this is the content to share.")
        }
    }

    private fun shareContent(content: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, content)

        // You can also add additional options for the chooser dialog
        val chooserTitle = "Share via"
        val shareIntent = Intent.createChooser(intent, chooserTitle)

        // Verify that the intent will resolve to an activity before starting it
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(shareIntent)
        }
    }
}
