package com.example.animations

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
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
        val btnIntent: Button = findViewById(R.id.btnIntent)

        btnIntent.setOnClickListener {
            Intent(this, SecondActivity::class.java).also {
                startActivity(it)
            }
        }

        btnBlink.setOnClickListener {
            moveAnim()
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

    private fun scaleX() {
        val scaleAnim = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 2.0f)
        scaleAnim.duration = 3000
        scaleAnim.repeatCount = ValueAnimator.INFINITE
        scaleAnim.repeatMode = ValueAnimator.REVERSE
        scaleAnim.start()
    }

    private fun moveAnim() {
        val moveAnim = ObjectAnimator.ofFloat(imageView, "Y", 1000F)
        moveAnim.duration = 2000
        moveAnim.interpolator = BounceInterpolator()
        moveAnim.start()
    }
}