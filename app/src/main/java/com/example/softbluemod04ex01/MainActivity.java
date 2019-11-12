package com.example.softbluemod04ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private Handler handler = new Handler();
    private int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txt_contador);
        button = findViewById(R.id.btn_iniciar);
    }

    public void processarContador(View view) {
        button.setEnabled(false);
        contador = 10;

        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.setText(String.valueOf(contador));
                contador--;

                if(contador >= 0) {
                    handler.postDelayed(this, 1000);
                } else {
                    button.setEnabled(true);
                }
            }
        });

    }
}
