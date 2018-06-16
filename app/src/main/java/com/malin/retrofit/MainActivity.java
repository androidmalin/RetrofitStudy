package com.malin.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == null) return;
        int id = v.getId();
        switch (id) {
            case R.id.btn: {
                init();
                break;
            }
        }
    }

    private void init() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        //步骤3：在MainActivity创建接口类实例
        AccessApi NetService = retrofit.create(AccessApi.class);

        //步骤4：对发送请求的url进行封装，即生成最终的网络请求对象
        Call<JavaBean> call = NetService.getCall();

        call.enqueue(new Callback<JavaBean>() {
            @Override
            public void onResponse(Call<JavaBean> call, Response<JavaBean> response) {

            }

            @Override
            public void onFailure(Call<JavaBean> call, Throwable t) {

            }
        });

    }
}
