package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView helloWorld;
    Switch switchTextColor;
    Switch switchBgColor;
    RelativeLayout yourRelLay;
    EditText changeLabelField;
    RadioButton changeLabelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloWorld = (TextView) findViewById(R.id.helloView);
        switchTextColor = (Switch) findViewById(R.id.switchTextColor);
        switchBgColor = (Switch) findViewById(R.id.switchBgColor);
        yourRelLay = (RelativeLayout) findViewById(R.id.bg);
        changeLabelField = (EditText) findViewById(R.id.changeLabelField);
        changeLabelButton = (RadioButton) findViewById(R.id.changeLabelButton);

        switchTextColor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.i("World", "Text switch clicked");
                if(b) {
                    helloWorld.setTextColor(Color.parseColor("#fbceb1"));
                } else {
                    helloWorld.setTextColor(Color.parseColor("#e0dcdc"));
                }
            }
        });

        switchBgColor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.i("World", "Background switch clicked");
                if(b) {
                    yourRelLay.setBackgroundColor(Color.parseColor("#dd9787")); // choose a color if checked
                } else {
                    yourRelLay.setBackgroundColor(Color.parseColor("#92ddc8"));
                }
            }
        });

        yourRelLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // reset the text color back to white
                helloWorld.setTextColor(Color.parseColor("#e0dcdc"));
                // reset the background color to mint
                yourRelLay.setBackgroundColor(Color.parseColor("#92ddc8"));
                // reset the text back to 'Hello World!'
                helloWorld.setText("Hello World!");

                switchBgColor.setChecked(false);
                switchTextColor.setChecked(false);
                changeLabelButton.setChecked(false);
                changeLabelField.getText().clear();
            }
        });

        changeLabelButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    String userLabelInput = changeLabelField.getText().toString();
                    if(userLabelInput.equals("")) {
                        helloWorld.setText("Hello World!");
                    } else {
                        helloWorld.setText(userLabelInput);
                    }

                } else {
                    helloWorld.setText("Hello World!");
                    changeLabelField.getText().clear();
                }
            }
        });
    }
}