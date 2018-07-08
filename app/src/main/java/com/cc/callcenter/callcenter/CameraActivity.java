package com.cc.callcenter.callcenter;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.InputStream;

public class CameraActivity extends AppCompatActivity {

    Button btnCamera;
    ImageView cameraImg;
    Uri outputImgUri;
    String pictureSaveFolderPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        btnCamera = (Button) findViewById(R.id.camera_btn_camera);
        cameraImg = (ImageView) findViewById(R.id.camera_img);

        pictureSaveFolderPath = getExternalCacheDir().getPath();

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String imageFileName = "outputImage_" + System.currentTimeMillis() + ".png";
                    File outputImageFile = new File(pictureSaveFolderPath, imageFileName);
                    if (outputImageFile.exists()) {
                        outputImageFile.delete();
                    }
                    outputImageFile.createNewFile();
                    outputImgUri = getImageFileUriByOsVersion(outputImageFile);
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputImgUri);
                    startActivityForResult(cameraIntent, 1);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private Uri getImageFileUriByOsVersion(File file) {
        Uri ret = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Context ctx = getApplicationContext();
            ret = FileProvider.getUriForFile(ctx, "com.cc.callcenter.fileprovider", file);
        } else {
            ret = Uri.fromFile(file);
        }
        return ret;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            if (requestCode == 1) {
                if (resultCode == RESULT_OK) {
                    ContentResolver contentResolver = getContentResolver();
                    InputStream inputStream = contentResolver.openInputStream(outputImgUri);
                    Bitmap pictureBitmap = BitmapFactory.decodeStream(inputStream);
                    cameraImg.setImageBitmap(pictureBitmap);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
