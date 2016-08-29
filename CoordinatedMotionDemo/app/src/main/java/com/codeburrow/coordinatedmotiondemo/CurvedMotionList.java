package com.codeburrow.coordinatedmotiondemo;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CurvedMotionList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curved_motion_grid);

        RecyclerView list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new MessageAdapter(this));
        list.setHasFixedSize(true);
    }

    public class MessageAdapter extends RecyclerView.Adapter<MessageHolder> {

        private final int[] COLORS = new int[]{0xff956689, 0xff80678A, 0xff6A6788, 0xff546683, 0xff3F657B, 0xff3F657B};
        private Activity hostActivity;
        private final LayoutInflater inflater;

        public MessageAdapter(Activity activity) {
            hostActivity = activity;
            inflater = LayoutInflater.from(hostActivity);
        }

        @Override
        public MessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MessageHolder(inflater.inflate(R.layout.message, parent, false));
        }

        @Override
        public void onBindViewHolder(final MessageHolder holder, final int position) {
            final int color = COLORS[position % COLORS.length];
            holder.avatar.setBackgroundTintList(ColorStateList.valueOf(color));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(hostActivity, CurvedMotionDetails.class);
                    boolean curve = (position % 2 == 0);
                    intent.putExtra(CurvedMotionDetails.EXTRA_COLOR, color);
                    intent.putExtra(CurvedMotionDetails.EXTRA_CURVE, curve);
                    hostActivity.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(hostActivity, holder.avatar, holder.avatar.getTransitionName()).toBundle());
                }
            });
        }

        @Override
        public int getItemCount() {
            return 64;
        }
    }

    static class MessageHolder extends RecyclerView.ViewHolder {

        View avatar;
        View title;
        View subtitle;

        public MessageHolder(View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            title = itemView.findViewById(R.id.title);
            subtitle = itemView.findViewById(R.id.subtitle);
        }
    }
}
