package com.example.w3_viewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private final String TAG = this.getClass().getCanonicalName();
    EditText edtName;
    EditText edtEmail;
    Button btnFetchData;
    RadioGroup rdgGender;
    RadioButton rdbSelected;
    Spinner spnProvinces;
    AutoCompleteTextView atvPrograms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.referViews();
    }

    private void referViews(){
        this.edtName = findViewById(R.id.edit_name);
        this.edtEmail = findViewById(R.id.edit_email);
        this.rdgGender = findViewById(R.id.rdg_gender);
        this.spnProvinces = findViewById(R.id.spn_provinces);
        this.atvPrograms = findViewById(R.id.atv_programs);

        this.btnFetchData = findViewById(R.id.fetch_data);
        this.btnFetchData.setOnClickListener(this);

        //Adapter
        ArrayAdapter programsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.programs) );
        this.atvPrograms.setAdapter(programsAdapter);
        this.atvPrograms.setThreshold(3);

    }

    @Override
    public void onClick(View view){
        if (view != null){
            switch (view.getId()){
                case R.id.fetch_data:{
                    fetchData();
                    break;
                }
            }
        }
    }
    private void fetchData(){
        Log.d(TAG+ "fetchData", "fetchData: " + this.edtName.getText());
        Log.d(TAG+ "fetchdata", this.edtEmail.getText().toString());

        String name = this.edtName.getText().toString();
        String email = this.edtEmail.getText().toString();

        //Log.d(TAG, "fetchData: " + name + "\n" + email);

        if (this.edtEmail.getText().toString().isEmpty()){
            this.edtEmail.setError("Please enter your email");
        }else{
            email = this.edtEmail.getText().toString();
        }
        this.rdbSelected = findViewById(this.rdgGender.getCheckedRadioButtonId());

        if (this.rdbSelected != null){
            String selectedGender = this.rdbSelected.getText().toString();
            Log.d(TAG, "fetchData: \n name : " + name + "\n email : " + email + "\n Gender : " + selectedGender);
        }

        String province = "";
        province = this.spnProvinces.getSelectedItem().toString();
        Log.d(TAG, "fetchData: \n name : " + name + "\n email : " + email + "\n province : " + province);




    }
}
