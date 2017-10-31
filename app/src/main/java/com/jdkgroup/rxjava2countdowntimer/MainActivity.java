package com.jdkgroup.rxjava2countdowntimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private Rx2Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = Rx2Timer.builder()
                .initialDelay(0) //default is 0
                .period(1) //default is 1
                .take(30) //default is 60
                .unit(TimeUnit.SECONDS) // default is TimeUnit.SECONDS
                .onEmit(count -> {
                    if (count < 10) { // if < 10
                        System.out.println("0" + count + " s");
                    } else {
                        System.out.println(count + " s");
                    }
                })
                .onError(e -> System.out.println(""))
                .onComplete(() -> System.out.println("xxx"))
                .build();

        timer.start();
    }
}
