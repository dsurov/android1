package ru.geekbrains.android1.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    protected String[] citys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeInfo("onCreate");
        Content();
    }

    @Override
    protected void onStart() {
        super.onStart();
        makeInfo("OnStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        makeInfo("OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        makeInfo("OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        makeInfo("OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        makeInfo("onDestroy");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        makeInfo("onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        makeInfo("onSaveInstanceState");
    }

    private void makeInfo(String text) {

        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        //Выводим в logCat каждый LifeCycle
        Log.d(TAG, text);
    }

    private void Content()

    {
        final TextView greeting1 = (TextView) findViewById(R.id.greeting);
        final ListView Lview1 = (ListView) findViewById(R.id.lview);
        final FrameLayout FRM = (FrameLayout) findViewById(R.id.FRM1);
        citys = getResources().getStringArray(R.array.city_list);
        final LinearLayout LL1 = (LinearLayout) findViewById(R.id.InnerRelativeLayout);
        final TextView LsT = (TextView) findViewById(R.id.list_city_text);
        final TextView list_city_text = (TextView) findViewById(R.id.list_city_text);
        final Button change_city_button2 = (Button) findViewById(R.id.change_city_button1);
        final Button exit_button1 = (Button) findViewById(R.id.exit_button);
        final Button OkBtn = (Button) findViewById(R.id.ok_button);
        final Button chkBx1 = (CheckBox) findViewById(R.id.checkBoxBold1);
        final Button chkBx2 = (CheckBox) findViewById(R.id.checkBoxBold2);
        final Button chkBx3 = (CheckBox) findViewById(R.id.checkBoxBold3);

        greeting1.setText(greeting_user());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, citys);
        Lview1.setAdapter(adapter);
        Lview1.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int pos, long id
            ) {

                list_city_text.setText(citys[pos]);
                Lview1.setVisibility(View.GONE);
                FRM.setVisibility(View.GONE);
                LL1.setVisibility(View.VISIBLE);
            }

        });

        //кнопка ВЫХОД
        exit_button1.setOnClickListener(new View.OnClickListener() { // Обработк нажатий
            @Override
            public void onClick(View v) {
                makeInfo("exit_button");
                android.os.Process.killProcess(android.os.Process.myPid());
            }

        });

        //кнопка выбора города
        change_city_button2.setOnClickListener(new View.OnClickListener() { // Обработк нажатий
            @Override
            public void onClick(View v) {
                makeInfo("Button Click");
                LL1.setVisibility(View.GONE);
                Lview1.setVisibility(View.VISIBLE);
                FRM.setVisibility(View.VISIBLE);
            }

        });

        //кнопка ОК
        OkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secAct2 = new Intent(getApplicationContext(),
                        Activity2.class);
                final boolean chk1 = ((CheckBox) chkBx1).isChecked();
                final boolean chk2 = ((CheckBox) chkBx2).isChecked();
                final boolean chk3 = ((CheckBox) chkBx3).isChecked();
                final String str2 = LsT.getText().toString();
                secAct2.putExtra("City", str2);
                secAct2.putExtra("chk1bx", chk1);
                secAct2.putExtra("chk2bx", chk2);
                secAct2.putExtra("chk3bx", chk3);
                startActivity(secAct2);
            }
        });

        Intent intent2 = getIntent();
        if (intent2.getStringExtra("City2") != null) {
            LsT.setText(intent2.getStringExtra("City2"));
        }
    }

    private String greeting_user() {
        String usr_greeting = getString(R.string.greeting6);
        // Текущее время
        Date currentDate = new Date();
        // Форматирование времени как "часы"
        DateFormat timeFormat = new SimpleDateFormat("HH", Locale.getDefault());
        String timeText = timeFormat.format(currentDate);
        int i = Integer.parseInt(timeText);
        if (i >= 05 && i < 12) {
            usr_greeting = getString(R.string.greeting1);
        }
        if (i >= 12 && i <= 15) {
            usr_greeting = getString(R.string.greeting2);
        }
        if (i > 15 && i <= 23) {
            usr_greeting = getString(R.string.greeting3);
        }
        if (i >= 00 && i <= 04) {
            usr_greeting = getString(R.string.greeting5);
        }
        return usr_greeting;
    }


}