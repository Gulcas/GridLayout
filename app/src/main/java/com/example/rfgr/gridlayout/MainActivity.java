package com.example.rfgr.gridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**Po kliknięciu przycisku zostanie wywołana i wykonana poniższa metoda. Ma ona za zadanie odebrać wartość wpisaną w polu editText i umieścić ją w innym polu textView*/
    public void sendButton (View view) {
        EditText messageView = (EditText) findViewById(R.id.adressName);
        String messageText = messageView.getText().toString();

        TextView textVi = (TextView) findViewById(R.id.messageWindow);
        textVi.setText(messageText);
    }
}
