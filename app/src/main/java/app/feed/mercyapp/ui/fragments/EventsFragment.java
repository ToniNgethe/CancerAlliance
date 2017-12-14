package app.feed.mercyapp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import app.feed.mercyapp.R;
import app.feed.mercyapp.adapters.EventsAdapter;
import app.feed.mercyapp.connection.ApiClient;
import app.feed.mercyapp.connection.Apinterface;
import app.feed.mercyapp.connection.ErrorUtils;
import app.feed.mercyapp.models.responses.EventsListResponse;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EventsFragment extends Fragment {
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        unbinder = ButterKnife.bind(this, view);

        setUpRv();
        swipeListener();
        getData();

        return view;
    }

    private void swipeListener() {
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });
    }

    private void getData() {

        swipe.setRefreshing(true);

        Apinterface apinterface = ApiClient.getClient().create(Apinterface.class);
        Call<List<EventsListResponse>> call = apinterface.getAllEvents();
        call.enqueue(new Callback<List<EventsListResponse>>() {
            @Override
            public void onResponse(Call<List<EventsListResponse>> call, Response<List<EventsListResponse>> response) {

                swipe.setRefreshing(false);
                if (response.code() == 200){

                    EventsAdapter eventsAdapter = new EventsAdapter(getActivity(), response.body());
                    rv.setAdapter(eventsAdapter);
                    eventsAdapter.notifyDataSetChanged();

                }else {
                    Toast.makeText(getActivity(), "Something went wrong!", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<EventsListResponse>> call, Throwable t) {
                swipe.setRefreshing(false);
                Toast.makeText(getActivity(), new ErrorUtils().parseOnFailure(t), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setUpRv(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(linearLayoutManager);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
