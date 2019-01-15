package tk.zedlabs.android_me.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.GridView;
import tk.zedlabs.android_me.R;
import tk.zedlabs.android_me.data.AndroidImageAssets;

import java.util.List;


public class MasterListFragment extends Fragment {

    List<Integer> imageIds = AndroidImageAssets.getAll();

    OnImageClickListener mCallback;

    public interface OnImageClickListener{
        void onImageSelected(int position);

    }

// to make sure that the activity that is generating thd fragmentmust contain th required function which
//talks to it

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mCallback = (OnImageClickListener) context;

        }
        catch(ClassCastException e){
            throw new ClassCastException(context.toString()
            + "must implement onimagelistener");
        }


    }

    public MasterListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        MasterListAdapter mla = new MasterListAdapter(getContext(),imageIds);

        GridView gridView =(GridView) rootView.findViewById(R.id.images_grid_view);

        gridView.setAdapter(mla);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCallback.onImageSelected(position);
            }
        });

        return rootView;
    }
}