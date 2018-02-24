package com.ayush.midwayass;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapater extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_adapater);
    }

    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.CustomViewHolder> {

        private Context context;
        private ArrayList<Message> data;

        public ListAdapter(Context context, ArrayList<Message> data) {
            this.data = CameraActivity(eventName)
        }


        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view, parent, false);
            return new CustomViewHolder(view);
        }


        @Override
        public void onBindViewHolder(final CustomViewHolder holder, int position) {
            final Message socials = data.get(position);
            holder.msgView.setText(socials.name);

            //haven't taught this yet but essentially it runs separately from the UI
        }


        @Override
        public int getItemCount() {
            return data.size();
        }

        /**
         * A card displayed in the RecyclerView
         */
        class CustomViewHolder extends RecyclerView.ViewHolder {
            TextView msgView;
            ConstraintLayout card;

            public CustomViewHolder (View view) {
                super(view);
                this.msgView = (TextView) view.findViewById(R.id.msgView);
                this.card = (ConstraintLayout) view.findViewById(R.id.card);
            }

        }
        // Write some data with a timestamp
//    ref.push({
//        date: Firebase.ServerValue.TIMESTAMP;
//    });
//
//    // Later, retrieve the data by ordered date
//    ref.orderByChild('date').on('child_added', function(snapshot) {
//        //Do something with ordered children
//    });

    }
}
