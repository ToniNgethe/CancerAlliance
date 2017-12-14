package app.feed.mercyapp.adapters;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import app.feed.mercyapp.R;
import app.feed.mercyapp.models.responses.EventsListResponse;
import butterknife.BindView;
import butterknife.ButterKnife;


public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsViewHolder> {

    private Context ctx;
    private List<EventsListResponse> list;
    protected int lastPosition = -1;

    public EventsAdapter(Context ctx, List<EventsListResponse> body) {
        this.ctx = ctx;
        this.list = body;
    }

    @Override
    public EventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EventsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_events, null));
    }

    @Override
    public void onBindViewHolder(EventsViewHolder holder, int position) {

        Animation animation = AnimationUtils.loadAnimation(ctx, (position > lastPosition) ?
                R.anim.up_from_bottom : R.anim.down_from_top);
        holder.itemView.startAnimation(animation);

        EventsListResponse response = list.get(position);

        holder.setImage(ctx, response.getEventImage());
        holder.eventDate.setText(response.getEventTime());
        holder.eventDesc.setText(response.getEventDescription());
        holder.eventTitle.setText(response.getEventTittle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class EventsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.event_poster)
        ImageView eventPoster;
        @BindView(R.id.event_date)
        TextView eventDate;
        @BindView(R.id.event_title)
        TextView eventTitle;
        @BindView(R.id.event_desc)
        TextView eventDesc;

        private View mView;

        public EventsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.mView = itemView;

        }

        void setImage(final Context ctx, final String url) {
            final ImageView iv = mView.findViewById(R.id.event_poster);
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    Glide
                            .with(ctx)
                            .load(url)
                            .diskCacheStrategy(DiskCacheStrategy.ALL)   // cache both original & resized image
                            .crossFade()
                            .into(iv);
                }
            });

        }
    }
}
