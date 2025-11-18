package com.example.nicestart;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        ImageView mSea = findViewById(R.id.Foto);
        Glide.with(this)
                .load(R.drawable.men)
                .transition(DrawableTransitionOptions.withCrossFade(100))
                     .circleCrop()
                .into(mSea);
    }
    }
