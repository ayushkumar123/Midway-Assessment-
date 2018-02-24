package com.ayush.midwayass;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;

//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;
//import com.google.firebase.storage.UploadTask;

public class CameraActivity extends AppCompatActivity {


//    private StorageReference mStorageRef;
//    FirebaseDatabase database = FirebaseDatabase.getInstance();
//    private static FirebaseAuth mAuth;
//    private static FirebaseUser mUser;
//
//    public String eventName;
//    DatabaseReference myRef = database.getReference("socials");

    private Intent data;
    public String eventName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
//        mStorageRef = FirebaseStorage.getInstance().getReference();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                checkName();
//                if (checkName()) {
//                    final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
//
//
//                    //Question 3: generate a key below to use as a unique identifier for the message, and
//                    // for the image filename
//                    final String key = ref.child("socials").push().getKey();
//                    final StorageReference storageRef = FirebaseStorage.getInstance().getReferenceFromUrl("gs://mdbsocials-10f4e.appspot.com");
//                    StorageReference riversRef = storageRef.child(key + ".png");
//
//
//                    //Question 4: create a StorageReference below (hint: the url you need can be found in
//                    // your console at firebase.google.com
//                    riversRef.putFile(data.getData()).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(NewMessageActivity.this, "Failure", Toast.LENGTH_SHORT).show();
//                        }
//                    }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            Message social = new Message(eventName, mUser.getEmail(), taskSnapshot.getDownloadUrl().toString());
//                            ref.child("socials").child(key).setValue(social);
//                        }
//                    });
//
//                    startActivity(new Intent(NewMessageActivity.this, ListActivity.class));
//                }

            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
                Button submitbutton=(Button)findViewById(R.id.button);
                submitbutton.setVisibility(View.VISIBLE);
                Button backbutton=(Button)findViewById(R.id.button2);
                backbutton.setVisibility(View.VISIBLE);
                TextView caption=(TextView) findViewById(R.id.nametext);
                caption.setVisibility(View.VISIBLE);

            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
                intent.setType("image/*");
                Button submitbutton=(Button)findViewById(R.id.button);
                submitbutton.setVisibility(View.VISIBLE);
                Button backbutton=(Button)findViewById(R.id.button2);
                backbutton.setVisibility(View.VISIBLE);
                TextView caption=(TextView) findViewById(R.id.nametext);
                caption.setVisibility(View.VISIBLE);

            }
        });


        //mAuth = FirebaseAuth.getInstance();
        //mUser = mAuth.getCurrentUser();
        // final Button backbutton = findViewById(R.id.button2);
        //backbutton.setOnClickListener(new View.OnClickListener() {
        //   @Override
        //    public void onClick(View v) {
        // startActivity(new Intent(NewMessageActivity.this, ListActivity.class));
        //  }
        //});
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CameraActivity.this, ListActivity.class))
                ;
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CameraActivity.this, ListActivity.class).putExtra("Caption", eventName))
                ;

            }
        });
    }

    private boolean checkName() {
        EditText nameText = findViewById(R.id.nametext);
        if (nameText.getText() == null || nameText.getText().toString().length() == 0) {
            nameText.setError("Please enter caption!");
            return false;
        } else {
            eventName = nameText.getText().toString();
            return true;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                ((ImageView) findViewById(R.id.imageView)).setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.data = data;
        }


    }
}
