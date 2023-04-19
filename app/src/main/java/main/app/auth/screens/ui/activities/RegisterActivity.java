package main.app.auth.screens.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;

import dagger.hilt.android.AndroidEntryPoint;
import main.app.MainActivity;

import main.app.auth.data.models.register.RegisterRequestModel;
import main.app.auth.screens.viewModels.RegisterViewModel;
import main.app.databinding.ActivityRegisterBinding;

@AndroidEntryPoint
public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initViews();
        implementListeners();
        initObservers();

    }

    private void initObservers() {
        registerViewModel.registerResponse.observe(this, userModel -> {
            Toast.makeText(RegisterActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void implementListeners() {
        binding.registerButton.setOnClickListener(v -> {
//            final String imageUrl =
            final String firstName = binding.firstName.getText().toString();
            final String lastName = binding.lastName.getText().toString();
            final String username = binding.username.getText().toString();
            final String email = binding.email.getText().toString();
            final String password = binding.password.getText().toString();
            final String confirmPassword = binding.confirmPassword.getText().toString();
            RegisterRequestModel registerRequestModel = new RegisterRequestModel(firstName, lastName, username, email, password, confirmPassword);
            registerViewModel.register(registerRequestModel);
        });


        binding.login.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void initViews() {
        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
    }

//    private String getProfileImageUrl(){
//
//Bitmap bitmap = null;
//try {
//    bitmap = MediaStore.Images.Media.getBitmap(getApplication().getContentResolver(), resulturi);
//} catch (IOException e) {
//    e.printStackTrace();
//    Toast.makeText(registerActivity.this, "Image upload failed", Toast.LENGTH_SHORT).show();
//    return;
//}
//
//// Compress the image and convert it to a byte array
//ByteArrayOutputStream baos = new ByteArrayOutputStream();
//bitmap.compress(Bitmap.CompressFormat.JPEG, 20, baos);
//byte[] imageData = baos.toByteArray();
//
//// Create a reference to the Firebase Storage location where the image will be uploaded
//FirebaseStorage storage = FirebaseStorage.getInstance();
//StorageReference storageRef = storage.getReference().child("profile_images").child(uid + ".jpg");
//
//// Upload the image to Firebase Storage
//UploadTask uploadTask = storageRef.putBytes(imageData);
//uploadTask.addOnCompleteListener(task -> {
//    if (task.isSuccessful()) {
//        // Get the download URL of the uploaded image
//        storageRef.getDownloadUrl().addOnCompleteListener(downloadUrlTask -> {
//            if (downloadUrlTask.isSuccessful()) {
//                Uri downloadUri = downloadUrlTask.getResult();
//                String imageUrl = downloadUri.toString();
//
//                // Update the user's profile image URL in the Firebase Realtime Database
//                DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("users").child(uid);
//                userRef.child("profileImage").setValue(imageUrl).addOnCompleteListener(updateTask -> {
//                    if (updateTask.isSuccessful()) {
//                        Toast.makeText(registerActivity.this, "Image added successfully", Toast.LENGTH_SHORT).show();
//                        finish();
//                    } else {
//                        Toast.makeText(registerActivity.this, "Failed to update profile image", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            } else {
//                Toast.makeText(registerActivity.this, "Failed to get download URL", Toast.LENGTH_SHORT).show();
//            }
//        });
//    } else {
//        Toast.makeText(registerActivity.this, "Image upload failed", Toast.LENGTH_SHORT).show();
//    }
//});
//
//
//    }
}