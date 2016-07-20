package com.corbin.phoneedittext.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.corbin.phoneedittext.R;
import com.corbin.phoneedittext.ui.widget.PhoneEditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.pet)
    PhoneEditText pet;
    @BindView(R.id.tv_phone)
    TextView tvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        pet.setPhoneNumFinish(phone->{
            tvPhone.setText(phone);
        });
    }
}
