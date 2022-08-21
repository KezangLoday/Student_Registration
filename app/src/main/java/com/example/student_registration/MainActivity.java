package com.example.student_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public EditText name,id,module;
    public AutoCompleteTextView pg,yr,sm,ay;

    String[] prog = {"BE IT","BE ECE","BE EG","BE ICE","BE CIVIL","BE ELECTRICAL","ARCHITECTURE"};
    String[] acyear = {"AS2021","SS2021","AS2022","SS2022"};
    String[] sem = {"Semester 1","Semester 2"};
    String[] y ={"1st Year","2nd Year","3rd Year","4th Year","5th Year"};

    AutoCompleteTextView Proglist,Ayear,semester,year;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// assigning variables with thier IDs from xml
        name = (EditText) findViewById(R.id.etname);
        id= (EditText)findViewById(R.id.etID);
        module = (EditText) findViewById(R.id.etModules);
        pg = (AutoCompleteTextView) findViewById(R.id.plist);
        yr = (AutoCompleteTextView) findViewById(R.id.yearlist);
        sm = (AutoCompleteTextView) findViewById(R.id.semesterlist);
        ay = (AutoCompleteTextView) findViewById(R.id.aylist);

        //using array adapter to display the items in string array in dropdown list
        Proglist = findViewById(R.id.plist);
        adapterItems = new ArrayAdapter<String>(this,R.layout.dropdown_item,prog);
        Proglist.setAdapter(adapterItems);
        Proglist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }
        });


        Ayear = findViewById(R.id.aylist);
        adapterItems = new ArrayAdapter<String>(this,R.layout.dropdown_item,acyear);
        Ayear.setAdapter(adapterItems);
        Ayear.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }
        });

        semester = findViewById(R.id.semesterlist);
        adapterItems = new ArrayAdapter<String>(this,R.layout.dropdown_item,sem);
        semester.setAdapter(adapterItems);
        semester.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }
        });

        year = findViewById(R.id.yearlist);
        adapterItems = new ArrayAdapter<String>(this,R.layout.dropdown_item,y);
        year.setAdapter(adapterItems);
        year.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }
        });
    }
    public void submit(View view) {
        //to go the next activity when submit button is pressed
        Intent intent = new Intent(MainActivity.this,Details.class);
        String dname = name.getText().toString();
        String did = id.getText().toString();
        String dmodule = module.getText().toString();
        String dpg = pg.getText().toString();
        String dy = yr.getText().toString();
        String dsm = sm.getText().toString();
        String day = ay.getText().toString();

        // passing the strings collected from getText to next activity
        intent.putExtra("name",dname);
        intent.putExtra("id",did);
        intent.putExtra("module",dmodule);
        intent.putExtra("programme",dpg);
        intent.putExtra("year",dy);
        intent.putExtra("semester",dsm);
        intent.putExtra("ayear",day);
        startActivity(intent);
    }
}