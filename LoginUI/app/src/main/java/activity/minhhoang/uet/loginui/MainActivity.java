package activity.minhhoang.uet.loginui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtPassword;
    EditText edtUser;
    Button btnLogin;
    ImageButton btnDeleteUser;
    ImageButton btnDeletePass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        addControl();
        getEvent();


    }

    private void addControl() {

        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtUser = (EditText) findViewById(R.id.edtUser);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnDeletePass = (ImageButton) findViewById(R.id.btnDeletePass);
        btnDeleteUser = (ImageButton) findViewById(R.id.btnDeleteUser);


    }
    private void getEvent(){
//        edtUser.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if(edtUser.getText().length()<8)
//                    edtUser.setError("Min length is 8");
//            }
//        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
        btnDeleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtUser.setText("");
            }
        });
        btnDeletePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtPassword.setText("");
            }
        });
        btnDeleteUser.setVisibility(View.INVISIBLE);
        btnDeletePass.setVisibility(View.INVISIBLE);
        edtUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void afterTextChanged(Editable s) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0){
                    btnDeleteUser.setVisibility(View.VISIBLE);
                } else {
                    btnDeleteUser.setVisibility(View.GONE);
                }
            }
        });
        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0){
                    btnDeletePass.setVisibility(View.VISIBLE);
                }else {
                    btnDeletePass.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edtPassword.setImeOptions(EditorInfo.IME_ACTION_DONE);
        edtPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
                }
        });
    }
    public void clear(View view){
        edtUser.setText("");
        btnDeleteUser.setVisibility(View.GONE);
        btnDeletePass.setVisibility(View.GONE);
    }
}
