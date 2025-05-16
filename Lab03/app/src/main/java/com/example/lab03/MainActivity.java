package com.example.lab03;

import android.app.Activity; // Lưu ý: Nên dùng AppCompatActivity
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText; // Import EditText
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity; // Import AppCompatActivity
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Lưu ý: Nên kế thừa từ AppCompatActivity thay vì Activity
public class MainActivity extends Activity {
    EditText edt1, edt2, edt3; // Khai báo các EditText
    Button btncong, btntru, btnnhan, btnchia; // Khai báo các Button

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Toast.makeText(this, "CR424 - on Destroy()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        Toast.makeText(this, " CR424 - onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();
        Toast.makeText(this, " CR424 - onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Toast.makeText(this, " CR424 - onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        Toast.makeText(this, " CR424 - onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        Toast.makeText(this, " CR424 - onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Thiết lập layout activity_main

        Toast.makeText(this, "CR424 - onCreat()", Toast.LENGTH_SHORT).show();

        // Ánh xạ các View từ layout vào code Java
        edt1 = findViewById(R.id.edta);
        edt2 = findViewById(R.id.edtb);
        edt3 = findViewById(R.id.edtc);
        btncong = findViewById(R.id.btncong);
        btntru = findViewById(R.id.btntru);
        btnchia = findViewById(R.id.btnchia);
        btnnhan = findViewById(R.id.btnnhan);


        // Xử lý sự kiện click cho nút Cộng
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị từ EditText, chuyển sang số nguyên
                int a = Integer.parseInt("0" + edt1.getText().toString()); // Thêm toString()
                int b = Integer.parseInt("0" + edt2.getText().toString()); // Thêm toString()

                // Tính tổng và hiển thị kết quả
                edt3.setText("a+b=" + (a + b));
            }
        });

        // Xử lý sự kiện click cho nút Trừ
        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị từ EditText, chuyển sang số nguyên
                int a = Integer.parseInt("0" + edt1.getText().toString()); // Thêm toString()
                int b = Integer.parseInt("0" + edt2.getText().toString()); // Thêm toString()

                // Tính hiệu và hiển thị kết quả
                edt3.setText("a - b = " + (a - b));
            }
        });

        // Xử lý sự kiện click cho nút Nhân
        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị từ EditText, chuyển sang số nguyên
                int a = Integer.parseInt("0" + edt1.getText().toString()); // Thêm toString()
                int b = Integer.parseInt("0" + edt2.getText().toString()); // Thêm toString()

                // Tính tích và hiển thị kết quả
                edt3.setText("a*b=" + (a * b));
            }
        });

        // Xử lý sự kiện click cho nút Chia
        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị từ EditText, chuyển sang số nguyên
                int a = Integer.parseInt("0" + edt1.getText().toString()); // Thêm toString()
                int b = Integer.parseInt("0" + edt2.getText().toString()); // Thêm toString()

                // Kiểm tra chia cho 0
                if (b == 0) {
                    edt3.setText("B phai khac 0 ");
                } else {
                    // Tính thương và hiển thị kết quả
                    edt3.setText("a/b = " + ((double)a / b)); // Ép kiểu double để lấy kết quả thập phân
                }
            }
        });
    }
}
