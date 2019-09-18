package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.xq.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class wFragment extends Fragment {
    private ImageView imageList;
    public wFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view =  inflater.inflate(R.layout.fragment_w, container, false);
        imageList = (ImageView)view.findViewById(R.id.imagelist);
        imageList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageList.setImageResource(R.mipmap.qq2);
            }
        });
         return view;
    }


}
