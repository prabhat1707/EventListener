package com.trenzlr.eventlistenersample;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.trenzlr.eventlistener.DataWrapper;
import com.trenzlr.eventlistener.EventListener;
import com.trenzlr.eventlistener.Updatable;

public class MainActivity extends AppCompatActivity implements Updatable<DataWrapper<ModelClass>> {
    TextView text;
    Button opnFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        opnFragment = findViewById(R.id.opnFragment);
        opnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.parentPanel, BlankFragment.newInstance(), BlankFragment.class.getName());
                transaction.addToBackStack("1");
                transaction.commit();
            }
        });
    }

    @Override
    public void EventListenerCallback(DataWrapper<ModelClass> objectDataWrapper) {
        Toast.makeText(this, objectDataWrapper.getTag(), Toast.LENGTH_SHORT).show();
        text.setText(objectDataWrapper.getObject().getTest());
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventListener.getInstance().registerListener(this);
    }

    @Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStack();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventListener.getInstance().unregisterListener(this);
    }
}
