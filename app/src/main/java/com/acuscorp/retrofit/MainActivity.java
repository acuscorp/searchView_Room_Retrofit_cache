package com.acuscorp.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private JsonPlaceHolderApi jsonPlaceHolderApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.tv_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")       //! Do not forget to end with "/"
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        //getPost();
        //getComments();
        createPost();

    }

    private void createPost() {
        Post post = new Post(23,"New title", "new text");

        Map<String,String> fields = new HashMap<>();
        fields.put("userId", "25");
        fields.put("title","New Title");
//        Call<Post> call = jsonPlaceHolderApi.createPost(23,"New Title","New Text");
        Call<Post> call = jsonPlaceHolderApi.createPost(fields);  // se pasaron los valores
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                Post postResponse = response.body();

                    String content = "";
                    content += "Code: " + response.code() + "\n" ;
                    content += "ID: " + +postResponse.getId() + "\n" ;
                    content += "User ID: " + postResponse.getUserId() + "\n";
                    content += "Title: " + postResponse.getTitle() + "\n";
                    content += "Text: " + postResponse.getText() + "\n\n";
                    textViewResult.setText(content);


            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    private void getPost() {
        Map<String,String> parameters =  new HashMap<>();
        parameters.put("userId","1");
        parameters.put("_sort","id");
        parameters.put("_order","desc");


//        Call<List<Post>> call =  jsonPlaceHolderApi.getPost(new Integer[]{1,2,3},"id","desc");
        Call<List<Post>> call =  jsonPlaceHolderApi.getPost(parameters);

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                List<Post> posts = response.body();
                for(Post post : posts){
                    String content = "";
                    content+="ID: " + +post.getId() + "\n" ;
                    content+="User ID: " + post.getUserId() + "\n";
                    content+="Title: " + post.getTitle() + "\n";
                    content+="Text: " + post.getText() + "\n\n";
                    textViewResult.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                textViewResult.setText(t.getMessage());
            }
        });

    }
    private void getComments(){
//        Call<List<Comments>> call  =jsonPlaceHolderApi.getComments(3);
        Call<List<Comments>> call  =jsonPlaceHolderApi.getComments("post/3/comments");
        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                List<Comments> comments  = response.body();
                for(Comments comment: comments){
                    String content = "";
                    content+="ID: " + +comment.getId() + "\n" ;
                    content+="Post ID: " + comment.getPostId() + "\n";
                    content+="Name: " + comment.getName() + "\n";
                    content+="Name: " + comment.getName() + "\n";
                    content+="Email: " + comment.getEmail() + "\n";
                    content+="Text: " + comment.getText() + "\n\n";
                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }
}
