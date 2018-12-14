package ru.geekbrains.android1.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Content();
    }

    private void Content()
    {
        final LinearLayout LL2 = (LinearLayout) findViewById(R.id.InnerRelativeLayout9);
        final LinearLayout LL3 = (LinearLayout) findViewById(R.id.InnerRelativeLayout7);
        final LinearLayout LL4 = (LinearLayout) findViewById(R.id.InnerRelativeLayout8);
        final TextView city = (TextView) findViewById(R.id.city1);
        Intent intent = getIntent();
        city.setText(intent.getStringExtra("City"));
        boolean b1 = intent.getBooleanExtra("chk1bx", false);
        if (b1 == true) {
            LL2.setVisibility(View.VISIBLE);
        }
        boolean b2 = intent.getBooleanExtra("chk2bx", false);
        if (b2 == true) {
            LL3.setVisibility(View.VISIBLE);
        }
        boolean b3 = intent.getBooleanExtra("chk3bx", false);
        if (b3 == true) {
            LL4.setVisibility(View.VISIBLE);
        }

        //кнопка НАЗАД
        Button btnBack = (Button) findViewById(R.id.back_button);
        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent firstAct = new Intent(getApplicationContext(), MainActivity.class);
                final String str2 = city.getText().toString();
                firstAct.putExtra("City2", str2);
                firstAct.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(firstAct);
            }
        });

    }
}
