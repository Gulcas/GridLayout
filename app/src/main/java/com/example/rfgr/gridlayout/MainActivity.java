package com.example.rfgr.gridlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private String messageText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Po kliknięciu przycisku zostanie wywołana i wykonana poniższa metoda. Ma ona za zadanie odebrać wartość wpisaną w polu editText i umieścić ją w innym polu textView
     */
    public void sendButton(View view) {
        TextView textVi = (TextView) findViewById(R.id.messageWindow);
        textVi.setText(messageText);

        Spinner spinnerName = (Spinner) findViewById(R.id.spiner); //odnajduję spinner
        String string = String.valueOf(spinnerName.getSelectedItem()); //konwertuję wybrany spiner do string'a
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show(); //tworzony jest toast którego treścią będzie opcja wybrana w spinnerze
        //a w związku z tym że spiner i toast są częścią klasy sendButton to ten kod zostaje wykonany dopiero po wciśnięciu guzika send
    }

    public void toggleButton(View view) {
        boolean on = ((ToggleButton) view).isChecked();
        if (on) {
            messageText = "Przełącznik jest włączony";

        } else {
            EditText messageView = (EditText) findViewById(R.id.adressName);
            String messageText = messageView.getText().toString();

            TextView textVi = (TextView) findViewById(R.id.messageWindow);
            textVi.setText(messageText);
        }
/**
 *Poniższy kod sprawdza czy checkBox jest zaznaczony w głównej aktywności, i jeżeli jest zaznaczony to wyświetli krótki komunikat
 * ale w związku z tym że jest częścią klasy toggleButton to sprawdzenie odbywa się tylko i wyłacznie gdy toggleButton jest właczony*/
        CheckBox checkBoxName = (CheckBox) findViewById(R.id.checkBox);
        boolean checkBoxBoolean = checkBoxName.isChecked();
        if (checkBoxBoolean) {
            Toast toastMessage = Toast.makeText(this, "CheckBox jest zaznaczony", Toast.LENGTH_SHORT);
            toastMessage.show();
        }

    }

    //teraz wywołamy metodę onClick na checkBox'ie
    public void checkBoxOnClick(View view) {
        boolean checkBoxChecked = ((CheckBox) view).isChecked(); //najpierw sprawdzamy czy checkBox jest zaznaczony

        switch (view.getId()) { //wykorzystuję metodę swich by np, określić który guzik został kliknięty
            case R.id.checkBox: // przypadek pierwszy dotyczy checkBox'a o takim właśnie imieniu
                if (checkBoxChecked) //jeżeli jest zaznaczony to walnie na ekran toast
                    Toast.makeText(this, "CheckBox wywołał metodę on click", Toast.LENGTH_SHORT).show();
                else //jeżeli natomiast nie jest zaznaczony to niczym nie walnie i nic się nie stanie
                    break;
                //w tym miejscu można dodać inny case dla np: drugiego guzika
                //warto też nadmienić iż w powyższym kodzie znajdują sie dwie metody sprawdzające status tego samego checkBox'a
                // pierwsza metoda sprawdza status checkBox'a dopiero gdy toggleButton jest włączony, a druga jest niezależna i to właśnie ona zostanie wykonana niezależnie od wciśniętego toggleButton'a

        }
    }

    /**
     * Teraz logika obsługi radiobutton'ów
     */
    public void guzikClick(View view) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGrupa); //najpierw poszukuję odwłoania do grupy radioGroup
        int id = radioGroup.getCheckedRadioButtonId(); //sprawdzam który z radioButton'ów jest zaznaczony
        switch (id) { //wykorzystuję swich by wykonać odpowiednią komendę w zależości od wybranego guzika radioButton'a
            case R.id.guzik_1_name:
                Toast.makeText(this, "guzik pierwszy", Toast.LENGTH_SHORT).show();
                break;
            case R.id.guzik_2_name:
                Toast.makeText(this, "guzik druki", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
