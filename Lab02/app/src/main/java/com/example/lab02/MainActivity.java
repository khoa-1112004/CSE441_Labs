package com.example.lab02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast; // Import Toast
import android.widget.TextView; // Import TextView

import androidx.appcompat.app.AppCompatActivity; // Kế thừa từ AppCompatActivity

// Khai báo lớp MainActivity kế thừa từ AppCompatActivity
public class MainActivity extends AppCompatActivity {

    // Khai báo biến cho Button và TextView
    Button btncall; // Sử dụng ID btncall như trong layout
    TextView textView; // Khai báo TextView

    // Phương thức onCreate() được gọi khi Activity được tạo lần đầu
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Thiết lập layout cho Activity này từ file activity_main.xml
        setContentView(R.layout.activity_main); // Sử dụng layout activity_main

        // Hiển thị Toast khi onCreate được gọi (để theo dõi vòng đời)
        Toast.makeText(this, "MainActivity: onCreate()", Toast.LENGTH_SHORT).show();

        // Tìm Button và TextView trong layout bằng ID và gán vào biến
        btncall = findViewById(R.id.btncall); // ID phải khớp với activity_main.xml
        textView = findViewById(R.id.textView); // ID phải khớp với activity_main.xml

        // Thiết lập lắng nghe sự kiện click cho nút btncall
        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để mở Subactivity
                // Đảm bảo tên class là Subactivity.class (chữ S viết hoa)
                Intent intent1 = new Intent(MainActivity.this, Subactivity.class);
                startActivity(intent1); // Bắt đầu Subactivity
            }
        });
    }

    // Ghi đè các phương thức vòng đời để theo dõi bằng Toast
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "MainActivity: onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "MainActivity: onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "MainActivity: onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "MainActivity: onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "MainActivity: onDestroy()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "MainActivity: onRestart()", Toast.LENGTH_SHORT).show();
    }
}
