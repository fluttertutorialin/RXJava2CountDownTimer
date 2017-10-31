package com.jdkgroup.rxjava2countdowntimer;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class TimeDisplayActivity extends AppCompatActivity {

    private Disposable disposable;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        disposable = Flowable.interval(1000L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread())
               .subscribe(aLong -> {
                    updateTimeView();
                });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void updateTimeView() {
        LocalDateTime current = LocalDateTime.now();
        StringBuffer str = new StringBuffer();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            str.append(current.getHour() + " : " + current.getMinute() + " : " + current.getSecond());
        }
       System.out.println("Tag " + str.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
