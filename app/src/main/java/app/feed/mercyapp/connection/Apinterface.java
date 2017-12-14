package app.feed.mercyapp.connection;

import java.util.List;

import app.feed.mercyapp.models.requests.EventRequest;
import app.feed.mercyapp.models.requests.FeedUploadRequest;
import app.feed.mercyapp.models.responses.EventResponse;
import app.feed.mercyapp.models.responses.EventsListResponse;
import app.feed.mercyapp.models.responses.FeedResponse;
import app.feed.mercyapp.models.responses.FeedUploadResponse;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


/**
 * Created by toni on 9/20/17.
 */

public interface Apinterface {
 //   http://197.232.17.86:81/CancerAllianceUpdate/
    @POST("CancerAlliance/saveDetails")
    Call<FeedUploadResponse> save_feed(@Body FeedUploadRequest feedUploadRequest);

    @GET("CancerAlliance/ViewData")
    Call<List<FeedResponse>> getFeed();

    @POST("CancerAllianceUpdate/saveEvent")
    Call<EventResponse> saveEvent(@Body EventRequest eventRequest);

    @GET("CancerAllianceUpdate/ViewEvent")
    Call<List<EventsListResponse>> getAllEvents();
}
