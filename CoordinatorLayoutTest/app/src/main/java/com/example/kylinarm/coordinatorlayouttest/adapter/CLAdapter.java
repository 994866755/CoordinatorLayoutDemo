package com.example.kylinarm.coordinatorlayouttest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kylinarm.coordinatorlayouttest.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2017/8/21.
 */

public class CLAdapter extends RecyclerView.Adapter<CLAdapter.CLViewHolder> {

    private Context context;
    private List<String> datalist;

    public CLAdapter(Context context,List<String> datalist){
        this.context = context;
        this.datalist = datalist;
    }

    @Override
    public CLViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CLViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_textview,null));
    }

    @Override
    public void onBindViewHolder(CLViewHolder holder, int position) {
        holder.setDataToView(datalist.get(position));
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public static class CLViewHolder extends RecyclerView.ViewHolder{

        @InjectView(R.id.tv_content)
        TextView tvContent;

        public CLViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this,itemView);
        }

        public void setDataToView(String data){
            tvContent.setText(data);
        }

    }

}
