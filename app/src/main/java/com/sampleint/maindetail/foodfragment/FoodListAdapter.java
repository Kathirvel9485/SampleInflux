package com.sampleint.maindetail.foodfragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sampleint.R;
import com.sampleint.app.GlideApp;
import com.sampleint.data.FnblistItem;
import com.sampleint.data.FoodListItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<FnblistItem> foodItem = new ArrayList<>();

    public FoodListAdapter(Context context) {
        this.context = context;
    }


    public void setCommonList(List<FnblistItem> commonList) {
        if (commonList == null)
            return;
        this.foodItem.clear();
        this.foodItem.addAll(commonList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_foodlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FnblistItem foodList = foodItem.get(position);
        holder.bindDataToView(position, foodList);
    }

    @Override
    public int getItemCount() {
        return foodItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_normal)
        Button tvNormal;
        @BindView(R.id.tv_regular)
        Button tvRegular;
        @BindView(R.id.tv_large)
        Button tvLarge;
        @BindView(R.id.imv_foodImage)
        ImageView imvFood;
        @BindView(R.id.tv_minus)
        Button btn_minus;
        @BindView(R.id.tv_plus)
        Button btn_plus;
        @BindView(R.id.tv_count)
        TextView tv_count;
        @BindView(R.id.tv_name)
        TextView tv_name;
        @BindView(R.id.tv_id)
        TextView tv_id;

        boolean isNormalFocus=false;
        boolean isregularFocus=false;
        boolean isLargeFocus=false;



        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            tvNormal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (isNormalFocus) {
                        tvNormal.setSelected(false);
                        isNormalFocus=false;
                    }else {
                        tvNormal.setSelected(true);
                        isNormalFocus=true;
                    }
                }
            });
            tvRegular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (isregularFocus) {
                        tvRegular.setSelected(false);
                        isregularFocus=false;
                    }else {
                        tvRegular.setSelected(true);
                        isregularFocus=true;
                    }
                }
            });
            tvLarge.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (isLargeFocus) {
                        isLargeFocus=false;
                        tvLarge.setSelected(false);
                    }else {
                        isLargeFocus=true;
                        tvLarge.setSelected(true);
                    }
                }
            });

            btn_plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int count = Integer.parseInt(tv_count.getText().toString()) + 1;
                    tv_count.setText(count + "");
                }
            });

            btn_minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int count = Integer.parseInt(tv_count.getText().toString());
                    if (count != 0)
                        count = count - 1;
                    tv_count.setText(count + "");
                }
            });
        }

        public void bindDataToView(int position, FnblistItem foodList) {
            tv_count.setText("0");
            tv_name.setText(foodList.getName());
            tv_id.setText(foodList.getVistaFoodItemId());
            if (foodList.getSubitems().size() == 1) {
                tvNormal.setText(foodList.getSubitems().get(0).getName());
                tvNormal.setVisibility(View.VISIBLE);
                tvRegular.setVisibility(View.GONE);
                tvLarge.setVisibility(View.GONE);
            }
            if (foodList.getSubitems().size() == 2) {
                tvNormal.setText(foodList.getSubitems().get(0).getName());
                tvNormal.setText(foodList.getSubitems().get(1).getName());
                tvNormal.setVisibility(View.VISIBLE);
                tvRegular.setVisibility(View.VISIBLE);
                tvLarge.setVisibility(View.GONE);
            }
            if (foodList.getSubitems().size() == 3) {
                tvNormal.setText(foodList.getSubitems().get(0).getName());
                tvRegular.setText(foodList.getSubitems().get(1).getName());
                tvLarge.setText(foodList.getSubitems().get(2).getName());
                tvNormal.setVisibility(View.VISIBLE);
                tvRegular.setVisibility(View.VISIBLE);
                tvLarge.setVisibility(View.VISIBLE);
            }

            GlideApp.with(context)
                    .load(foodList.getImgUrl()).fitCenter().placeholder(R.drawable.ic_bg_image)
                    .into(imvFood);
        }
    }
}
