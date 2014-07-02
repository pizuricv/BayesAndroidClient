package waylay.rest;

import java.util.List;

import retrofit.Callback;
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import waylay.client.scenario.Task;

public interface WaylayRestApi {

    @GET("/tasks")
    void listTasks(Callback<List<Task>> cb);

    // TODO add support for filters?
    @GET("/tasks/{taskId}")
    void getTask(@Path("taskId") Long taskId, Callback<Task> cb);

    @DELETE("/tasks/{taskId}")
    void deleteTask(@Path("v") Long taskId, Callback<Void> cb);

    @POST("/tasks/{taskId}")
    @FormUrlEncoded
    void performTaskAction(@Path("taskId") Long taskId, @Field("action") String action, Callback<Void> cb);

    @POST("/tasks/{taskId}")
    @FormUrlEncoded
    void setTaskProperty(
            @Path("taskId") Long taskId,
            @Field("runtime_property") String property,
            @Field("value") String value,
            Callback<Void> cb);

    @POST("/tasks/{taskId}/nodes/{node}")
    @FormUrlEncoded
    void setTaskNodeProperty(
            @Path("taskId") Long taskId,
            @Path("node") String node,
            @Field("runtime_property") String property,
            @Field("value") String value,
            Callback<Void> cb);

}