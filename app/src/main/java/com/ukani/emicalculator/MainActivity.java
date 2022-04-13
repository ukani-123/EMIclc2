package com.ukani.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button msubmit,reset;
    EditText mcash,mvyaj,mvarsh;
    TextView mresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msubmit = findViewById(R.id.submit);
        reset = findViewById(R.id.reset);
        mcash = findViewById(R.id.cash);
        mvyaj = findViewById(R.id.vyaj);
        mresult = findViewById(R.id.result);
        mvarsh = findViewById(R.id.varsh);

        msubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               float p = Float.parseFloat(mcash.getText().toString());
               float r = Float.parseFloat(mvyaj.getText().toString());
               float n = Float.parseFloat(mvarsh.getText().toString());

                r = r/(12*100);

                float final_r = 1.0f;

                for (int i = 0; i < n*12; i++) {
                    final_r = final_r*(1+r);
                }

                float f_ans = p*r*(final_r/(final_r-1));

                mresult.setText("Your Payable Amount With Intrest : "+(f_ans+p)+"\n\n"+"Your Intrest is : "+f_ans);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mcash.setText("");
                mvyaj.setText("");
                mvarsh.setText("");
            }
        });
    }
}