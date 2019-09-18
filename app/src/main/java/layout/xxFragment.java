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

import com.example.administrator.xq.LtkActivity;
import com.example.administrator.xq.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class xxFragment extends Fragment {
    private ListView lv1;
    private SimpleAdapter adapter;
    private List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
    private int[]imgPhoto={R.mipmap.qq1, R.mipmap.qq2,R.mipmap.qq03,R.mipmap.qq04,
            R.mipmap.qq05,R.mipmap.qq06,R.mipmap.qq7,R.mipmap.qq08,R.mipmap.qq9,R.mipmap.qq10,
            R.mipmap.qq11,R.mipmap.qq12,R.mipmap.qq13,R.mipmap.qq14,R.mipmap.qq15,R.mipmap.qq16,
            R.mipmap.qq17};
    private String[]stName={"古兜","过渡","离港","三穗","名螚","秋凉","孤","俗趣",
            "夏忧","瘾","阿明","豁","梦归所梦","梦净","忘川","任你","热钕"};
    private String[]stInfo={"吃好饭了吗，快点来打王者。","你今天有事吗？",
            "来打王者啊，甜蜜双排，我带飞你。","我们29放假，你呢？","我们放假好晚啊，你们都回去了。",
            "有时间去我那里玩啊，我带你去种田。", "你在哪里啊，我在老食堂，快过来。",
            "待会去吃鸡公煲吗，特辣的那种哟。","希望明天下雨，体育课就不用上了。",
            "现在有啥电影好看的啊，推荐推荐。","待会去拿快递吗？",
            "现在好晚啊，喝口水压压惊。","滴滴","宜春明月山比庐山好玩多了。",
            "又是搬砖的一天。","好好学习天天向上。","你那里好热啊。"};

    public xxFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_xx, container, false);
        lv1=(ListView)view.findViewById(R.id.Listview);
        add();
        adapter = new SimpleAdapter(getActivity(),list, R.layout.lvitem, new String[]{"photo", "name",
                "info"}, new int[]{R.id.img_photo, R.id.tv_name, R.id.tv_info});
        lv1.setAdapter(adapter);
        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("删除提示");
                builder.setMessage("确认删除吗？");
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
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent it = new Intent(getActivity(), LtkActivity.class);
                it.putExtra("n",position);
                startActivity(it);
            }
        });

        return view;
    }
    private void add(){
        for (int i =0;i<stName.length;i++){
            Map<String,Object>map=new HashMap<String,Object>();
            map.put("photo",imgPhoto[i]);
            map.put("name",stName[i]);
            map.put("info",stInfo[i]);
            list.add(map);
        }
    }
}
