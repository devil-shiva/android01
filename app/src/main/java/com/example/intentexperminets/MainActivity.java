package com.example.intentexperminets;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button sendMailButton;
    ImageView imageView;

    ActivityResultLauncher<String> getImage = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    Log.i("TAG", "onActivityResult: "+ result);
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendMailButton = findViewById(R.id.sendEmailButton);

        sendMailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getImage.launch("image/*");
//                Intent sendMailIntent = new Intent(Intent.ACTION_SEND);
//
//                sendMailIntent.setType("application/image");
//                sendMailIntent.putExtra(Intent.EXTRA_EMAIL , new String[]{"vikramrathorepubg@gmail.com"});
//                sendMailIntent.putExtra(Intent.EXTRA_SUBJECT , "Hey This is The Redirected mail");
//                sendMailIntent.putExtra(Intent.EXTRA_TEXT, "Hey this is redirected to mail msg");
//
//                Intent chooser = Intent.createChooser(sendMailIntent, "Send Email");
//                try {
//                    startActivity(chooser);
//                }catch (ActivityNotFoundException e){
//                    Toast.makeText(getApplicationContext(), "No App found To send mail", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }
}