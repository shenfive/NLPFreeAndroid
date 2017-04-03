package idv.sjw.nlpfree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Dictionary;

public class TestingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);

        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION); //隱藏狀態


        if (true){ updateQustionList(); }// [issue]應先查看有無本地清單


    }

    protected void updateQustionList(){ //更新題目清單

        //[issue]應先檢查網路

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("data").child("zh-tw");

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Toast.makeText(TestingActivity.this,""+dataSnapshot.getChildrenCount(),Toast.LENGTH_LONG).show();
                for(DataSnapshot item:dataSnapshot.getChildren()){
                    Log.d("item","" + item.child("qustion").toString());

                };





            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        myRef.addListenerForSingleValueEvent(valueEventListener);



    }


}
