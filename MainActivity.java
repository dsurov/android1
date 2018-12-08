package ru.geekbrains.android1.homework2.homework22;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeInfo("onCreate");
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
}
