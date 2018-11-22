package com.srv.spinninglogo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    List<String> quotesList;
    ProgressBar progressBar;
    int i = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quotesList = new ArrayList<>();

        quotesList.add("Hi");
        quotesList.add("Happy New Year");
        quotesList.add("Hope you have a good day");
        quotesList.add("Merry Christmas");

        Button btnTap = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

        btnTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                textView.setVisibility(View.GONE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (i == quotesList.size())
                            i = 0;
                        textView.setVisibility(View.VISIBLE);
                        textView.setText(quotesList.get(i++));
                        progressBar.setVisibility(View.GONE);

                    }
                }, 3000);
            }
        });

    }


}
