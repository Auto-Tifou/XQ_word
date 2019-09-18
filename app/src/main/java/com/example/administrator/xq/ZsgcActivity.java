package com.example.administrator.xq;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Administrator on 2019/7/2 0002.
 */

public class ZsgcActivity extends AppCompatActivity{
    private EditText edtName,edtNumber;
    private Button btnAdd,btnUpdate,btnDelete,btnFind;
    private TextView tvStatus;
    private Dao dao;
    private String personName,personNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zsgc);
        initView();
        dao=new Dao(this);
    }

    //控件和监听
    private void initView(){
        edtName=(EditText)findViewById(R.id.edt_name);
        edtNumber=(EditText)findViewById(R.id.edt_psword);
        btnAdd=(Button)findViewById(R.id.btn_add);
        btnUpdate=(Button)findViewById(R.id.btn_update);
        btnDelete=(Button)findViewById(R.id.btn_delete);
        btnFind=(Button)findViewById(R.id.btn_find);
        tvStatus=(TextView)findViewById(R.id.tv_status);
        btnAdd.setOnClickListener(new MyListener());
        btnUpdate.setOnClickListener(new MyListener());
        btnDelete.setOnClickListener(new MyListener());
        btnFind.setOnClickListener(new MyListener());
    }
    //事件
    private class MyListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int i;
            switch (v.getId()){
                case R.id.btn_add:
                    personName=edtName.getText().toString();
                    personNumber=edtNumber.getText().toString();
                    dao.add(personName,personNumber);
                    reset("添加记录成功");
                    Intent intent = new Intent(ZsgcActivity.this,ZxActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_update:
                    personName=edtName.getText().toString();
                    personNumber=edtNumber.getText().toString();
                    if(dao.find(personName)) {
                        i = dao.update(personName, personNumber);
                        reset("更新记录成功");
                    }
                    else
                        reset(personName+"不存在");
                    break;
                case R.id.btn_delete:
                    personName=edtName.getText().toString();
                    if(dao.find(personName)) {
                        i = dao.delete(personName);
                        reset("删除记录成功");
                    }
                    else
                        reset(personName+"不存在");
                    break;
                case R.id.btn_find:
                    personName=edtName.getText().toString();
                    if(dao.find(personName)) {
                        personNumber = dao.query(personName);
                        edtNumber.setText(personNumber);
                    }
                    else
                        reset(personName+"不存在");
                    break;
                default:
            }
        }
        private void reset(String msg){
            tvStatus.setText(msg);
            edtName.setText("");
            edtNumber.setText("");
            personName=null;
            personNumber=null;
        }
    }
}

