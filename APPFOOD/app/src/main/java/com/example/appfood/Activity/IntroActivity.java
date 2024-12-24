package com.example.appfood.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appfood.R;
import com.example.appfood.databinding.ActivityIntroBinding;

public class IntroActivity extends BaseActivity {
    private ActivityIntroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Sử dụng View Binding để thiết lập giao diện
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Thiết lập màu sắc cho thanh trạng thái
        getWindow().setStatusBarColor(Color.parseColor("#FFE4B5"));

        // Thiết lập bố cục theo Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Khởi tạo các biến và sự kiện
        setVariable();
    }

    private void setVariable() {
        // Thiết lập sự kiện cho nút đăng nhập
        binding.loginBtn.setOnClickListener(view -> {
            if (mAuth.getCurrentUser() != null) {
                // Người dùng đã đăng nhập, chuyển đến MainActivity
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
            } else {
                // Người dùng chưa đăng nhập, chuyển đến LoginActivity
                startActivity(new Intent(IntroActivity.this, LoginActivity.class));
            }
        });

        // Thiết lập sự kiện cho nút đăng ký
        binding.signupBtn.setOnClickListener(view -> {
            startActivity(new Intent(IntroActivity.this, SignupActivity.class));
        });
    }
}
