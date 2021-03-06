package firstweek.vanbeeandr.litternark;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;

import android.widget.ImageButton;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static firstweek.vanbeeandr.litternark.R.id.mcdBtn;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    String mCurrentPhotoPath;
    static final int REQUEST_TAKE_PHOTO = 1;
    static int tracker = 6;
    public String[][] records = Scoreboard.initArray();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        records = Scoreboard.initArray();
        setUpSplash();

    }

    //all the code for splash screen in here
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

    //all the code for scoreboard layout in here
    private void setUpScoreboard() {
        setContentView(R.layout.scoreboard_layout);
        records = Scoreboard.reorderScores(records);
        Scoreboard.matchTable(records, this);
    }

    //current rule: when back is pressed always goes back to the splash screen
    @Override
    public void onBackPressed() {
        setUpSplash();
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

            companySelectActivity();
            tracker++;
            changeImage();

        }
//        dispatchSavePictureIntent();
    }


    private void companySelectActivity() {
        setContentView(R.layout.company_select);
        ImageButton mcdsBtn = (ImageButton) findViewById(mcdBtn);
        mcdsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.gallery_layout);
                records = Scoreboard.updateNark(records, "Mc Donalds");
            }
        });


    }

    private void changeImage() {

        ImageView imageToChange = (ImageView) findViewById(R.id.imageView7);

    }
//    private File createImageFile() throws IOException {
//        // Create an image file name
//        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//        String imageFileName = "JPEG_" + timeStamp + "_";
//        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//        File image = File.createTempFile(
//                imageFileName,  /* prefix */
//                ".jpg",         /* suffix */
//                storageDir      /* directory */
//        );
//
//        // Save a file: path for use with ACTION_VIEW intents
//        mCurrentPhotoPath = image.getAbsolutePath();
//        return image;
//
//    }
//
//
//
//    private void dispatchSavePictureIntent() {
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        // Ensure that there's a camera activity to handle the intent
//        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//            // Create the File where the photo should go
//            File photoFile = null;
//            try {
//                photoFile = createImageFile();
//            } catch (IOException ex) {
//                // Error occurred while creating the File
//
//            }
//            // Continue only if the File was successfully created
//            if (photoFile != null) {
//                Uri photoURI = FileProvider.getUriForFile(this,
//                        "com.example.android.fileprovider",
//                        photoFile);
//                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
//                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
//
//            }
//        }
//        galleryAddPic();
//
//    }
//
//    private void galleryAddPic() {
//        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
//        File f = new File(mCurrentPhotoPath);
//        Uri contentUri = Uri.fromFile(f);
//        mediaScanIntent.setData(contentUri);
//        this.sendBroadcast(mediaScanIntent);
//    }
}
