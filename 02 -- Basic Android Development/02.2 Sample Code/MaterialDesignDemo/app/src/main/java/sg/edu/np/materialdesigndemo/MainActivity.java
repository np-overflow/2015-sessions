package sg.edu.np.materialdesigndemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button startFABActivityButton, startScrollingActivityButton, startTILActivityButton;
    private Button startChallengeActivityButton, startTabbedActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the View using the id (as defined in the layout)
        //and cast it to its type, which is Button.
        startFABActivityButton = (Button)findViewById(R.id.startFABActivity_Button);
        startScrollingActivityButton = (Button)findViewById(R.id.startScrollingActivity_Button);
        startTILActivityButton = (Button)findViewById(R.id.startTILActivity_Button);
        startChallengeActivityButton = (Button)findViewById(R.id.startChallengeActivity_Button);
        startTabbedActivityButton = (Button)findViewById(R.id.startTabbedActivity_Button);

        //Set OnClickListener for the Start FAB Activity button
        startFABActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FABActivity.class);
                startActivity(intent);
            }
        });

        startScrollingActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                startActivity(intent);
            }
        });

        startTILActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TILActivity.class);
                startActivity(intent);
            }
        });

        startChallengeActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChallengeActivity.class);
                startActivity(intent);
            }
        });

        startTabbedActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TabbedActivity.class);
                startActivity(intent);
            }
        });
    }
}
