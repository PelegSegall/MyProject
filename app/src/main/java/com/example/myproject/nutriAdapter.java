package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class nutriAdapter extends BaseAdapter {

    Context context;
    String[]array;
    LayoutInflater inflater;

    public nutriAdapter(Context ctx, String[] array) {
        this.context = ctx;
        this.array = array;
        inflater=LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return array.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    TextView stepSign, stepInfo;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= inflater.inflate(R.layout.nutri_listview, null);
        stepSign= convertView.findViewById(R.id.prep_sign);
        stepInfo= convertView.findViewById(R.id.prep_step);
        stepSign.setText("●");
        stepInfo.setText(array[position]);
        return convertView;
    }
}
