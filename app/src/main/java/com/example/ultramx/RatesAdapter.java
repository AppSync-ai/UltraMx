package com.example.ultramx;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.appolica.flubber.Flubber;
import com.mt.lamdatrack.Rate.RatesReq;

import java.util.List;


public class RatesAdapter extends RecyclerView.Adapter<RatesAdapter.ViewHolder> {

    public List<RatesReq> blog_list;
    private static final int CAMERA_CODE2 = 22;
    int cur;
    public Context context;

    public RatesAdapter(List<RatesReq> blog_list) {
        this.blog_list = blog_list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_rate, parent, false);

        context = parent.getContext();

        return new ViewHolder(view);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        Flubber.with()
                .animation(Flubber.AnimationPreset.SLIDE_LEFT) // Slide up animation
                .repeatCount(0)                              // Repeat once
                .duration(500)                              // Last for 1000 milliseconds(1 second)
                .createFor(holder.reler)                             // Apply it to the view
                .start();


//        final String PostId = blog_list.get(position).FacebookPostId;
        holder.setIsRecyclable(false);

        holder.txt1.setText("" + blog_list.get(position).getCURRENCY());
        holder.txt2.setText("" + blog_list.get(position).getPRICE());
        holder.change_txt.setText("" + blog_list.get(position).getCHANGE());
        holder.change_percent_txt.setText("Change : " + blog_list.get(position).getCHANGE_percent());
        holder.open_txt.setText("Open : " + blog_list.get(position).getOPEN());
        holder.prev_txt.setText("Previous Close : " + blog_list.get(position).getPREV_CLOSE());
        holder.lo_hight_txt.setText("Low-High : " + blog_list.get(position).getLOW_HIGH());
        if (blog_list.get(position).getCHANGE().contains("-")) {
            holder.change_txt.setTextColor(Color.RED);
        } else {
            holder.change_txt.setTextColor(Color.GREEN);
        }

    }


    @Override
    public int getItemCount() {
        return blog_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView1, imageView2, imageView3;
        TextView txt1, txt2, change_txt, change_percent_txt, prev_txt,lo_hight_txt, open_txt;
        private View mView;
        Button Btn1, Btn2, Btn3, Btn4;
        ProgressBar progressBar;
        LinearLayoutCompat reler;
        CardView cardView;
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;


            lo_hight_txt = itemView.findViewById(R.id.lo_hight_txt);
            prev_txt = itemView.findViewById(R.id.prev_txt);
            open_txt = itemView.findViewById(R.id.open_txt);
            change_percent_txt = itemView.findViewById(R.id.change_percent_txt);
            txt2 = itemView.findViewById(R.id.txt2);
            txt1 = itemView.findViewById(R.id.txt1);
            reler = itemView.findViewById(R.id.reler);
            change_txt = itemView.findViewById(R.id.change_txt);

        }


    }


}
