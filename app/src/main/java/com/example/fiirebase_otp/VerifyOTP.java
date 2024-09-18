package com.example.fiirebase_otp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fiirebase_otp.databinding.ActivityMainBinding;
import com.example.fiirebase_otp.databinding.ActivityVerifyOtpBinding;

public class VerifyOTP extends AppCompatActivity {
    ActivityVerifyOtpBinding verifyOtpBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        verifyOtpBinding= ActivityVerifyOtpBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(verifyOtpBinding.getRoot());


        setOTPInput();

    }

    private void setOTPInput() {
        verifyOtpBinding.input1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
              if (!charSequence.toString().trim().isEmpty()){
                  verifyOtpBinding.input1.requestFocus();
              }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        verifyOtpBinding.input2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
              if (!charSequence.toString().trim().isEmpty()){
                  verifyOtpBinding.input2.requestFocus();
              }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        verifyOtpBinding.input3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
             if (!charSequence.toString().trim().isEmpty()){
                 verifyOtpBinding.input3.requestFocus();
             }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        verifyOtpBinding.
    }


}