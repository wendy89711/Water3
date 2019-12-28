package com.fju.water3;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView edmonth;
    private TextView ednext;
    public float money = 0;
    boolean isNext = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate");
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edmonth = findViewById(R.id.month);
//        ednext = findViewById(R.id.next);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button();
            }
        });
        Switch sw = findViewById(R.id.sw1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;
                TextView text = findViewById(R.id.sw1);
                text.setText(isNext ? getText(R.string.every_other_month): getText(R.string.monthly));
                TextView text1 = findViewById(R.id.monthQ);
                text1.setText(isNext ? getText(R.string.every_other_month): getText(R.string.monthly));
            }
        });
        Spinner cities = findViewById(R.id.spinner);
        cities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, getResources().getStringArray(R.array.cities)[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void reset() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }

    public void button() {
        if (!TextUtils.isEmpty(edmonth.getText().toString()) && isNext == false) {
            float m = Float.parseFloat(edmonth.getText().toString());
            if (m >= 1 && 10 >= m) {
                money = (float) ((m*7.35));
            } else if (m >= 11 && 30 >= m) {
                money = (float)((m*9.45)-21);
            } else if (m >= 31 && 50 >= m) {
                money = (float)((m*11.55)-84);
            } else if (m >= 51) {
                money = (float)((m*12.075)-110.25);
            }
            Intent intent = new Intent(this,ResultActivity.class);//在匿名類別裡面須加類別名稱
            intent.putExtra(getString(R.string.extra_money),money);
            startActivity(intent);
//            new AlertDialog.Builder(MainActivity.this)
//                    .setTitle("每月抄表費用")
//                    .setMessage("費用:" + money)
//                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            reset();
//                        }
//                    })
//                    .show();
        }
        if (!TextUtils.isEmpty(edmonth.getText().toString()) && isNext == true) {
            float n = Float.parseFloat(edmonth.getText().toString());
            if (n >= 1 && 20 >= n) {
                money = (float) ((n*7.35));
            } else if (n >= 21 && 60 >= n) {
                money = (float)((n*9.45)-42);
            } else if (n >= 61 && 100 >= n) {
                money = (float)((n*11.55)-168);
            } else if (n >= 101) {
                money = (n*12.075f)-220.5f;
            }
            Intent intent = new Intent(this,ResultActivity.class);
            intent.putExtra("MONEY", money);
            startActivity(intent);
//            new AlertDialog.Builder(MainActivity.this)
//                    .setTitle("每月抄表費用")
//                    .setMessage("費用:" + money)
//                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            reset();
//                        }
//                    })
//                    .show();
        }
        if (edmonth.length() == 0) {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("錯誤")
                    .setMessage("無法計算")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
