package com.example.page;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.page.MasterPackage.ApiClient;
import com.example.page.MasterPackage.LoginService;
import com.example.page.MasterPackage.SignInRequest;
import com.example.page.MasterPackage.SignInResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity
{

    SignInRequest signInRequest;
    SignInResponse signInResponse;
    LoginService loginService;
    Retrofit retrofit;
    RecyclerView recyclerView;
    RecyclerView.Adapter cardAdapter;
    RecyclerView.LayoutManager cardLayoutManager;

    ArrayList <OrganizationCard> organizationCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInit();
        login();

        createCard();
        buildRecyclerView();


    }
    public void createCard(){
        organizationCards= new ArrayList<>();
        organizationCards.add(new OrganizationCard("WHO India",R.drawable.ic_launcher_foreground));
        organizationCards.add(new OrganizationCard("National Health portal of India",R.drawable.ic_launcher_foreground));
        organizationCards.add(new OrganizationCard("Public Health Foundation of India",R.drawable.ic_launcher_foreground));
        organizationCards.add(new OrganizationCard("Ministry of Health and Family Welfare",R.drawable.ic_launcher_foreground));
        organizationCards.add(new OrganizationCard("Indian Council of Medical Research",R.drawable.ic_launcher_foreground));
        organizationCards.add(new OrganizationCard("MSF India",R.drawable.ic_launcher_foreground));
        organizationCards.add(new OrganizationCard("UNICEF India",R.drawable.ic_launcher_foreground));
    }


    public void buildRecyclerView(){

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        cardLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
        recyclerView.setLayoutManager(cardLayoutManager);
        cardAdapter=new CardAdapter(organizationCards);
        recyclerView.setAdapter(cardAdapter);


    }

    private void login() {
        signInRequest = new SignInRequest("fahd.hazarika@brigosha.com","1234",true);
        Call<SignInResponse> call = loginService.signInApiCall(signInRequest);
        call.enqueue(new Callback<SignInResponse>() {
            @Override
            public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),response.code(),Toast.LENGTH_LONG).show();
                }
                signInResponse = response.body();
                Toast.makeText(getApplicationContext(),signInResponse.user.name,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<SignInResponse> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"error", Toast.LENGTH_LONG).show();

            }
        });
    }
    public void apiInit()
    {
        retrofit= ApiClient.getRetrofit();
        loginService=ApiClient.getLoginService();
    }
}