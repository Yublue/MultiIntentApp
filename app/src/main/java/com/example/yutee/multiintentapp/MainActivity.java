package com.example.yutee.multiintentapp;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.message_botton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber;
                String message;


                Intent send = new Intent();
                send.setAction(Intent.ACTION_SEND);
                send.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                send.setType("text/plain");
                startActivity(Intent.createChooser(send, getResources().getText(R.string.SEND_TO)));
                }


        });

        findViewById(R.id.map_botton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double latitude = 5.0151;
                double longitude = -7.9133;
                String label = "I'm Here!";
                String uriBegin = "geo:" + latitude + "," + longitude;
                String query = latitude + "," + longitude + "(" + label + ")";
                String encodedQuery = Uri.encode(query);
                String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                Uri uri = Uri.parse(uriString);
                Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                startActivity(mapIntent);
                }

        });

        findViewById(R.id.email_botton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent send = new Intent(Intent.ACTION_SEND);
                send.setType("text/html");
                send.putExtra(Intent.EXTRA_EMAIL, "emailaddress@emailaddress.com");
                send.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                send.putExtra(Intent.EXTRA_TEXT, "I'm email body.");

                startActivity(Intent.createChooser(send, "Send Email"));

            }
        });

        findViewById(R.id.video_botton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vid = new Intent();
                vid.setAction(Intent.ACTION_VIEW);
                vid.setData(Uri.parse("content://media/videos/media/"));
                startActivity(vid);
            }

        });

        findViewById(R.id.camara_botton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cam = new Intent();
                cam.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(cam);
            }
        });

        findViewById(R.id.image_botton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent img = new Intent();
                img.setAction(Intent.ACTION_VIEW);
                img.setData(Uri.parse("content://media/external/images/media/"));
                startActivity(img);
            }
        });
    }
}
