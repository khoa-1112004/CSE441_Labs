package com.example.lab05; // Đảm bảo package name đúng

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView; // Import TextView
import android.widget.Toast; // Import Toast
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Khai báo các View
    EditText editnamduonglich;
    Button button1;
    TextView textViewNamAmLich; // TextView để hiển thị năm âm lịch

    // Mảng Can và Chi
    final String[] arrCan = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
    final String[] arrChi = {"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Thiết lập layout activity_main

        // Ánh xạ các View từ layout vào code Java
        editnamduonglich = findViewById(R.id.editnamduonglich);
        button1 = findViewById(R.id.button1);
        textViewNamAmLich = findViewById(R.id.textViewNamAmLich); // Ánh xạ TextView hiển thị kết quả

        // Thiết lập lắng nghe sự kiện click cho nút Chuyển đổi
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị từ EditText năm dương lịch
                String namDuongLichStr = editnamduonglich.getText().toString();

                // Kiểm tra nếu EditText không rỗng
                if (namDuongLichStr.isEmpty()) {
                    editnamduonglich.setError("Vui lòng nhập năm dương lịch");
                    textViewNamAmLich.setText(""); // Xóa kết quả cũ
                    return; // Dừng xử lý
                } else {
                    editnamduonglich.setError(null); // Xóa lỗi nếu có
                }

                try {
                    // Chuyển đổi chuỗi sang số nguyên
                    int namDuongLich = Integer.parseInt(namDuongLichStr);

                    // Tính Can và Chi
                    String can = arrCan[namDuongLich % 10];
                    String chi = arrChi[namDuongLich % 12];

                    // Ghép Can và Chi để được năm Âm lịch
                    String namAmLich = can + " " + chi;

                    // Hiển thị kết quả lên TextView
                    textViewNamAmLich.setText(namAmLich);

                } catch (NumberFormatException e) {
                    // Xử lý lỗi nếu người dùng nhập không phải số nguyên
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số nguyên cho năm", Toast.LENGTH_SHORT).show();
                    textViewNamAmLich.setText(""); // Xóa kết quả cũ
                }
            }
        });
    }
}
