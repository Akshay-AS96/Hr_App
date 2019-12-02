package com.example.hr_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.HolidayViewHolder> {

           List<Holiday> holidayList = new ArrayList<>();


    public HolidayAdapter(List<Holiday> holiday) {
        holidayList = holiday;
    }

    @NonNull
    @Override
    public HolidayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.rv_items, parent, false);

        return new HolidayViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull HolidayViewHolder holder, int position) {
        final Holiday myListData= holidayList.get(position);
        holder.textView1.setText(" "+myListData.getId());
        holder.textView2.setText(myListData.getDate());
        holder.textView3.setText(myListData.getHoliday());
        holder.textView4.setText(myListData.getTitle());

    }

    @Override
    public int getItemCount() {
        return holidayList.size();
    }

    class HolidayViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;

        public HolidayViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.textView4);
            textView2=itemView.findViewById(R.id.textView5);
            textView3=itemView.findViewById(R.id.textView6);
            textView4=itemView.findViewById(R.id.textView7);
        }
    }
}
