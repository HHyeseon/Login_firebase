package net.skhu.signin;

<<<<<<< HEAD
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    static final int RC_SIGN_IN = 337;
    TextView textView;

=======
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button join;
    private Button login;
    private EditText email_login;
    private EditText pwd_login;
    FirebaseAuth firebaseAuth;
>>>>>>> SignInUpWithoutGoogle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        textView = (TextView) findViewById(R.id.textView);
        Button btnSignIn = findViewById(R.id.btn_signIn);
        Button btnSignOut = findViewById(R.id.btn_signOut);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startLoginInActivity();
            }
        });

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                setUserName();
            }
        });

        startLoginInActivity();
    }

    void startLoginInActivity() {
        // 이메일 인증과 구글 계정 인증을 사용하여 로그인 가능하도록 설정한다.
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build());
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);
    }

    void setUserName() {
        // 현재 사용자 객체를 구한다.
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) { // 로그인하지 않았다면, null 이다.
            String s = "Authentication success." + user.getDisplayName();
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
            textView.setText(s);
        } else {
            textView.setText("Anonymous");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // 로그인 작업이 성공인 경우
                setUserName();
            } else {
                // 로그인 작업이 실패한 경우
                String message = "Authentication failure. " + response.getError().getErrorCode()
                        + " " + response.getError().getMessage();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        }
=======
        login = (Button) findViewById(R.id.main_login_btn);
        email_login = (EditText) findViewById(R.id.main_email);
        pwd_login = (EditText) findViewById(R.id.main_pwd);

        firebaseAuth = firebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_login.getText().toString().trim();
                String pwd = pwd_login.getText().toString().trim();

                firebaseAuth.signInWithEmailAndPassword(email, pwd)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Login!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "Login error:(", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });
>>>>>>> SignInUpWithoutGoogle
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_signUp) {
            Intent intent = new Intent(this, signUpActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
