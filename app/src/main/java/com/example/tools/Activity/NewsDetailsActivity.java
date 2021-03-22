package com.example.tools.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tools.Adapter.CommentAdapter;
import com.example.tools.R;
import com.example.tools.Utils;
import com.example.tools.tools.Comments;
import com.example.tools.tools.Data;
import com.example.tools.tools.InputTextMsgDialog;
import com.google.gson.JsonObject;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import okhttp3.Response;

public class NewsDetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SmartRefreshLayout smartRefreshLayout;
    private CommentAdapter commentAdapter;
    private boolean like,collection;
    private Button btn_like,btn_collection;
    private int id;
    private String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTY1MDM3NzUsImlhdCI6MTYxNjQxNzM3NSwiaXNzIjoicnVhIiwiZGF0YSI6eyJ1c2VyaWQiOjR9fQ.TdSfxDGBzqCBNsEJFaj2n67YPq2zFyAepwxt25lX3pI";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_news_details);
        btn_like=findViewById(R.id.news_like);
        btn_collection=findViewById(R.id.news_collection);
        recyclerView=this.findViewById(R.id.details_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(NewsDetailsActivity.this));

        id = getIntent().getIntExtra("id", 0);
//        smartRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
//            @Override
//            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
//
//            }
//
//            @Override
//            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
//
//            }
//        });




        List<Comments> list = new ArrayList<>();
        GetData(list);




        //评论
        findViewById(R.id.edittext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final InputTextMsgDialog inputTextMsgDialog = new InputTextMsgDialog(NewsDetailsActivity.this, R.style.dialog_center);
                inputTextMsgDialog.setmOnTextSendListener(new InputTextMsgDialog.OnTextSendListener() {
                    @Override
                    public void onTextSend(String msg) {
                        //点击发送按钮后，回调此方法，msg为输入的值
                    }
                });
                inputTextMsgDialog.setMaxNumber(60);
                inputTextMsgDialog .show();
            }
        });
        //点赞
        btn_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (like){like=false;  btn_like.setBackgroundResource(R.drawable.like_nor);
                }else {like=true;  btn_like.setBackgroundResource(R.drawable.like_fill);}
            }
        });
        //收藏
        btn_collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (collection){collection=false;  btn_collection.setBackgroundResource(R.drawable.collection_nor);
                }else {collection=true;  btn_collection.setBackgroundResource(R.drawable.collection_fill);}
            }
        });
        //返回
        findViewById(R.id.news_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    public void GetData(final List<Comments> list){


            Utils.get_token("http://122.9.2.27/api/news/info/" + id + "/info-full", token, new Utils.OkhttpCallBack() {
                @Override
                public void onSuccess(Response response) {
                    try {
                        JSONObject jsonObject1=new JSONObject(Objects.requireNonNull(response.body()).string());
                        JSONObject jsonObject2=jsonObject1.getJSONObject("data");
                         Comments comments=new Comments();
                        comments.setTitle(jsonObject2.getString("title"));
                        comments.setContent(jsonObject2.getString( "content"));
                        comments.setTag(jsonObject2.getInt("tag"));
                        comments.setLike_num(jsonObject2.getInt("like_num"));
                        comments.setComment_num(jsonObject2.getInt( "comment_num"));
                        comments.setStar_num(jsonObject2.getInt( "star_num"));


                       // comments.setPics((List<String>) jsonObject2.get("pics"));//有问题



                        list.add(comments);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

        commentAdapter = new CommentAdapter(NewsDetailsActivity.this, list);
        recyclerView.setAdapter(commentAdapter);
                            }
                        });


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
                @Override
                public void onFail(String error) {

                }
            });


    }

}