package com.example.nicestart;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeLayout;
    private WebView nuestroVisorWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nuestroVisorWeb = (WebView) findViewById(R.id.wV);

        String html = "<html>"+
                "<head><style>"+
                "html, body{margin:0; padding:0; Height:100%; overflow:hidden}"+
                "img{ width:100%; height:100%; object-fit:cover;}"+
                "</style></head/>"+
                "<body>"+
                "<img src = 'https://thispersondoesnotexist.com'/>"+
                "</body></html>";

        nuestroVisorWeb.loadDataWithBaseURL(null,html,"text/html","UTF-8",null);


        WebView mycontext = findViewById(R.id.wV);
        registerForContextMenu(mycontext);

        swipeLayout = findViewById(R.id.swipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);
    }

    public void showAlertDialogButtonClicked(MainActivity mainActivity) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

//        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
        builder.setTitle("¿Quieres salir de la aplicacion?");
        builder.setMessage("Si lo haces me pondre troste");
        builder.setIcon(R.drawable.usericon);
        builder.setCancelable(true);

        builder.setNegativeButton("No quiero", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setNeutralButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    //implementar menu contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
//        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)
//                item.getMenuInfo();
        if (item.getItemId() == R.id.item1) {
            Toast toast = Toast.makeText(this, "Item copied",
                    Toast.LENGTH_LONG);
            toast.show();
        } else if (item.getItemId() == R.id.item2) {
            Toast toast2 = Toast.makeText(this, "Downloading item...",
                    Toast.LENGTH_LONG);
            toast2.show();
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
           if(id==R.id.Settings){
            Toast toast = Toast.makeText(this, "Infecting", Toast.LENGTH_LONG);
            toast.show();
        }
        if (id == R.id.LogOut) {
            showAlertDialogButtonClicked(MainActivity.this);
        }
        return super.onOptionsItemSelected(item);
    }
    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast0 = Toast.makeText(MainActivity.this, "Hi there! I don't exist :)", Toast.LENGTH_LONG);
           toast0.show();
           swipeLayout.setRefreshing(false);

           nuestroVisorWeb.reload();
           swipeLayout.setRefreshing(false);
        }
    };

}