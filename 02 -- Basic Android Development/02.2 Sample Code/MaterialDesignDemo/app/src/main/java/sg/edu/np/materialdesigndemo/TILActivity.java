package sg.edu.np.materialdesigndemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

/**
 * This Activity demonstrates using the TextInputLayout wrapper to wrap
 * EditText to give them a Material Design look and feel.
 */

public class TILActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_til);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Handle when the back button on the Toolbar is clicked
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
