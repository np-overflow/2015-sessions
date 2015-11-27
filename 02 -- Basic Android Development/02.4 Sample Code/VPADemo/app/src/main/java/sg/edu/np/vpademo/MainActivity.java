package sg.edu.np.vpademo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private View test;
    private TextView testt;
    private Button launch;

    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test = findViewById(R.id.test_View);
        testt = (TextView)findViewById(R.id.test_TextView);
        launch = (Button)findViewById(R.id.launch_Button);

        //ViewPropertyAnimator
        test.animate().rotation(90000f).setDuration(10000).start();

        //ObjectAnimator
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 1f, 1.5f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 1f, 1.5f);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(test, scaleX, scaleY);
        objectAnimator.setDuration(2000);
        objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        objectAnimator.start();

        //ValueAnimator
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1f, 1.5f);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                test.setScaleX((float)valueAnimator.getAnimatedValue());
                test.setScaleY((float)valueAnimator.getAnimatedValue());
            }
        });
        valueAnimator.setDuration(2000);
        valueAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        valueAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        valueAnimator.start();

        //res > anim
        Animation animXML = AnimationUtils.loadAnimation(this, R.anim.scale);
        test.startAnimation(animXML);

        //res > animator
        Animator anim = AnimatorInflater.loadAnimator(this, R.animator.scale);
        anim.setTarget(test);
        anim.start();

        //OkHttp demo
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final String resp = MainActivity.this.run("http://www.google.com");
                    //Run on UI thread
                    testt.post(new Runnable() {
                        @Override
                        public void run() {
                            testt.setText(resp);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OtherActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.other_activity_enter, R.anim.main_activity_exit);
            }
        });
    }
}
