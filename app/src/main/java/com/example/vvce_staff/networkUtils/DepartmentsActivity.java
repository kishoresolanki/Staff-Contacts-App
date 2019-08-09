package com.example.vvce_staff.networkUtils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.vvce_staff.Departments;
import com.example.vvce_staff.DepartmentsAdapter;
import com.example.vvce_staff.R;

import java.util.ArrayList;

public class DepartmentsActivity extends AppCompatActivity implements DepartmentsAdapter.ListItemOnClickListener {
    RecyclerView departmentListRV;

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
    }

    @Override
    public void onListItemClick(int position) {
        Toast mToast;
        String clickedItem = " "+departments.get(position).getDepartmentName();
        mToast = Toast.makeText(this,clickedItem,Toast.LENGTH_SHORT);
        mToast.show();
        //        intent = new Intent(ContactsActivity.this,ContactsActivity.class);
        //        intent.putExtra("departmentClicked",clickedItem);
        //        startActivity(intent);
    }
}
