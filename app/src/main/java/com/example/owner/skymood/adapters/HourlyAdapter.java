package com.example.owner.skymood.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.owner.skymood.R;
import com.example.owner.skymood.model.HourlyWeather;

import java.util.ArrayList;

/**
 * Created by Golemanovaa on 04/04/2016.
 */
public class HourlyAdapter extends RecyclerView.Adapter<HourlyWeekViewHolder> {

    private static final int MIN_WEATHERS_SIZE = 24;
    private static final String HOUR_TEMPLATE = "%s:00";
    private static final String TEMP_TEMPLATE = "%s ℃";

    private Context context;
    private ArrayList<HourlyWeather> weathers;

    public HourlyAdapter(Context context, ArrayList<HourlyWeather> weathers) {

        this.context = context;
        this.weathers = weathers;
    }


    @Override
    public HourlyWeekViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        //TODO wtf?! see this layouts row_hour & row_week
        View row = inflater.inflate(R.layout.row_hour, parent, false);
        return new HourlyWeekViewHolder(row);
    }

    @Override
    public void onBindViewHolder(HourlyWeekViewHolder holder, int position) {

        HourlyWeather weather = weathers.get(position);
        holder.getHour().setText(String.format(HOUR_TEMPLATE, weather.getHour()));
        holder.getTemp().setText(String.format(TEMP_TEMPLATE, weather.getTemp()));
        holder.getIcon().setImageBitmap(weather.getIcon());

    }

    @Override
    public int getItemCount() {

        return weathers.size() > MIN_WEATHERS_SIZE ? MIN_WEATHERS_SIZE : weathers.size();
    }

}
