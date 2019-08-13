package com.example.vvce_staff.networkUtils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.vvce_staff.Departments;
import com.example.vvce_staff.DepartmentsAdapter;
import com.example.vvce_staff.MainActivity;
import com.example.vvce_staff.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class DepartmentsActivity extends AppCompatActivity implements DepartmentsAdapter.ListItemOnClickListener {
    RecyclerView departmentListRV;
    private FirebaseAuth mAuth;

    int userGroup;

    DepartmentsAdapter dAdapter;

    ArrayList<Departments> departments = new ArrayList<Departments>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);
        departments.add(new Departments("MAINTENANCE & EMERGENCIES"));
        departments.add(new Departments("COMPUTER SCIENCE"));
        departments.add(new Departments("INFORMATION SCIENCE"));
        departments.add(new Departments("MECHANICAL"));
        departments.add(new Departments("CIVIL"));
        departments.add(new Departments("ELECTRICAL AND ELECTRONICS"));
        departments.add(new Departments("ELECTRICAL AND COMMUNICATION"));
        departments.add(new Departments("RESEARCH AND DEVELOPMENT"));
        departments.add(new Departments("PHYSICS"));
        departments.add(new Departments("CHEMISTRY"));
        departments.add(new Departments("MBA"));
        departments.add(new Departments("TRAINING AND PLACEMENT"));
        departments.add(new Departments("LIBRARY"));
        departments.add(new Departments("LAW"));
        departments.add(new Departments("SPORTS"));

        dAdapter = new DepartmentsAdapter(R.layout.departmentview,departments,this);
        departmentListRV = findViewById(R.id.departmentListRV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        departmentListRV.setLayoutManager(linearLayoutManager);
        departmentListRV.setAdapter(dAdapter);
        mAuth = FirebaseAuth.getInstance();

        Intent intent = getIntent();
        userGroup = intent.getIntExtra("UserGroup",1);


    }

    @Override
    public void onListItemClick(int position) {
        Toast mToast;
        String clickedItem = " "+departments.get(position).getDepartmentName();
        mToast = Toast.makeText(this,clickedItem,Toast.LENGTH_SHORT);
        mToast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.departments_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.SignOut){
            Intent intent = new Intent(DepartmentsActivity.this,MainActivity.class);
            startActivity(intent);
        }

        return true;
    }
}
