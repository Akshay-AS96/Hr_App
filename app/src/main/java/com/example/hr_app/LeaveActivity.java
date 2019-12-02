package com.example.hr_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class LeaveActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = "LeaveActivity";
    private TextView StartDate;
    private TextView EndDate;
    private DatePickerDialog.OnDateSetListener SDate, EDate;
    Spinner spinner;
    private Button Holiday;
    private String startDate;
    private TextView Dayz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave);
        Dayz=(TextView) findViewById(R.id.Bday);


        Holiday = (Button) findViewById(R.id.button7);
        Holiday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LeaveActivity.this, HolidayListActivity.class);
                startActivity(intent);
            }
        });
        spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements

        ArrayList<String> categories = new ArrayList<>();
        categories.add("Casual");
        categories.add("Sick");
        categories.add("Medical");
        categories.add("Travel");
        categories.add("Personal");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                R.layout.custom_spinner_layout, categories);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);

        StartDate = (TextView) findViewById(R.id.tvSDate);
        StartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        LeaveActivity.this,
                        android.R.style.Theme_Material_Light_Dialog_Alert,
                        SDate, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.show();
            }
        });
        SDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yy" + month + "/" + day + "/" + year);
                startDate = month + "/" + day + "/" + year;
                StartDate.setText(startDate);
            }
        };
        EndDate = (TextView) findViewById(R.id.tvEDate);
        EndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        LeaveActivity.this,
                        android.R.style.Theme_Material_Light_Dialog_Alert,
                        EDate, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.show();
            }
        });
        EDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yy" + month + "/" + day + "/" + year);
                String endDate = month + "/" + day + "/" + year;
                EndDate.setText(endDate);
                SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yy");

                Date eDate = null, sDate = null;
                try {
                    eDate = sdf.parse(endDate);
                    sDate = sdf.parse(startDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long days = getDateDiff(sDate, eDate, TimeUnit.DAYS);
                Toast.makeText(LeaveActivity.this,"No. of Days"+days,Toast.LENGTH_LONG).show();
                Dayz.setText(""+(int) days);

            }
        };

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = spinner.getSelectedItem().toString();
        Toast.makeText(this, item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
}

