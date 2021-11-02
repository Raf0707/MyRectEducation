package com.example.recteducation;

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
    public void run(View view) {

        double a = Double.parseDouble(((EditText)
                findViewById(R.id.a)).getText().toString());
        double b = Double.parseDouble(((EditText)
                findViewById(R.id.b)).getText().toString());
        double c = Double.parseDouble(((EditText)
                findViewById(R.id.c)).getText().toString());
        TextView result = findViewById(R.id.res);
        double D = b * b - 4 * a * c;
        double x1, x2;
        if (D == 0){
            x1 = -b / (2 * a);
            result.setText("x = " + x1);
        }
        else if (D > 0){
            x1 = (-b + Math.sqrt(D))/2*a;
            x2 = (-b - Math.sqrt(D))/2*a;
            result.setText(String.format(Locale.US,"x1 =  %f\n\nx2 = %f", x1, x2));
        }

        else if (D < 0){
            result.setText("Уравнение имеет 2 комплексных корня");
        }
    }
}