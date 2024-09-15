package com.example.vvce_staff;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.vvce_staff.networkUtils.DepartmentsActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;

public class RegistrationActivity extends AppCompatActivity {
    TextInputLayout facultyIdLayout, facultyDesignationLayout, usnLayout;
    EditText fullNameEt,emailEt,passwordEt,confirmPasswordEt;
    EditText facultyIdEt, facultyDesignationEt, usnEt;

    RadioButton studentRb,facultyRb;
    RadioGroup usersRg;

    Button registerBtn;


    private String fullName,email,usn,facultyId,facultyDesignation;
    private String password,confirmPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ActionBar actionBar = this.getSupportActionBar();
        if(actionBar!= null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        fullNameEt = findViewById(R.id.full_name_et);
        emailEt = findViewById(R.id.email_et);
        passwordEt = findViewById(R.id.password_et);
        confirmPasswordEt = findViewById(R.id.confirm_password_et);

        facultyIdLayout = findViewById(R.id.faculty_id_layout);
        facultyDesignationLayout = findViewById(R.id.designation_layout);
        facultyIdEt = findViewById(R.id.faculty_id_et);
        facultyDesignationEt = findViewById(R.id.designation_et);

        usnLayout = findViewById(R.id.usn_layout);
        usnEt = findViewById(R.id.usn_et);

        studentRb = findViewById(R.id.student_rb);
        facultyRb = findViewById(R.id.faculty_rb);
        usersRg = findViewById(R.id.user_rg);

        registerBtn = findViewById(R.id.register_btn);





        facultyRb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facultyDesignationLayout.setVisibility(View.VISIBLE);
                facultyIdLayout.setVisibility(View.VISIBLE);

                usnLayout.setVisibility(View.GONE);
            }
        });

        studentRb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usnLayout.setVisibility(View.VISIBLE);

                facultyDesignationLayout.setVisibility(View.GONE);
                facultyIdLayout.setVisibility(View.GONE);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    fullName = fullNameEt.getText().toString();
                    email = emailEt.getText().toString();

                    facultyId = facultyIdEt.getText().toString();
                    facultyDesignation = facultyDesignationEt.getText().toString();

                    usn = usnEt.getText().toString();

                    password = passwordEt.getText().toString();
                    confirmPassword = confirmPasswordEt.getText().toString();


                } catch (Exception e){
                    Toast.makeText(RegistrationActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                /*fullName empty check
                *if fullName is empty toast message "enter name"
                */
            if(TextUtils.isEmpty(fullName)){
                Toast.makeText(RegistrationActivity.this, "enter name", Toast.LENGTH_SHORT).show();
            }else if(!TextUtils.isEmpty(fullName)){

               /*email empty check
                *if email is empty toast message "enter email"
                *if email is not valid toast message "enter valid email"
                */
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(RegistrationActivity.this, "enter email", Toast.LENGTH_SHORT).show();
                }else if(!TextUtils.isEmpty(email)){
                    if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                            Toast.makeText(RegistrationActivity.this, "enter valid email", Toast.LENGTH_SHORT).show();
                        }else if(Patterns.EMAIL_ADDRESS.matcher(email).matches()){


                 /*
                 check for faculty radiobutton
                  */
                        if(!(facultyRb).isChecked()) {

                        /*usn empty check
                         *if usn is  empty toast message"enter usn"
                         */
                        if(TextUtils.isEmpty(usn)){
                            Toast.makeText(RegistrationActivity.this, "enter usn", Toast.LENGTH_SHORT).show();
                        }else if(!TextUtils.isEmpty(usn)){

                            /*
                             *compare password and confirmPassword
                             * if password entered is same intent RegistrationActivity.java
                             */
                            if(TextUtils.isEmpty(password)){
                                Toast.makeText(RegistrationActivity.this, "enter password", Toast.LENGTH_SHORT).show();
                            }else if(!TextUtils.isEmpty(password)){
                            if(password.equals(confirmPassword)){
                                Intent intent = new Intent(RegistrationActivity.this, DepartmentsActivity.class);
                                startActivity(intent);
                            }
                            if(!password.equals(confirmPassword)){
                                Toast.makeText(RegistrationActivity.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
                            }
                            }

                        }
                        /*
                        if facultyRb is checked

                         */
                            }else if(facultyRb.isChecked()){

                            /*
                            check for facultyId
                            if facultyId is empty toast message "enter Id"
                             */
                            if(TextUtils.isEmpty(facultyId)){
                                Toast.makeText(RegistrationActivity.this, "enter Id", Toast.LENGTH_SHORT).show();
                            }else if(!TextUtils.isEmpty(facultyId)){
                                /*
                                check for facultyDesignation
                                if facultyDesignation is empty toast message "enter destination"
                                 */

                                if(TextUtils.isEmpty(facultyDesignation)){
                                    Toast.makeText(RegistrationActivity.this, "enter destination", Toast.LENGTH_SHORT).show();
                                }else if(!TextUtils.isEmpty(facultyDesignation)) {
                                    /*
                                     *compare password and confirmPassword
                                     * if password entered is same intent RegistrationActivity.java
                                     */
                                    if (TextUtils.isEmpty(password)) {
                                        Toast.makeText(RegistrationActivity.this, "enter password", Toast.LENGTH_SHORT).show();
                                    } else if (!TextUtils.isEmpty(password)) {
                                        if (password.equals(confirmPassword)) {

                                            Intent intent = new Intent(RegistrationActivity.this, DepartmentsActivity.class);
                                            startActivity(intent);
                                        }
                                        if (!password.equals(confirmPassword)) {
                                            Toast.makeText(RegistrationActivity.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            }
                        }
                        }


                }
            }



            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }

}

