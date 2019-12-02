package com.example.hr_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class HolidayListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_sub1);
        HolidayAdapter holidayAdapter=new HolidayAdapter(getHolidayList());
        RecyclerView recyclerView=findViewById(R.id.rvHolidays);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(holidayAdapter);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("sampleJson.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private List<Holiday> getHolidayList() {
        List<Holiday> holidayList = new ArrayList<>();

        try {
            JSONArray jsonarray = new JSONArray(loadJSONFromAsset());
            for (int i = 0; i < jsonarray.length(); i++) {
                Holiday  holiday= new Holiday();
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                int id = jsonobject.getInt("id");
                String date = jsonobject.getString("date");
                String holidayy = jsonobject.getString("holiday");
                String title = jsonobject.getString("title");
                holiday.setDate(date);
                holiday.setHoliday(holidayy);
                holiday.setId(id);
                holiday.setTitle(title);
                holidayList.add(holiday);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return holidayList;
    }



}
