package com.fju.water3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView edmonth;
    private TextView ednext;
    float money;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edmonth = findViewById(R.id.month);
        ednext = findViewById(R.id.next);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void reset() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void button(View view) {
        if (!TextUtils.isEmpty(edmonth.getText().toString())) {
            float m = Float.parseFloat(edmonth.getText().toString());
            if (m >= 0 && 10 >= m) {
                money = (float) ((m*7.35));
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用:" + money)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                reset();
                            }
                        })
                        .show();
            } else if (m >= 11 && 30 >= m) {
                money = (float)((m*9.45)-21);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用:" + money)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                reset();
                            }
                        })
                        .show();
            } else if (m >= 31 && 50 >= m) {
                money = (float)((m*11.55)-84);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用:" + money)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                reset();
                            }
                        })
                        .show();
            } else if (m >= 51) {
                money = (float)((m*12.075)-110.25);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用:" + money)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                reset();
                            }
                        })
                        .show();
            }
        }
        if (!TextUtils.isEmpty(ednext.getText().toString())) {
            float n = Float.parseFloat(ednext.getText().toString());
            if (n >= 0 && 10 >= n) {
                money = (float) ((n*7.35));
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用:" + money)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                reset();
                            }
                        })
                        .show();
            } else if (n >= 11 && 30 >= n) {
                money = (float)((n*9.45)-42);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用:" + money)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                reset();
                            }
                        })
                        .show();
            } else if (n >= 31 && 50 >= n) {
                money = (float)((n*11.55)-168);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用:" + money)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                reset();
                            }
                        })
                        .show();
            } else if (n >= 51) {
                money = (float)((n*12.075)-220.5);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用:" + money)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                reset();
                            }
                        })
                        .show();
            }
        }
         if (edmonth.length() == 0 && ednext.length() == 0) {
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
