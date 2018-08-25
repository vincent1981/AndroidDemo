package com.example.androidcalculatordemo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidcalculatordemo.R;


public class MainActivity extends AppCompatActivity {
    private Button acButton;
    private Button subButton;
    private Button addButton;
    private Button equalButton;
    private EditText showViewText;
    private int srcNum;
    private int resultNum;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initView() {
        this.acButton = findViewById(R.id.btn_ac);
        this.subButton = findViewById(R.id.btn_sub);
        this.addButton = findViewById(R.id.btn_add);
        this.equalButton = findViewById(R.id.btn_equal);
        this.showViewText = findViewById(R.id.show_view);
        this.srcNum = 0;
        this.resultNum = 0;
        this.showViewText.setText("0");

    }

    private void initEvent(){
        this.addButton.setOnClickListener(new addButtonClickEvent());
        this.acButton.setOnClickListener(new acButtonClickEvent());
        this.subButton.setOnClickListener(new subButtonClickEvent());
        this.equalButton.setOnClickListener(new equalButtonClickEvent());
    }

    private void setEditTextValue(String str) {
        String value = this.showViewText.getText().toString();
        String result = value.equals("0") ? str : value + str;
        this.showViewText.setText(result);
    }
    public void numberBtnLister(View view) {
        String value = this.showViewText.getText().toString();
        int id = view.getId();
        switch (id) {
            case R.id.btn_num_0:
                setEditTextValue("0");
                break;
            case R.id.btn_num_1:
                setEditTextValue("1");
                break;
            case R.id.btn_num_2:
                setEditTextValue("2");
                break;
            case R.id.btn_num_3:
                setEditTextValue("3");
                break;
            case R.id.btn_num_4:
                setEditTextValue("4");
                break;
            case R.id.btn_num_5:
                setEditTextValue("5");
                break;
            case R.id.btn_num_6:
                setEditTextValue("6");
                break;
            case R.id.btn_num_7:
                setEditTextValue("7");
                break;
            case R.id.btn_num_8:
                setEditTextValue("8");
                break;
            case R.id.btn_num_9:
                setEditTextValue("9");
                break;
            default:
                break;

        }
    }

    class addButtonClickEvent implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            srcNum = Integer.parseInt(showViewText.getText().toString());
            showViewText.setText("0");
            operation = "add";
        }
    }
    class acButtonClickEvent implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            showViewText.setText("0");
            srcNum = 0;
            resultNum = 0;
        }
    }
    class subButtonClickEvent implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            srcNum = Integer.parseInt(showViewText.getText().toString());
            showViewText.setText("0");
            operation = "sub";
        }
    }
    class  equalButtonClickEvent implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int value = Integer.parseInt(showViewText.getText().toString());
            resultNum = result(value);
            showViewText.setText(resultNum + "");
        }

        private int result(int value) {
            int resultValue = 0;
            if (operation.equals("add")) {
                resultValue = srcNum + value;
            } else if(operation.equals("sub")) {
                resultValue = srcNum - value;
            }

            return resultValue;
        }
    }

}
