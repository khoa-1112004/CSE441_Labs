package com.example.lab041; // Đảm bảo package name đúng

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText txtFar, txtCel;
    Button btnFarToCel, btnCelToFar, btnClearTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFar = findViewById(R.id.txtFar);
        txtCel = findViewById(R.id.txtCel);
        btnFarToCel = findViewById(R.id.btnFarToCel);
        btnCelToFar = findViewById(R.id.btnCelToFar);
        btnClearTemp = findViewById(R.id.btnClearTemp);

        DecimalFormat dcf = new DecimalFormat("#.00");

        btnFarToCel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String doF = txtFar.getText().toString();

                if (!doF.isEmpty()) {
                    try {
                        double F = Double.parseDouble(doF);
                        double C = (F - 32) / 1.8;
                        txtCel.setText(dcf.format(C));
                        txtFar.setError(null);
                    } catch (NumberFormatException e) {
                        txtFar.setError("Nhập số hợp lệ");
                        txtCel.setText("");
                    }
                } else {
                    txtCel.setText("");
                    txtFar.setError("Không được để trống");
                }
            }
        });

        btnCelToFar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String doC = txtCel.getText().toString();

                if (!doC.isEmpty()) {
                    try {
                        double C = Double.parseDouble(doC);
                        double F = C * 1.8 + 32;
                        txtFar.setText(dcf.format(F));
                        txtCel.setError(null);
                    } catch (NumberFormatException e) {
                        txtCel.setError("Nhập số hợp lệ");
                        txtFar.setText("");
                    }
                } else {
                    txtFar.setText("");
                    txtCel.setError("Không được để trống");
                }
            }
        });

        btnClearTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtFar.setText("");
                txtCel.setText("");
                txtFar.setError(null);
                txtCel.setError(null);
            }
        });
    }
}
