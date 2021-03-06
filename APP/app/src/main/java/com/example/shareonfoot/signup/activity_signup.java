package com.example.shareonfoot.signup;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.shareonfoot.R;
import com.google.android.material.textfield.TextInputLayout;

public class activity_signup extends AppCompatActivity {

    EditText et_userID, et_pwd, et_pwdConfirm;
    Button joinBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BtnOnClickListener onClickListener = new BtnOnClickListener() ;
        setContentView(R.layout.layout_signup);
        Button btnSignup = findViewById(R.id.bt_join);
        btnSignup.setOnClickListener(onClickListener);


        final TextInputLayout input_userID = (TextInputLayout) findViewById(R.id.input_ID);
        input_userID.setCounterEnabled(true);
        input_userID.setCounterMaxLength(45);
        input_userID.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                if (text.length() == 0) {
                    input_userID.setError("아이디를 입력해야 합니다.");
                    input_userID.setErrorEnabled(true);
                } else {
                    input_userID.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        final TextInputLayout input_pwd = (TextInputLayout) findViewById(R.id.input_pwd);
        input_pwd.setCounterEnabled(true);
        input_pwd.setCounterMaxLength(45);
        input_pwd.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                if (text.length() == 0) {
                    input_pwd.setError("비밀번호를 입력해야 합니다.");
                    input_pwd.setErrorEnabled(true);
                } else {
                    input_pwd.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        final TextInputLayout input_pwd_confirm = (TextInputLayout) findViewById(R.id.input_pwd_confirm);
        input_pwd_confirm.setCounterEnabled(true);
        input_pwd_confirm.setCounterMaxLength(45);
        input_pwd_confirm.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                if (text.length() == 0) {
                    input_pwd_confirm.setError("비밀번호를 다시 한 번 입력해주세요.");
                    input_pwd_confirm.setErrorEnabled(true);
                } else {
                    input_pwd_confirm.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        et_userID = (EditText) findViewById(R.id.et_ID);
        et_pwd = (EditText) findViewById(R.id.et_Password);
        et_pwdConfirm = (EditText) findViewById(R.id.et_ConfirmPassword);





        joinBtn = (Button) findViewById(R.id.bt_join);
    }











    class BtnOnClickListener implements Button.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.bt_join: // 회원가입 버튼 눌렀을 경우
                    String userID = et_userID.getText().toString();
                    String pwd = et_pwd.getText().toString();
                    String pwdConfirm = et_pwdConfirm.getText().toString();
                    SharedPreferences pref=getSharedPreferences("pref",0);

                    //임시

                    //return;




                    if (userID.length() == 0 || pwd.length() == 0){
                        Toast.makeText(activity_signup.this,"필요한 항목이 모두 입력되지 않았습니다.",Toast.LENGTH_SHORT).show();
                    } else if(!pwd.equals(pwdConfirm)){
                        Toast.makeText(activity_signup.this,"비밀번호가 서로 일치하지 않습니다.",Toast.LENGTH_SHORT).show();
                    }
                    else if(userID.equals(pref.getString(userID,""))){
                        Toast.makeText(activity_signup.this,"사용할 수 없는 아이디 입니다.",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Intent intent = new Intent(getApplicationContext(), activity_signup_next.class);
                        intent.putExtra("userID", userID);
                        intent.putExtra("userPW", pwd);
                        startActivity(intent);
                    }

            }
        }
    }




}
