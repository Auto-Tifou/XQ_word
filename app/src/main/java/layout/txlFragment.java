package layout;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.administrator.xq.R;
import com.example.administrator.xq.ZsgcActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class txlFragment extends Fragment {
    private TextView btn_add1,btn_find1,btn_delete1,btn_update1;
    private ListView lv2;
    private SimpleAdapter adapter;
    private List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
    private int[]imgPhoto1={R.mipmap.qq1,R.mipmap.qq2,R.mipmap.qq03,R.mipmap.qq04,
            R.mipmap.qq05, R.mipmap.qq06,R.mipmap.qq7,R.mipmap.qq08,R.mipmap.qq9,R.mipmap.qq10,
            R.mipmap.qq11,R.mipmap.qq12,R.mipmap.qq13,R.mipmap.qq14,R.mipmap.qq15,R.mipmap.qq16,
            R.mipmap.qq17};
    private String[]stName1={"古兜","过渡","离港","三穗","名螚","秋凉","孤","俗趣",
            "夏忧","瘾","阿明","豁","梦归所梦","梦净","忘川","任你","热钕"};

    public txlFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_txl, container, false);
        //控件
        btn_add1=(TextView)view.findViewById(R.id.Btn_add1);
        btn_find1=(TextView)view.findViewById(R.id.Btn_find1);
        btn_delete1=(TextView)view.findViewById(R.id.Btn_delete1);
        btn_update1=(TextView)view.findViewById(R.id.Btn_update1);
        lv2=(ListView)view.findViewById(R.id.Listview2);

        add();
        adapter = new SimpleAdapter(getActivity(), list, R.layout.lvitem2, new String[]{"photo", "name"}, new int[]{R.id.img_photo1, R.id.tv_name1,});
        lv2.setAdapter(adapter);
        lv2.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("删除提示");
                builder.setMessage("确认删除好友吗？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        list.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create().show();
                return true;
            }
        });
        btn_add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ZsgcActivity.class);
                startActivity(intent);
            }
        });
        btn_find1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ZsgcActivity.class);
                startActivity(intent);
            }
        });
        btn_delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ZsgcActivity.class);
                startActivity(intent);
            }
        });
        btn_update1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ZsgcActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
    private void add(){
        for (int i =0;i<stName1.length;i++){
            Map<String,Object>map=new HashMap<String,Object>();
            map.put("photo",imgPhoto1[i]);
            map.put("name",stName1[i]);
            list.add(map);
        }
    }
}
