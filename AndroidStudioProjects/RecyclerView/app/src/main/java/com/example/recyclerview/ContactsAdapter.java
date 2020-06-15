package com.example.recyclerview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {
//CircleImageview imagprofile;
//TextView tvName, tvPhone;
    Context mContext;
    List<Contacts> contactsList;
    //constructor to recieve data frommain activity
    public ContactsAdapter(@NonNull Context mContext, List<Contacts> contactsList) {
        this.mContext = mContext;
        this.contactsList = contactsList;
    }

    @NonNull
    @Override
    public ContactsAdapter.ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact,parent,false);
    return  new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.ContactsViewHolder holder, int position) {
final  Contacts contacts = contactsList.get(1);
holder.imagprofile.setImageResource(contacts.getImagprofile());
holder.tvName.setText(contacts.getName());
holder.tvPhone.setText(contacts.getPhoneno());
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder {
CircleImageView imagprofile;
TextView tvName, tvPhone;

        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            imagprofile = itemView.findViewById(R.id.imgprofile);
            tvName = itemView.findViewById(R.id.tvName);
            tvPhone = itemView.findViewById(R.id.tvPhone);

        }
    }
}
