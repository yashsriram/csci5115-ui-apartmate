package com.csci5115.group8;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class EditYourProfileActivity extends AppCompatActivity {

    String firstName, lastName, city, college;
    int age;

    //private static final int RESULT_LOAD_IMAGE;
    EditText firstNameInput, lastNameInput, ageInput, cityInput, collegeInput;
    Button submit;
    ImageView imageToUpload;
    Button uploadImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_your_profile);

        firstNameInput = findViewById(R.id.firstNameInput);
        lastNameInput = findViewById(R.id.surnameInput);
        ageInput = findViewById(R.id.ageInput);
        cityInput = findViewById(R.id.cityInput);
        collegeInput = findViewById(R.id.collegeInput);

        imageToUpload = findViewById(R.id.imageToUpload);
        uploadImage = findViewById(R.id.uploadImage);

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstName = firstNameInput.getText().toString();
                lastName = lastNameInput.getText().toString();
                age = Integer.valueOf(ageInput.getText().toString());
                city = cityInput.getText().toString();
                college = collegeInput.getText().toString();
                /*
                switch (v.getId()) {
                    case R.id.imageToUpload:
                        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
                        break;
                    case R.id.uploadImage:
                        Bitmap image = ((BitmapDrawable) imageToUpload.getDrawable()).getBitmap();
                        new UploadImage(image).execute();
                        break;
                }
               */
            }

        });

        /*
        private void showToast (String text){
            Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
        }

        protected void onActivityResult ( int requestCode, int resultCode, Intent data){

            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null) {
                Uri selectedImage = data.getData();
                imageToUpload.setImageURI(selectedImage);
            }

        }

        public class UploadImage extends AsyncTask<Void, Void, Void> {
            Bitmap image;

            public UploadImage(Bitmap image) {
                this.image = image;
            }

            @Override
            protected Void doInBackground(Void... voids) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                image.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                String encodedImage = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(getApplicationContext(), "Image Uploaded", Toast.LENGTH_SHORT).show();
            }

        }
        */


    }
}
