package com.example.animations

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.imageview.ShapeableImageView

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ShapeableImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        imageView = findViewById(R.id.imageView)
        val btnBlink: Button = findViewById(R.id.btnBlink)

        btnBlink.setOnClickListener {
            objectAnimator()
        }
    }

    private fun alphaAnimation() {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.apply {
            duration = 80
            startOffset = 20
            repeatMode = Animation.REVERSE
            repeatCount = Animation.INFINITE
        }
        imageView.startAnimation(anim)
    }

    private fun objectAnimator() {
        val moveAnim = ObjectAnimator.ofFloat(imageView, "rotation", 1000f)
        moveAnim.duration = 2000
        moveAnim.start()
    }
}