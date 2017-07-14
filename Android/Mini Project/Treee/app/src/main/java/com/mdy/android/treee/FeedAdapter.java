package com.mdy.android.treee;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mdy.android.treee.domain.Memo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MDY on 2017-07-11.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.Holder> {

    List<Memo> data = new ArrayList<>();
    LayoutInflater inflater;

    public FeedAdapter(Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setFeedData(List<Memo> data) {
        this.data = data;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.feed_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Memo memo = data.get(position);
        holder.txtContent1.setText(memo.content1);
        holder.txtContent2.setText(memo.content2);
        holder.txtContent3.setText(memo.content3);
        holder.txtDate.setText(memo.date);
//.bitmapTransform(new GrayscaleTransformation(inflater.getContext()), new CropSquareTransformation(inflater.getContext()), new RoundedCornersTransformation(inflater.getContext(), 20, 5))

        Glide.with(inflater.getContext())
                .load(memo.fileUriString)
//                .bitmapTransform(new RoundedCornersTransformation(inflater.getContext(), 100, 20), new CenterCrop(inflater.getContext()))
//                .bitmapTransform(new CropSquareTransformation(inflater.getContext()))
                .centerCrop()
                .into(holder.imageView);

        holder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class Holder extends RecyclerView.ViewHolder {
        private int position;
        TextView txtContent1, txtContent2, txtContent3;
        TextView txtDate;
        ImageView imageView;

        public Holder(View itemView) {
            super(itemView);
            txtContent1 = (TextView) itemView.findViewById(R.id.txtContent1);
            txtContent2 = (TextView) itemView.findViewById(R.id.txtContent2);
            txtContent3 = (TextView) itemView.findViewById(R.id.txtContent3);
            txtDate = (TextView) itemView.findViewById(R.id.txtDate);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), ReadActivity.class);
                    intent.putExtra("LIST_POSITION", position);
                    v.getContext().startActivity(intent);
                }
            });
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
}