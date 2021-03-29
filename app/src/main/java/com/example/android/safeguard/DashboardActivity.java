package com.example.android.safeguard;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toolbar;

import com.example.android.safeguard.databinding.ActivityDashboardBinding;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

import de.hdodenhof.circleimageview.CircleImageView;

public class DashboardActivity extends AppCompatActivity {

    ActivityDashboardBinding binding;
    private CircleImageView profileImage;
    private static final int PICK_IMAGE =1;
    Uri profileImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        profileImage = findViewById(R.id.profileUser);
           profileImage.setOnClickListener(new View.OnClickListener() {
               @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
               @Override
               public void onClick(View v) {
                   Intent gallery = new Intent();
                   gallery.setType("image/*");
                   gallery.setAction(Intent.ACTION_GET_CONTENT);
                   startActivityForResult(Intent.createChooser(gallery , "choose your Profile Image"),PICK_IMAGE);
               }
           });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK){
            profileImageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver() , profileImageUri);
                profileImage.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void goToMaps(View view) {
        Intent intent = new Intent(DashboardActivity.this , Maps.class);
        startActivity(intent);
    }

    public void reportIncident(View view) {
        startActivity(new Intent(DashboardActivity.this , ReportIncident.class));
    }

    public void goToNews(View view) {
        startActivity(new Intent(DashboardActivity.this , NewsPortal.class));

    }

    public void goToSos(View view) {
        startActivity(new Intent(DashboardActivity.this , Sos.class));
    }

    public void goToGuidelines(View view) {
        startActivity(new Intent(DashboardActivity.this , Guidelines.class));
    }

    public void callToPolice(View view) {
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        phoneIntent.setData(Uri.parse("tel:112"));
        startActivity(phoneIntent);
    }

    public void gotToCloseGroup(View view) {
        startActivity(new Intent(DashboardActivity.this , CloseGroup.class));
    }
}