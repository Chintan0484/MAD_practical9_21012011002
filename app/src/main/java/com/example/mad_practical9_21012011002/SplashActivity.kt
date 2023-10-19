package com.example.mad_practical9_21012011002

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.widget.ImageView
import android.view.animation.AnimationUtils

class SplashActivity : AppCompatActivity(), AnimationListener {
    lateinit var uvpcelogoanimation : AnimationDrawable
    lateinit var twinAnimation: Animation
    lateinit var img: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        img = findViewById<ImageView>(R.id.imageView)
        img.setBackgroundResource(R.drawable.logo_animation_list)
        uvpcelogoanimation = img.background as AnimationDrawable
        twinAnimation = AnimationUtils.loadAnimation(this, R.anim.twin_animation)
        twinAnimation.setAnimationListener(this)
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus){
            uvpcelogoanimation.start()
            img.startAnimation(twinAnimation)
        }
        else{
            uvpcelogoanimation.stop()
        }
    }
    override fun onAnimationStart(p0: Animation?) {

    }
    override fun onAnimationEnd(p0: Animation?) {
        Intent(this,MainActivity::class.java).also { startActivity(it) }
    }
    override fun onAnimationRepeat(p0: Animation?){

    }

}