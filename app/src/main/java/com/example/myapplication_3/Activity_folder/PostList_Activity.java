package com.example.myapplication_3.Activity_folder;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication_3.R;
import com.example.myapplication_3.Retrofit_instances;
import com.example.myapplication_3.VS_FastAPI;
import com.example.myapplication_3.models.Post_list;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PostList_Activity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_post_list);

        listView=(ListView)findViewById(R.id.post_listview);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Retrofit retrofit= Retrofit_instances.getRetrofitInstance();
        VS_FastAPI client=retrofit.create(VS_FastAPI.class);
        Call<List<Post_list>> call=client.get_all_postList();

        call.enqueue(new Callback<List<Post_list>>() {
            @Override
            public void onResponse(Call<List<Post_list>> call, Response<List<Post_list>> response)
            {
                ArrayList<String> xx=new ArrayList<>();

                if (response.body() != null){

                    ArrayList<Post_list>arrayList_post= (ArrayList<Post_list>) response.body();

                    for (Post_list post:arrayList_post) {xx.add(post.getTitle());}

                    ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_expandable_list_item_1,xx);

                    listView.setAdapter(adapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Toast.makeText(PostList_Activity.this, "ID:", Toast.LENGTH_SHORT).show();
                        }
                    });

                    Log.i("Response: ",response.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Post_list>> call, Throwable t) {
                Toast.makeText(PostList_Activity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            Log.w("Erroring: ",t);
            }
        });
    }
}