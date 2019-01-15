package tk.zedlabs.android_me.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import tk.zedlabs.android_me.R;
import tk.zedlabs.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;


public class bodyFragment extends Fragment {

    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";

    public List<Integer> mImageIds;
    public int mListIndex;

    public bodyFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_body_image, container, false);

        final ImageView imageView = (ImageView)rootView.findViewById(R.id.body_image_view);

        if(mImageIds != null){
            //
            imageView.setImageResource(mImageIds.get(mListIndex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListIndex < mImageIds.size()-1){
                        mListIndex++;

                    }
                    else
                    {mListIndex = 0;}

                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });


        }
        else
            Log.v("bodyFragment","no list exists! or has been provided");

        return rootView;

    }

    public void setImageIds(List<Integer> imageIds){

        mImageIds = imageIds;
    }

    public void setListIndex(int listIndex){

        mListIndex = listIndex;
    }
    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);
    }
}
