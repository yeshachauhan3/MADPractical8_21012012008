package com.example.madpractical8_21012012008

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivity : AppCompatActivity() ,Animation.AnimationListener{
    lateinit var logo_img:ImageView
    lateinit var logoframbyframanimation:AnimationDrawable
    lateinit var twinanimation:Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        logo_img=findViewById(R.id.image)
        logo_img.setBackgroundResource(R.drawable.uvpce_list)
        logoframbyframanimation=logo_img.background as AnimationDrawable
        twinanimation=AnimationUtils.loadAnimation(this,R.anim.twin_animation)
        twinanimation.setAnimationListener(this)

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus){
            logoframbyframanimation.start()
            logo_img.startAnimation(twinanimation)
        }
        else{
            logoframbyframanimation.stop()
        }
    }

    override fun onAnimationStart(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {

        intent=Intent(this,MainActivity::class.java).apply {
            overridePendingTransition(R.anim.scale_in,R.anim.scale_out)
            startActivity(this) }
    }

    override fun onAnimationRepeat(p0: Animation?) {

    }

}