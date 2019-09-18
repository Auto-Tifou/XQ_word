package com.example.administrator.xq;


import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText edt_name,edt_pwd;
    private Button btn_zc,btn_wj,btn_dl;
    private CheckBox che_zd,che_jz;
    private MyHelper dbHelper;
    private SQLiteDatabase db;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_zc=(Button) findViewById(R.id.Txt_zc);
        btn_wj=(Button) findViewById(R.id.Txt_wj);
        btn_dl=(Button)findViewById(R.id.Btn_dl);
        edt_name=(EditText)findViewById(R.id.Edt_name);
        edt_pwd=(EditText)findViewById(R.id.Edt_pwd);
        che_zd=(CheckBox)findViewById(R.id.Che_zd);
        che_jz=(CheckBox)findViewById(R.id.Che_jz);
        pref=getSharedPreferences("myPref",MODE_PRIVATE);
        editor=pref.edit();

        String defaultnumber = pref.getString("edt_name","");
        String defaultpwd = pref.getString("edt_pwd","");
        if ((!defaultnumber.equals("")) && (!defaultpwd.equals(""))){
            edt_name.setText(defaultnumber);
            edt_pwd.setText(defaultpwd);
            che_jz.setChecked(true);
        }else if ((!defaultnumber.equals("")) && (!defaultpwd.equals(""))){
            edt_name.setText(defaultnumber);
            che_jz.setChecked(false);
        }

        btn_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stName=edt_name.getText().toString().trim();//获取用户名
                String stPwd=edt_pwd.getText().toString().trim();//获取密码
                Cursor c=db.rawQuery("select * from user where name=?",new String[]{ stName });//游标查询
                String userPwd=null; //从用户中查询到密码
                String stSql="insert into user(name,pwd) " +
                        "values('"+stName+"','"+stPwd+"')";// 构建sql语句
                db.execSQL(stSql);//添加sql记录
                if(TextUtils.isEmpty(stName) || TextUtils.isEmpty(stPwd)){
                    Toast.makeText(MainActivity.this,"账号或密码不能为空",Toast.LENGTH_SHORT).show();
                }
                if(stPwd.equals(userPwd)) { //判断表中查询到密码是否和用户输入密码相同
                    Toast.makeText(MainActivity.this,"注册失败，已有账号",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                }
                edt_name.setText("");
                edt_pwd.setText("");
             }
        });
        btn_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stName=edt_name.getText().toString().trim();
                String stPwd=edt_pwd.getText().toString().trim();
                Cursor c=db.rawQuery("select * from user where name=?",new String[]{ stName });//游标查询
                String userPwd=null; //从用户中查询到密码

                if (che_jz.isChecked()){
                    editor.putString("edt_name",stName);
                    editor.putString("edt_pwd",stPwd);
                    editor.commit();
                }else {
                    editor.remove("edt_pwd");
                    editor.commit();
                }
                if (c.moveToFirst()){ //游标移到第一条记录查询是否有记录，有则获取密码
                    int n = c.getColumnIndex("pwd");
                    userPwd=c.getString(n);
                }if(stPwd.equals(userPwd)) { //判断表中查询到密码是否和用户输入密码相同
                    Intent intent = new Intent(MainActivity.this,ZxActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "登录失败,密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dbHelper=new MyHelper(this,"db_stu",null,1);
        db=dbHelper.getWritableDatabase();

        btn_wj.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
