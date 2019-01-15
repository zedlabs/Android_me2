package tk.zedlabs.android_me.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tk.zedlabs.android_me.R;
import tk.zedlabs.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        if (savedInstanceState == null) {


            bodyFragment headfragment = new bodyFragment();
            bodyFragment bodyfragment = new bodyFragment();
            bodyFragment legsfragment = new bodyFragment();

            bodyfragment.setImageIds(AndroidImageAssets.getBodies());

            headfragment.setImageIds(AndroidImageAssets.getHeads());

            legsfragment.setImageIds(AndroidImageAssets.getLegs());

            int headIndex = getIntent().getIntExtra("headIndex",0);
            headfragment.setListIndex(headIndex);
            int bodyIndex = getIntent().getIntExtra("bodyIndex", 0);
            bodyfragment.setListIndex(bodyIndex);
            int legIndex = getIntent().getIntExtra("legIndex", 0);
            legsfragment.setListIndex(legIndex);

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headfragment)
                    .commit();
            fragmentManager.beginTransaction()
                    .add(R.id.body_container, bodyfragment)
                    .commit();
            fragmentManager.beginTransaction()
                    .add(R.id.legs_container, legsfragment)
                    .commit();
        }
    }
}