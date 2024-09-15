package com.example.vvce_staff;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DepartmentsAdapter extends RecyclerView.Adapter<DepartmentsAdapter.departmentViewholder> {
    private int listItemLayout;
    private ArrayList<Departments> mCustomObjects;
    final private ListItemOnClickListener mListItemOnClickListener;



    public interface ListItemOnClickListener{
        void onListItemClick(int position);
    }

    public DepartmentsAdapter(int layoutId, ArrayList<Departments> arrayList, ListItemOnClickListener listItemOnClickListener){
        listItemLayout =layoutId;
        mListItemOnClickListener=listItemOnClickListener;
        mCustomObjects =arrayList;
    }
    @Override
    public departmentViewholder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(listItemLayout, viewGroup, false);
        return new departmentViewholder(view);
    }

    @Override
    public void onBindViewHolder( departmentViewholder departmentViewholder, int i) {
        TextView item = departmentViewholder.DepartmentTextView;
        item.setText(mCustomObjects.get(i).getDepartmentName());
    }

    @Override
    public int getItemCount() {
        return mCustomObjects.size();
    }

    class departmentViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView DepartmentTextView;

        public departmentViewholder(View itemView) {

            super(itemView);
            DepartmentTextView = itemView.findViewById(R.id.departmentTextView);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mListItemOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
