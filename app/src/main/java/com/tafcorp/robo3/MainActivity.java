package com.tafcorp.robo3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView resp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button)this.findViewById(R.id.btnPerguntar);
        b.setOnClickListener(this::onClick);
    }

    public void escreverTexto(String str){
        resp.setText(str);
    }

    private void onClick(View v) {
        resp = findViewById(R.id.lblResposta);
        EditText txtPergunta = findViewById(R.id.txtPergunta);
        ValidaPergunta validaPergunta = new ValidaPergunta();
        try {
            validaPergunta.validar(txtPergunta.getText().toString(), this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}