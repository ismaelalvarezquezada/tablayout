package jumpitt.com.fragmentstraining;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity implements BlankFragment.FragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void sendData(String message) {
        BlankFragment2 blankFragment2 = (BlankFragment2) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        blankFragment2.setText(message);
    }
}
