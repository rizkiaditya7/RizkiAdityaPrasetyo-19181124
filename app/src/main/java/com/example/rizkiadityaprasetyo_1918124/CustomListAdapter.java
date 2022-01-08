package com.example.rizkiadityaprasetyo_1918124;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<tni> tni;

    public CustomListAdapter(Activity activity, List<tni> tni) {
        this.activity = activity;
        this.tni = tni;
    }

    @Override
    public int getCount() {
        return tni.size();
    }

    @Override
    public Object getItem(int location) {
        return tni.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);

        TextView nama = (TextView)
                convertView.findViewById(R.id.text_nama);
        TextView umur = (TextView)
                convertView.findViewById(R.id.text_umur);
        TextView pangkat = (TextView)
                convertView.findViewById(R.id.text_pangkat);
        TextView satuan = (TextView)
                convertView.findViewById(R.id.text_satuan);

        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);

        tni m = tni.get(position);

        nama.setText("Nama : "+ m.get_nama());
        umur.setText("Umur : "+ m.get_umur());
        pangkat.setText("Pangkat : "+ m.get_pangkat());
        satuan.setText("Satuan : "+ m.get_satuan());

        return convertView;
    }
}
