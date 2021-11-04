package com.example.recteducation;

import static android.R.color.holo_red_dark;
import static android.R.color.holo_red_light;
import static com.example.recteducation.R.*;
import static java.lang.Math.*;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    // Вызывается при создании Активности
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Инициализирует Активность.
        setContentView(layout.activity_main);
    }

    public void setStatusBarColor(View statusBar,int color){
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        int actionBarHeight = getActionBarHeight();
        int statusBarHeight = getStatusBarHeight();
        statusBar.getLayoutParams().height = actionBarHeight + statusBarHeight;
        statusBar.setBackgroundColor(color);
    }
    public int getActionBarHeight() {
        int actionBarHeight = 0;
        TypedValue tv = new TypedValue();
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
        }
        return actionBarHeight;
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @SuppressLint("SetTextI18n")
    public void run(View view) {

        setStatusBarColor(findViewById(id.res),getResources().getColor(android.R.color.white));

        TextView result = findViewById(id.res);
        try {
            double a = Double.parseDouble(((EditText)
                    findViewById(id.a)).getText().toString());
            double b = Double.parseDouble(((EditText)
                    findViewById(id.b)).getText().toString());
            double c = Double.parseDouble(((EditText)
                    findViewById(id.c)).getText().toString());

            double x1, x2;
            if (a == 0) {
                x1 = -c / b;
                result.setText("x = " + x1);
            }
            else if (c == 0) {
                x1 = 0;
                x2 = -b / a;
                result.setText(String.format(Locale.US,"x1 =  %f\n\nx2 = %f", x1, x2));
            }
            else if (b == 0) {
                if ((-c / a) > 0) {
                    x1 = sqrt(-c / a);
                    x2 = (-1) * (sqrt(-c / a));
                    result.setText(String.format(Locale.US, "x1 =  %f\n\nx2 = %f", x1, x2));
                }
                else if ((-c / a) < 0) {
                    result.setText("Уравнение имеет 2 комплексных корня");
                }
            }
            else if (a == 0 && c == 0) {
                x1 = 0;
                result.setText("x = " + x1);
            }
            else if (a == 0 && b == 0) {
                result.setText("Нет решений");
            }
            else if (a == 0 && b == 0 && c == 0) {
                result.setText("Нет решений");
            }
            else if (b == 0 && c == 0) {
                x1 = 0;
                result.setText("x = " + x1);
            }
            else if (a != 0 && b != 0 && c != 0) {
                double D = (b * b) - (4 * a * c);

                if (D == 0) {
                    x1 = -b / (2 * a);
                    result.setText("x = " + x1);
                } else if (D > 0) {
                    x1 = (-b + (double) sqrt(D)) / (2 * a);
                    x2 = (-b - (double) sqrt(D)) / (2 * a);
                    result.setText(String.format(Locale.US, "x1 =  %f\n\nx2 = %f", x1, x2));
                } else if (D < 0) {
                    result.setText("Уравнение имеет 2 комплексных корня");
                }
            }
        }
        catch (NumberFormatException e) {
            setStatusBarColor(findViewById(id.res),getResources().getColor(holo_red_light));
            result.setText("Введите число!");
        }
    }

}