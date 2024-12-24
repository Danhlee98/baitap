package com.example.appfood.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appfood.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class BaseActivity extends AppCompatActivity {
    protected FirebaseAuth mAuth;
    protected FirebaseDatabase database;
    public static final String TAG = "uilover";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base); // Đảm bảo có một file layout cho activity này

        // Khởi tạo Firebase Auth và Database
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        // Tuỳ chọn: Khởi tạo các thành phần giao diện người dùng khác hoặc các cài đặt tại đây

        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
    }

    // Tuỳ chọn: Thêm các phương thức để xử lý các chức năng chung cho tất cả các activity
}
