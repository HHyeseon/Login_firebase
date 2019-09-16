package net.skhu.signin;

<<<<<<< HEAD
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
=======
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
>>>>>>> SignInUpWithoutGoogle
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

<<<<<<< HEAD
public class signUpActivity extends AppCompatActivity {
=======
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signUpActivity extends AppCompatActivity {
    private EditText email_join;
    private EditText pwd_join;
    private Button btn;
    FirebaseAuth firebaseAuth;
>>>>>>> SignInUpWithoutGoogle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

<<<<<<< HEAD
        Button button = (Button) findViewById(R.id.button);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText_loginId = (EditText) findViewById(R.id.editText_loginId);
                String loginId = editText_loginId.getText().toString();
                if (isEmptyOrWhiteSpace(loginId))
                    editText_loginId.setError("로그인 아이디를 입력하세요");

                EditText editText_password = (EditText) findViewById(R.id.editText_password);
                String password = editText_password.getText().toString();
                if (isEmptyOrWhiteSpace(password))
                    editText_password.setError("비밀번호를 입력하세요");

            /*    EditText editText_password2 = (EditText) findViewById(R.id.editText_password2);
                String password2 = editText_password2.getText().toString();
                if (password.equals(password2) == false)
                    editText_password2.setError("비밀번호가 일치하지 않습니다");
*/
            /****************회원 가입 데이터를 서버에 전송하는 코드를 구현해야 함.********************/

            }
        };
        button.setOnClickListener(listener);
    }
    static boolean isEmptyOrWhiteSpace(String s) {
        if (s == null) return true;
        return s.trim().length() == 0;
=======
        email_join = (EditText) findViewById(R.id.main_email);
        pwd_join = (EditText) findViewById(R.id.main_pwd);
        btn = (Button) findViewById(R.id.button);

        firebaseAuth = FirebaseAuth.getInstance();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_join.getText().toString().trim();
                String pwd = pwd_join.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(email, pwd)
                        .addOnCompleteListener(signUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(signUpActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(signUpActivity.this, "Register error:(", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        });
            }
        });


>>>>>>> SignInUpWithoutGoogle
    }
}