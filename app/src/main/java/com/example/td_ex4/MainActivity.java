package com.example.td_ex4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText text1 = findViewById(R.id.text1);
        EditText text2 = findViewById(R.id.text2);
        CheckBox check =findViewById(R.id.check);
        Button btnConcat = findViewById(R.id.btnConcat);
        TextView Result = findViewById(R.id.Result);
        btnConcat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt1;
                String txt2;
                String Rslt;
                Toast t;
                txt1= text1.getText().toString().trim();
                txt2= text2.getText().toString().trim();
                if(txt1.isEmpty() || txt2.isEmpty()){
                    t= Toast.makeText(view.getContext(),"Les champs sont vides !!",Toast.LENGTH_SHORT);
                    t.show();
                    Result.setText("");
                }
                else {
                    if(check.isChecked()){
                        Rslt=txt1+" "+txt2;
                    }
                    else {
                        Rslt=txt1+txt2;
                    }
                    Result.setText(Rslt);
                    text1.setText("");
                    text2.setText("");
                }



            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}