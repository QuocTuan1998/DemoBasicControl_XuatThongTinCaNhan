package com.example.quoctuan.demobasiccontrol_xuatthongtincanhan;

import android.content.DialogInterface;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText editTen,editCMND,editThongTin;

    CheckBox chkDocBao,chkDocSach,chkDocCode;

    RadioGroup radBangCap;

    RadioButton radCaoDang,radTrungCap,radDaiHoc;

    Button btnThongTin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();

    }

    private void addControls() {

        editTen = (EditText) findViewById(R.id.editTen);
        editCMND = (EditText) findViewById(R.id.editCMND);
        editThongTin = (EditText) findViewById(R.id.editThongTin);

        chkDocBao = (CheckBox) findViewById(R.id.chkDocBao);
        chkDocCode = (CheckBox) findViewById(R.id.chkDocCode);
        chkDocSach = (CheckBox) findViewById(R.id.chkDoscach);

        radBangCap = (RadioGroup) findViewById(R.id.radBangCap);

        radDaiHoc = (RadioButton) findViewById(R.id.radDaiHoc);
        radCaoDang = (RadioButton) findViewById(R.id.radCaoDang);
        radTrungCap = (RadioButton) findViewById(R.id.radTrungCap);

        btnThongTin = (Button) findViewById(R.id.btnThongTin);

    }

    private void addEvents() {

         radBangCap.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                 radDaiHoc.setChecked(true);
             }
         });

        btnThongTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int lengthName = editTen.getText().length();
                String ten = editTen.getText().toString();
                String cmnd = editCMND.getText().toString();
                String bangCap = radDaiHoc.getText().toString();
                String thongTinBoSung = editThongTin.getText().toString();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                String msg = "";
                String docSach = chkDocSach.getText().toString();
                String docBao = chkDocBao.getText().toString();
                String doccode = chkDocCode.getText().toString();
                if (chkDocSach.isChecked()&&chkDocBao.isChecked()
                    &&lengthName > 3){


                    msg += ten+"\n"+cmnd+"\n"+bangCap+"\n"+docSach+docBao+"\n"+thongTinBoSung;


                }
                else if (chkDocSach.isChecked()&&chkDocCode.isChecked()
                        &&lengthName > 3){

                    msg += ten+"\n"+cmnd+"\n"+bangCap+"\n"+docSach+doccode+"\n"+thongTinBoSung;

                }
                else if (chkDocCode.isChecked()&&chkDocBao.isChecked()
                        &&lengthName > 3) {

                    msg += ten +
                            "\n" + cmnd + "\n" +
                            bangCap + "\n" +
                            doccode + "--" + docBao +
                            "\nThông tin bổ sung\n" +
                            thongTinBoSung;

                }
                else {
                    msg += "Nhập sai vui lòng nhập lại";

                }
                builder.setMessage(msg);
                builder.setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }

        });


    }
}
