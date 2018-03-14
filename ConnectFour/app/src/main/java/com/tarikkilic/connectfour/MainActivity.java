package com.tarikkilic.connectfour;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText sizeInput;
    EditText timeInput;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox  = (CheckBox) findViewById(R.id.timeCheck);
        sizeInput = (EditText) findViewById(R.id.sizeText);
        timeInput = (EditText) findViewById(R.id.timeText);
        timeInput.setEnabled(false);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isChecked())
                    timeInput.setEnabled(true);
                else{
                    timeInput.setEnabled(false);
                    timeInput.setText("0");
                }
            }
        });
    }




    public void PVP(View view){
        if(Integer.parseInt(sizeInput.getText().toString()) < 5 || Integer.parseInt(sizeInput.getText().toString()) > 40){
            Toast.makeText(getApplicationContext(),"5-45 arasi olmali",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent =  new Intent(getApplicationContext(),Pvp.class);
            intent.putExtra("input",sizeInput.getText().toString());
            intent.putExtra("time",timeInput.getText().toString());
            startActivity(intent);
        }

    }

    public void PVC(View view){
        if(Integer.parseInt(sizeInput.getText().toString()) < 5 || Integer.parseInt(sizeInput.getText().toString()) > 40){
            Toast.makeText(getApplicationContext(),"5-45 arasi olmali",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent =  new Intent(getApplicationContext(),Pvc.class);
            intent.putExtra("input",sizeInput.getText().toString());
            intent.putExtra("time",timeInput.getText().toString());
            startActivity(intent);
        }
    }


}
