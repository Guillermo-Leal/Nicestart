package com.example.nicestart;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
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
        ImageView mSea = findViewById(R.id.backView);

        Glide.with(this)
                .load(R.drawable.girl)
                    .transition(DrawableTransitionOptions.withCrossFade(100))
                   // .centerCrop()
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