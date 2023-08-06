package com.example.healthcaretest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Uprise-03 Capsule","","","","50"},
                    {"HealthVit Chromium Picolinate 200mcg","","","","305"},
                    {"Bitamin B Complex Capsules","","","","448"},
                    {"Inlife VItaminE Wheat Germ Oil Capsule","","","","539"},
                    {"Dolo 650 Tablet ","","","","30"},
                    {"Crocin 650 Advance Tablet","","","","50"},
                    {"Strepsils Medicated Lozenges for Sor Throat " ,"","","","40"},
                    {"Tata 1mg Calcium + Vitamin D3","","","","30"},
                    {"Feronia -XT Table","","","","130"},



            };

    private String[] package_details = {
            "Building and keeping the bones & teeth Strong\n" +
                    "Reducing Fatigue/stress and muscular pains\n"+
                    "Booting immunity and increasing resistance against infection",
            "Chromium is an essential trace mineral that plays an important Role in helping insulin regulate blood glucose",
            "Provides relief from vitamin B deficiencies\n" +
                    "Helps in formation of blood red cells\n "  +
                    "Maintains healthy nervous system    ",
            "It promotes health as well as skin benefit .\n"+
                    "It helps reduce skin blemis and pigmentation.\n"+
                    "It acts as safegaurd the slin from the harsh UVA and UVB sun rays.",
            "dono 650 tablets HElps relieve pain and fever aby blocking the release of certain chemical messengers responsible for fever and pain ",
            "Helps relieve fever and bring down a high temperature \n"+
                    "suitable for people with a heart condition or high blood pressure  ",
            "Relieve the symptoms of a bacterial throat infection   \n" +
                    "Provide a warm and comforting feeling during sore throat",
            "Reduce the Risk of calcium deficiency ,Rickets , and osteoporosis\n"+
                    "promotes mobility and flexibility of Joints",
            "Helps to reduce the iron deficiency due to chronic blood loss or low intake of iron"


    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGoToCart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);
        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMCartBack);
        btnGoToCart = findViewById(R.id.buttonBMCartAddToCart);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String,String>();
            item.put( "line1" ,packages[i][0]);
            item.put( "line2" ,packages[i][1]);
            item.put( "line3" ,packages[i][2]);
            item.put( "line4" ,packages[i][3]);
            item.put( "line5" ,"Total Cost: "+ packages[i][4]+"/-");
            list.add(item);


        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);

            }
        });


    }
}