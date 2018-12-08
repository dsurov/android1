package ru.geekbrains.android1.homework2.homework22;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeToast("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        makeToast("OnStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        makeToast("OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        makeToast("OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        makeToast("OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        makeToast("onDestroy");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        makeToast("onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        makeToast("onSaveInstanceState");
    }

    private void makeToast(String text)
    {
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
        Log.d(TAG,"text");

    }
}
