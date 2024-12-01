package com.example.smartbill;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextElectricityUsed = findViewById(R.id.editTextElectricityUsed);
        EditText editTextRebate = findViewById(R.id.editTextRebate);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        TextView textViewResult = findViewById(R.id.textViewResult);
        Button aboutPageButton = findViewById(R.id.aboutPageButton);

        buttonCalculate.setOnClickListener(v -> {
            String unitsText = editTextElectricityUsed.getText().toString();
            String rebateText = editTextRebate.getText().toString();

            if (unitsText.isEmpty()) {
                editTextElectricityUsed.setError("Please enter units used");
                return;
            }
            if (rebateText.isEmpty()) {
                editTextRebate.setError("Please enter rebate");
                return;
            }

            int units = Integer.parseInt(unitsText);
            double rebate = Double.parseDouble(rebateText) / 100;
            double totalCharge = calculateBill(units);
            double finalCharge = totalCharge - (totalCharge * rebate);

            textViewResult.setText(String.format("Total Bill: RM %.2f", finalCharge));
        });

        aboutPageButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, About.class);
            startActivity(intent);
        });
    }

    private double calculateBill(int units) {
        if (units <= 200) {
            return units * 0.218;
        }
        else if (units <= 300) {
            return (200 * 0.218) + ((units - 200) * 0.334);
        }
        else if (units <= 600) {
            return (200 * 0.218) + (100 * 0.334) + ((units - 300) * 0.516);
        }
        else {
            return (200 * 0.218) + (100 * 0.334) + (300 * 0.516) + ((units - 600) * 0.546);
        }
    }


}
