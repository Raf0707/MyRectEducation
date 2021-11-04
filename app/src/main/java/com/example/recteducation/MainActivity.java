package com.example.recteducation;

import static java.lang.Math.*;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
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
        setContentView(R.layout.activity_main);
    }

    /**
     * Вызывается при нажатии пользователем на кнопку Решить
     */
    @SuppressLint("SetTextI18n")
    public void run(View view) {
        TextView result = findViewById(R.id.res);
        try {
            double a = Double.parseDouble(((EditText)
                    findViewById(R.id.a)).getText().toString());
            double b = Double.parseDouble(((EditText)
                    findViewById(R.id.b)).getText().toString());
            double c = Double.parseDouble(((EditText)
                    findViewById(R.id.c)).getText().toString());

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
        } catch (NumberFormatException e) {
            result.setText("Введите число!");
        }
    }
}