package ru.geekbrains.android1.homework2.homework22;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;
import android.util.Log;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    // получаем экземпляр элемента ListView
    //ListView listView = (ListView)findViewById(R.id.listView);
    //String[] catNames = getResources().getStringArray(R.array.cat_names);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeInfo("onCreate");
        greeting_user();

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

    private void makeInfo(String text)
    {

        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
        //Выводим в logCat каждый LifeCycle
        Log.d(TAG,text);

    }

    private void greeting_user()
    {
        // Текущее время
        Date currentDate = new Date();
        // Форматирование времени как "часы:минуты:секунды"
        DateFormat timeFormat = new SimpleDateFormat("HH", Locale.getDefault());
        String timeText = timeFormat.format(currentDate);
        int i = Integer.parseInt(timeText);
        Toast.makeText(getApplicationContext(),timeText,Toast.LENGTH_SHORT).show();
        if (i>=05 && i<12)
        {
            Toast.makeText(getApplicationContext(),"Доброе утро",Toast.LENGTH_SHORT).show();
        }
        if (i>=12 && i<=15)
        {
            Toast.makeText(getApplicationContext(),"Добрый день",Toast.LENGTH_SHORT).show();
        }
        if (i>16 && i<=23)
        {
            Toast.makeText(getApplicationContext(),"Добрый вечер",Toast.LENGTH_SHORT).show();
        }
        if (i>=00 && i<=04)
        {
            Toast.makeText(getApplicationContext(),"Доброй ночи",Toast.LENGTH_SHORT).show();
        }
    }
}
