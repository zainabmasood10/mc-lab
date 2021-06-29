package com.example.finalexam191184;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.zainab_191184.R;
import com.example.zainab_191184.LoginActivity;
public class LoginActivity extends AppCompatActivity {
    Button SignUp,SignIn;
    EditText edt1,edt2;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SignIn = findViewById(R.id.btnSignIn);
        SignUp = findViewById(R.id.btnSignUp);
        edt1 = findViewById(R.id.SI_edt_email);
        edt2 = findViewById(R.id.SI_edt_pass);


        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAccount();
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, Signup.class);
                startActivity(i);
            }
        });

    }

    void loginAccount ()
    {
        String Email;
        String password;
        Email = edt1.getText().toString().trim();
        password = edt2.getText().toString();
        mAuth.signInWithEmailAndPassword(Email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignIn.this, MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}