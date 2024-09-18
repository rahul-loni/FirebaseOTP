package com.example.fiirebase_otp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fiirebase_otp.databinding.ActivityMainBinding;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

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
//        final ProgressBar progressBar=findViewById(R.id.progressBar);


        binding.sendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(binding.enterPhoneNumber.getText().toString().trim().isEmpty()){
                  Toast.makeText(MainActivity.this, "Enter Mobile No. First ", Toast.LENGTH_SHORT).show();
                  return;
              }
              binding.progressBar.setVisibility(View.VISIBLE);
              binding.sendOTP.setVisibility(View.GONE);

              PhoneAuthProvider.getInstance().verifyPhoneNumber(
                      "+977"+binding.enterPhoneNumber.getText().toString(),
                      60,
                      TimeUnit.SECONDS,
                      MainActivity.this,
                      new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
                          @Override
                          public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                          }

                          @Override
                          public void onVerificationFailed(@NonNull FirebaseException e) {

                          }

                          @Override
                          public void onCodeAutoRetrievalTimeOut(@NonNull String s) {
                              super.onCodeAutoRetrievalTimeOut(s);
                          }
                      }
              );

              Intent intent=new Intent(getApplicationContext(), VerifyOTP.class);
              intent.putExtra("mobile",binding.enterPhoneNumber.getText().toString());
              startActivity(intent);
            }
        });

    }
}