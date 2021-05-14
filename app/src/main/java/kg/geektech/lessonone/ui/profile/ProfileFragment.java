package kg.geektech.lessonone.ui.profile;

import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import kg.geektech.lessonone.R;


public class ProfileFragment extends Fragment {

    private ImageView imageView;
    private ActivityResultLauncher<String> mGetContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View  view=inflater.inflate(R.layout.fragment_profile, container, false);
         imageView = view.findViewById(R.id.image_view);

         getImage();
        return view;
    }


private void openGallery() {
    mGetContent.launch("image/*");
}
    private void getImage() {
        imageView.setOnClickListener(v ->
                ProfileFragment.this.openGallery());
        mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
                imageView::setImageURI);
    }


}