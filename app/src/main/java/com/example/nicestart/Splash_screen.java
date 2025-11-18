package com.example.nicestart;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        //Objeto mSea con el identificador de la vista trasera de la pagina splash
        ImageView mSea = findViewById(R.id.backView);
        //Objeto thunder con el identificador del logo de la pagina splash
        ImageView thunder = findViewById(R.id.logosplash);
        //Objeto de la animacion
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.fadein);
        thunder.startAnimation(myanim);
        //imagen que se muestra en la parte de atras de la pantalla de splash
        Glide.with(this)
                .load(R.drawable.splashbackview)
                    .transition(DrawableTransitionOptions.withCrossFade(100))
                    .centerCrop()
                   // .diskCacheStrategy(DiskCacheStrategy.ALL)
                   // .placeholder(new ColorDrawable(this.getResources().getColor(R.color.Azul)))
//                      .circleCrop()
                .into(mSea);

    openApp();
    }

    private void openApp(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run(){
                Intent intent = new Intent( Splash_screen.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }, 5000);
    }
}