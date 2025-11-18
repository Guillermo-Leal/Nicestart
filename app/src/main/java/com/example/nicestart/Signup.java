package com.example.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ImageView mSea = findViewById(R.id.backView);
        Glide.with(this)
                .load(R.drawable.hipman)
                .transition(DrawableTransitionOptions.withCrossFade(100))
                // .centerCrop()
                // .diskCacheStrategy(DiskCacheStrategy.ALL)
                // .placeholder(new ColorDrawable(this.getResources().getColor(R.color.Azul)))
//                      .circleCrop()
                .into(mSea);
    }
    public void openLogin(View v){
        Intent intent = new Intent(Signup.this, Login.class);
        startActivity(intent);
    }
    public void openMain(View v){
        Intent intent = new Intent(Signup.this, MainActivity.class);
        startActivity(intent);
    }
}
