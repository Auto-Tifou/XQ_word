package layout;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.xq.GroupActivity;
import com.example.administrator.xq.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fxFragment extends Fragment {
    private TextView yx,sys,kyk,gw,fj,Yy,pyq;


    public fxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fx, container, false);
        yx=(TextView)view.findViewById(R.id.youxi);
        sys=(TextView)view.findViewById(R.id.Sys);
        kyk=(TextView)view.findViewById(R.id.Kyk);
        gw=(TextView)view.findViewById(R.id.gouwu);
        fj=(TextView)view.findViewById(R.id.fujin);
        Yy=(TextView)view.findViewById(R.id.Yinyue);
        pyq = (TextView)view.findViewById(R.id.Pyq);

        pyq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),GroupActivity.class);
                startActivity(intent);
            }
        });
        //超链接
        yx.setMovementMethod(LinkMovementMethod.getInstance());
        sys.setMovementMethod(LinkMovementMethod.getInstance());
        kyk.setMovementMethod(LinkMovementMethod.getInstance());
        gw.setMovementMethod(LinkMovementMethod.getInstance());
        fj.setMovementMethod(LinkMovementMethod.getInstance());
        Yy.setMovementMethod(LinkMovementMethod.getInstance());
        return view;
    }
}
