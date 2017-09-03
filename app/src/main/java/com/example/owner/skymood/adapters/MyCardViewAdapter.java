package com.example.owner.skymood.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.owner.skymood.R;
import com.example.owner.skymood.model.LocationPreference;
import com.example.owner.skymood.model.MyLocation;
import com.example.owner.skymood.model.MyLocationManager;

import java.util.ArrayList;

/**
 * Created by Golemanovaa on 08/04/2016.
 */
public class MyCardViewAdapter extends RecyclerView.Adapter<MyCardViewAdapter.CardViewHolder>{

    private Context context;
    private ArrayList<MyLocation> data;
    private int lastCheckedPosition;
    private LocationPreference pref;
    private MyLocationManager manager;

    public MyCardViewAdapter(Context context, ArrayList<MyLocation> data) {

        this.context = context;
        this.data = data;
        lastCheckedPosition = -1;
        pref = LocationPreference.getInstance(context);
        manager = MyLocationManager.getInstance(context);
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View root = inflater.inflate(R.layout.row_my_location, parent, false);
        return new CardViewHolder(root);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {

        MyLocation location = data.get(position);
        holder.city.setText(location.getCity());
        holder.country.setText(location.getCountry());
        holder.code.setText(location.getCode());


        if (pref.getCity() != null && location.getCity().equals(pref.getCity()) && location.getCountry().equals(pref.getCountry()))
            holder.radio.setChecked(true);
        else
            holder.radio.setChecked(position == lastCheckedPosition);
    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    private void removeAt(int position) {

        data.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, data.size());
    }

    class CardViewHolder extends RecyclerView.ViewHolder {

        TextView city;
        TextView country;
        TextView code;
        RadioButton radio;
        ImageView erase;

        CardViewHolder(View itemView) {

            super(itemView);

            this.city = (TextView) itemView.findViewById(R.id.row_my_location_tv_city);
            this.country = (TextView) itemView.findViewById(R.id.row_my_location_tv_country);
            this.code = (TextView) itemView.findViewById(R.id.row_my_location_tv_code);
            this.erase = (ImageView) itemView.findViewById(R.id.row_my_location_iv_delete);
            this.radio = (RadioButton) itemView.findViewById(R.id.row_my_location_view_radio_btn);

            // onclick for setting location as default
            radio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    lastCheckedPosition = getAdapterPosition();
                    notifyItemRangeChanged(0, data.size());
                    String cityTxt = city.getText().toString();
                    String countryTxt = country.getText().toString();
                    String codeTxt = code.getText().toString();
                    pref.setPreferredLocation(cityTxt, countryTxt, codeTxt, null, null, null, null, null, null, null);
                    Toast.makeText(context, cityTxt + " was set as default location", Toast.LENGTH_SHORT).show();
                }
            });

            erase.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                    manager.deleteMyLocation(data.get(position));
                    removeAt(position);
                    if (position < lastCheckedPosition) {
                        lastCheckedPosition--;
                    } else if (position == lastCheckedPosition) {
                        pref.removeInfo();
                    }

                }
            });
        }
    }
}
