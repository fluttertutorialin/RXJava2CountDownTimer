package com.jdkgroup.rxjava2countdowntimer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import io.reactivex.disposables.Disposable;
import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.functions.BiFunction;

/**
 * Created by amitshekhar on 27/08/16.
 */
public class Flowable1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doSomeWork();
    }

    private void doSomeWork() {

        Flowable<Integer> observable = Flowable.just(1, 2, 3, 4);
        observable.reduce(50, (t1, t2) -> t1 + t2).subscribe(getObserver()); // SEED DEFAULT 50 + 10 = 60
    }

    private SingleObserver<Integer> getObserver() {

        return new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onSuccess(Integer value) {
                System.out.println("Tag " + value);
            }

            @Override
            public void onError(Throwable e) {
            }
        };
    }
}