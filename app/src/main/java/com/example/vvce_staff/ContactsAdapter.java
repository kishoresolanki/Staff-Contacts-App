package com.example.vvce_staff;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {
    private int layout_id;
    private ArrayList<Contacts> mCustomContactObjects;
    final private ContactsItemOnClickListener mContactsListItemOnClickListener;

    public ContactsAdapter(int layout_id,ArrayList<Contacts> contacts,ContactsItemOnClickListener ContactsListItemOnClickListener ) {
        this.layout_id = layout_id;
        this.mCustomContactObjects=contacts;
        this.mContactsListItemOnClickListener=ContactsListItemOnClickListener;
    }

    public interface ContactsItemOnClickListener{
        void onContactsListItemClick(int position);
    }
    @Override
    public ContactsViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout_id, parent, false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ContactsViewHolder holder, int position) {
        TextView nameTextView = holder.ContactNameTextView;
        nameTextView.setText(mCustomContactObjects.get(position).getContactName());
        TextView designationTextView = holder.ContactDesignationTextView;
        designationTextView.setText(mCustomContactObjects.get(position).getContactDesignation());

        ImageButton callButtonView = holder.callButton;
        callButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ImageButton MainButtonView = holder.MailButton;
        MainButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mCustomContactObjects.size();
    }

    class ContactsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView ContactNameTextView,ContactDesignationTextView;
        ImageButton callButton,MailButton;
        public ContactsViewHolder( View itemView) {
            super(itemView);
            ContactNameTextView= itemView.findViewById(R.id.ContactNameTV);
            ContactDesignationTextView = itemView.findViewById(R.id.DesignationTV);
            callButton = itemView.findViewById(R.id.CallButton);
            MailButton= itemView.findViewById(R.id.MailButton);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
