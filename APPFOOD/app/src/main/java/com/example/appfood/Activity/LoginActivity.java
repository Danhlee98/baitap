package com.example.appfood.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appfood.R;
import com.example.appfood.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Thiết lập bố cục theo Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Sử dụng View Binding để thiết lập giao diện
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Khởi tạo các biến và sự kiện
        setVariable();
    }

    private void setVariable() {
        // Thiết lập sự kiện cho nút đăng nhập
        binding.loginBtn.setOnClickListener(view -> {
            String email = binding.userEdt.getText().toString().trim();
            String password = binding.passEdt.getText().toString().trim();

            if (!email.isEmpty() && !password.isEmpty()) {
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, task -> {
                            if (task.isSuccessful()) {
                                // Chuyển đến MainActivity khi đăng nhập thành công
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                finish(); // Kết thúc LoginActivity để người dùng không thể quay lại
                            } else {
                                // Hiển thị thông báo khi đăng nhập thất bại
                                Toast.makeText(LoginActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                            }
                        });
            } else {
                // Hiển thị thông báo khi email hoặc mật khẩu trống
                Toast.makeText(LoginActivity.this, "Please fill in both email and password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
