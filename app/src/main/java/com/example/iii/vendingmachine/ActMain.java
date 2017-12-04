package com.example.iii.vendingmachine;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class ActMain extends AppCompatActivity {

    int Total=0,intprice=0,intnum=0;
    int income=0,differ=0;
    Spinner drink,temp1,temp2,num;
    TextView order;
    Button btnConfirm;
    String[] price ={"35","40","45","25"};
    //String[] tempSet1 ={"冰","去冰","少冰","熱"};
    //String[] tempSet2 ={"微甜","普通","少糖"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actmain);

        order = (TextView) findViewById(R.id.order);
        drink = (Spinner) findViewById(R.id.drink);
        temp1 = (Spinner) findViewById(R.id.temp1);
        temp2 = (Spinner) findViewById(R.id.temp2);
        num = (Spinner) findViewById(R.id.num);
        btnConfirm =  (Button)findViewById(R.id.btnConfirm);

        //Calculator
        findView();




        final ArrayAdapter<CharSequence> Adapter1 = ArrayAdapter.createFromResource(
                        this,R.array.drink, android.R.layout.simple_spinner_item);
        Adapter1.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        drink.setAdapter(Adapter1);

        final ArrayAdapter<CharSequence> Adapter1_1 = ArrayAdapter.createFromResource(
                this,R.array.price, android.R.layout.simple_spinner_item);
        Adapter1_1.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);


        final ArrayAdapter<CharSequence> Adapter2 = ArrayAdapter.createFromResource(
                this,R.array.temp1, android.R.layout.simple_spinner_item);
        Adapter2.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        temp1.setAdapter(Adapter2);


        final ArrayAdapter<CharSequence> Adapter3 = ArrayAdapter.createFromResource(
                this,R.array.temp2, android.R.layout.simple_spinner_item);
        Adapter3.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        temp2.setAdapter(Adapter3);

        final ArrayAdapter<CharSequence> Adapter4 = ArrayAdapter.createFromResource(
                this,R.array.num, android.R.layout.simple_spinner_item);
        Adapter4.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        num.setAdapter(Adapter4);



        //品項 & 價格
        drink.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        //快顯飲料金額
                        Toast.makeText(ActMain.this,
                                Adapter1.getItem(position)+" "+Adapter1_1.getItem(position)+"元",
                                Toast.LENGTH_SHORT)
                                .show();

                        //String[] PriceSet;
                        //   PriceSet = getResources().getStringArray(R.array.price);


                        for(int i=0;i<price.length;i++) {
                            if (position == i)
                            {
                                intprice = Integer.parseInt(price[i]);
                            };

                        }

                        selected();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

        //溫度
        temp1.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener(){

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(ActMain.this,
                                Adapter2.getItem(position),Toast.LENGTH_SHORT)
                                .show();

                        selected();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

        //甜度
        temp2.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener(){

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(ActMain.this,
                                Adapter3.getItem(position),Toast.LENGTH_SHORT)
                                .show();

                        selected();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
        //數量
        num.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener(){

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(ActMain.this,
                                Adapter4.getItem(position)+"杯",Toast.LENGTH_SHORT)
                                .show();

                        intnum=Integer.parseInt(num.getSelectedItem().toString());

                        selected();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });



        btnConfirm.setOnClickListener(new Button.OnClickListener(){

         // String  Payment = bar.getText().toString();
            @Override
            public void onClick(View v) {
                Total=intprice*intnum;
                income=Integer.parseInt(bar.getText().toString().trim());
                differ= income-Total;


                String msg =
                "品項: "+drink.getSelectedItem().toString()+"\n"+
                "溫度: "+temp1.getSelectedItem().toString()+"\n"+
                "甜度: "+temp2.getSelectedItem().toString()+"\n"+
                "單價: "  +intprice+"元"+"   "+
                "數量: "  +intnum+"杯"  +"   "+
                "總金額: " +Total+"元"  +"\n"+
                "================================\n"+
                "              付款: "+income+"元"+"   "+"找零:"+differ+"元";


                order.setText(msg);


            }
        });

    }


void selected()
{
    Total=intprice*intnum;
    String msg =
                "品項: "+drink.getSelectedItem().toString()+"\n"+
                "溫度: "+temp1.getSelectedItem().toString()+"\n"+
                "甜度: "+temp2.getSelectedItem().toString()+"\n"+
                "單價: "+intprice+"元"+"   "+
                "數量: "+num.getSelectedItem().toString()+"杯"+"   "+
                "總金額: " +Total+"元"+"\n";

    order.setText(msg);
}

