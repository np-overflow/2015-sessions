package co.undertide.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView displayTextView;
    private Button actionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayTextView = (TextView)findViewById(R.id.display_TextView);
        actionButton = (Button)findViewById(R.id.action_Button);

        final String[] array = {"Android", "Basket", "Chocolate", "Dishwasher", "Elephant"};

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                String chosen = array[r.nextInt(array.length)];

                displayTextView.setText(chosen);
            }
        });
    }
}
