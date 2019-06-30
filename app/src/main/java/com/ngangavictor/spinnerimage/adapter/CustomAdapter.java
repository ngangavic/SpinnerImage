package com.ngangavictor.spinnerimage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ngangavictor.spinnerimage.R;

public class CustomAdapter extends ArrayAdapter {
    String[] countryNames;
    int[] images;
    Context context;

    public CustomAdapter(Context context, String[] countryNames, int[] images) {
        super(context, R.layout.custom_spinner_row);
        this.countryNames = countryNames;
        this.images = images;
        this.context = context;
    }

    @Override
    public int getCount() {
        return countryNames.length;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if (convertView==null){
            LayoutInflater layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_spinner_row,parent,false);
            viewHolder.imageViewFlag = convertView.findViewById(R.id.imageView);
            viewHolder.countryName = convertView.findViewById(R.id.textViewName);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.imageViewFlag.setImageResource(images[position]);
        viewHolder.countryName.setText(countryNames[position]);
        return convertView;
    }

    @Override
    public View getDropDownView(int position,View convertView,ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    private static class ViewHolder{
        ImageView imageViewFlag;
        TextView countryName;



    }
}
