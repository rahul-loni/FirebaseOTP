package com.example.fiirebase_otp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fiirebase_otp.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        firebaseAuth=FirebaseAuth.getInstance();

        binding.sendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(binding.enterPhoneNumber.getText().toString().trim().isEmpty()){
                  Toast.makeText(MainActivity.this, "Enter Mobile No. First ", Toast.LENGTH_SHORT).show();
                  return;
              }
                Intent intent=new Intent(getApplicationContext(), VerifyOTP.class);
              intent.putExtra("mobile",binding.enterPhoneNumber.getText().toString());
              startActivity(intent);
            }
        });

    }
}