package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PrepAdapter extends BaseAdapter {

    Context context;
    String[]prepArray;
    LayoutInflater inflater;

    public PrepAdapter(Context ctx, String[] prepArray) {
        this.context = ctx;
        this.prepArray = prepArray;
        inflater=LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return prepArray.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    TextView stepNum, stepInfo;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= inflater.inflate(R.layout.prep_listview, null);
        stepNum= convertView.findViewById(R.id.prep_num);
        stepInfo= convertView.findViewById(R.id.prep_step);
        stepNum.setText(String.valueOf(position+1));
        stepInfo.setText(prepArray[position]);
        return convertView;
    }
}
