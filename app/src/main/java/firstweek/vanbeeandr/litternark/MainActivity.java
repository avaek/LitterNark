package firstweek.vanbeeandr.litternark;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpSplash();

    }

    private void setUpSplash() {
        setContentView(R.layout.activity_main);
        Button upload = (Button) findViewById(R.id.takePic);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        Button scoreboard_redirect = (Button) findViewById(R.id.scoreboard_button_redirect);
        scoreboard_redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpScoreboard();
            }
        });
    }

    private void setUpScoreboard() {
        setContentView(R.layout.scoreboard_layout);
    }

    @Override
    public void onBackPressed() {
        setUpSplash();
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

}