/*
    private View.OnClickListener =new View.OnClickListener(){
        @Override
        public void onClick(View v) {

        }
    };*/


    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;
    private Button btn500;
    private Button btn1000;
    private Button btnback;
    private Button btnC;
    private Button btnPlus;
    private Button btnSub;
    private Button btnEqu;
    private EditText bar;
    private TextView lbl;
    private boolean flag = false;
    private boolean contiOper = false;
    private char lastOperate;
    private int lastNum = 0;


    private Button.OnClickListener bltisener = new Button.OnClickListener() {
        @Override
        public void onClick(View V) {
            switch (V.getId()) {
                case R.id.buttonback:
                    if(bar.getText().toString().length()==1) {
                        bar.setText("0");
                    } else {
                        bar.setText(bar.getText().toString().substring(0, bar.getText().toString().length() - 1));
                    }
                    break;
                case R.id.buttonC:
                    bar.setText("0");
                    break;
                case R.id.buttonPlus:
                    if(contiOper) {
                        int result = 0;
                        switch (lastOperate) {
                            case '+':
                                result = lastNum + Integer.parseInt(bar.getText().toString());
                                break;
                            case '-':
                                result = lastNum - Integer.parseInt(bar.getText().toString());
                                break;
                            case '*':
                                result = lastNum * Integer.parseInt(bar.getText().toString());
                                break;
                            case '/':
                                result = lastNum / Integer.parseInt(bar.getText().toString());
                                break;
                            default:
                                break;
                        }
                        lastNum = result;
                        bar.setText(String.valueOf(result));
                        contiOper = false;
                    } else {
                        contiOper = true;
                        lastNum = Integer.parseInt(bar.getText().toString());
                        bar.setText("0");
                    }
                    lastOperate = '+';
                    flag = true;
                    break;
                case R.id.buttonSubtract:
                    if(contiOper) {
                        int result = 0;
                        switch (lastOperate) {
                            case '+':
                                result = lastNum + Integer.parseInt(bar.getText().toString());
                                break;
                            case '-':
                                result = lastNum - Integer.parseInt(bar.getText().toString());
                                break;
                            case '*':
                                result = lastNum * Integer.parseInt(bar.getText().toString());
                                break;
                            case '/':
                                result = lastNum / Integer.parseInt(bar.getText().toString());
                                break;
                            default:
                                break;
                        }
                        lastNum = result;
                        bar.setText(String.valueOf(result));
                        contiOper = false;
                    } else {
                        contiOper = true;
                        lastNum = Integer.parseInt(bar.getText().toString());
                        bar.setText("0");
                    }
                    lastOperate = '-';
                    flag = true;
                    break;

                case R.id.buttonEqu:
                    if(flag) {
                        int result = 0;
                        switch (lastOperate) {
                            case '+':
                                result = lastNum + Integer.parseInt(bar.getText().toString());
                                break;
                            case '-':
                                result = lastNum - Integer.parseInt(bar.getText().toString());
                                break;
                            case '*':
                                result = lastNum * Integer.parseInt(bar.getText().toString());
                                break;
                            case '/':
                                result = lastNum / Integer.parseInt(bar.getText().toString());
                                break;
                            default:
                                break;
                        }
                        bar.setText(String.valueOf(result));
                    }
                    contiOper = false;
                    flag = false;
                    break;
                default:
                    // if origin is not 0, add a number in the last.
                    if(bar.getText().toString().equals("0")) {
                        bar.setText(((Button)V).getText().toString());
                    } else {
                        bar.setText(bar.getText().toString()+((Button)V).getText().toString());
                    }
            }
        }
    };

    private void findView() {
        bar = (EditText)findViewById(R.id.tv);
        lbl = (TextView) findViewById(R.id.label);
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        btn5 = (Button)findViewById(R.id.button5);
        btn6 = (Button)findViewById(R.id.button6);
        btn7 = (Button)findViewById(R.id.button7);
        btn8 = (Button)findViewById(R.id.button8);
        btn9 = (Button)findViewById(R.id.button9);
        btn0 = (Button)findViewById(R.id.button0);
        btn1000 = (Button)findViewById(R.id.button1000);
        btn500 = (Button)findViewById(R.id.button500);
        btnback = (Button)findViewById(R.id.buttonback);
        btnPlus = (Button)findViewById(R.id.buttonPlus);
        btnSub = (Button)findViewById(R.id.buttonSubtract);
        btnEqu = (Button)findViewById(R.id.buttonEqu);
        btnC = (Button)findViewById(R.id.buttonC);

        btn1.setOnClickListener(bltisener);
        btn2.setOnClickListener(bltisener);
        btn3.setOnClickListener(bltisener);
        btn4.setOnClickListener(bltisener);
        btn5.setOnClickListener(bltisener);
        btn6.setOnClickListener(bltisener);
        btn7.setOnClickListener(bltisener);
        btn8.setOnClickListener(bltisener);
        btn9.setOnClickListener(bltisener);
        btn0.setOnClickListener(bltisener);
        btn1000.setOnClickListener(bltisener);
        btn500.setOnClickListener(bltisener);
        btnback.setOnClickListener(bltisener);
        btnPlus.setOnClickListener(bltisener);
        btnSub.setOnClickListener(bltisener);
        btnEqu.setOnClickListener(bltisener);
        btnC.setOnClickListener(bltisener);
    }


}