package kz.kbtu.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import kz.kbtu.informationcollector.InformationCollector;
import kz.kbtu.informationcollector.models.PhoneInfo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PhoneInfo phoneInfo = InformationCollector.getInfo(this);

        String json = InformationCollector.getInfo(this).toJson();

        Log.e("Locale", phoneInfo.toJson());
        Log.e("Locale", json);

    }
}
