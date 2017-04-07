package idv.sjw.nlpfree;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

//        getSupportActionBar().hide(); //隱藏標題
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION); //隱藏狀態
    }

    public void startTest(View v){
        Intent intent = new Intent(this,TestingActivity.class);
        startActivity(intent);
    }

    public void goInfo(View v){
        Intent intent = new Intent(this,InforActivity.class);
        startActivity(intent);

    }
}
