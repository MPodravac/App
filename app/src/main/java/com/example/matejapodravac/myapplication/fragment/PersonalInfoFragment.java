package com.example.matejapodravac.myapplication.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.matejapodravac.myapplication.R;
import com.example.matejapodravac.myapplication.listeners.PersonalInfoListener;

public class PersonalInfoFragment extends Fragment {

    private static final String EXTRA_IMAGE_ID = "EXTRA_IMAGE_ID";
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    public static PersonalInfoFragment newInstance(){

        Bundle extras = new Bundle();
        PersonalInfoFragment fragment = new PersonalInfoFragment();
        fragment.setArguments(extras);

        return fragment;
    }

    EditText etName;
    EditText etLastName;
    EditText etBirthDate;
    ImageView imageView;
    public PersonalInfoListener personalInfoListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_personal_info, container, false);
        imageView = inflatedView.findViewById(R.id.imageView);
        imageView.setOnClickListener(onCameraButtonClickListener);

        etName = inflatedView.findViewById(R.id.etName);
        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (personalInfoListener != null) {
                    personalInfoListener.setName(s.toString());
                }
            }
        });
        etLastName = inflatedView.findViewById(R.id.etLastName);
        etLastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (personalInfoListener != null) {
                    personalInfoListener.setLastName(editable.toString());
                }
            }
        });
        etBirthDate = inflatedView.findViewById(R.id.etBirthDate);
        etBirthDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (personalInfoListener != null) {
                    personalInfoListener.setBirthDate(editable.toString());
                }
            }
        });
        return inflatedView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        personalInfoListener = null;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK){
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            setupImageView(imageBitmap);
        }
    }

    private void setupImageView(int drawableId){
        imageView.setImageResource(drawableId);
    }

    private void setupImageView(Bitmap bitmap){
        imageView.setImageBitmap(bitmap);
    }

    View.OnClickListener onCameraButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE); }
        }
    };

}
