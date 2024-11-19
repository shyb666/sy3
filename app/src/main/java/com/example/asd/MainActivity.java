package com.example.asd;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import adapter.ListView1Adapter;


public class MainActivity extends AppCompatActivity {

    private ListView list_view;
    private ListView1Adapter listView1Adapter;
    //使用ArrayList定义数据
    private List<goods> datas = new ArrayList<goods>();
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_ltem);


        initDate();

        list_view=findViewById(R.id.list_view);
        ListViewAdapter listViewAdapter=new ListViewAdapter();
        list_view.setAdapter(listViewAdapter);
        list_view.setOnItemClickListener((parent, view, position, id) -> {
            goods item = datas.get(position);
            String title = (String) item.getName();
            // String imageUrl = (String) item.get("image"); // 如果需要图片URL也可以获取

            // 显示Toast
            Toast.makeText(this, "选中的标题: " + title, Toast.LENGTH_SHORT).show();
        });
    }

    private void initDate(){
        datas=new ArrayList<goods>();
        datas.add(new goods("Lion","1",R.drawable.lion));
        datas.add(new goods("Tiger","2",R.drawable.tiger));
        datas.add(new goods("Monkey","3",R.drawable.monkey));
        datas.add(new goods("Dog","4",R.drawable.dog));
        datas.add(new goods("Cat","5",R.drawable.cat));
        datas.add(new goods("Elephont","6",R.drawable.elephant));
    }
    //
    class ListViewAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            // 通常使用position作为ID，但这里返回的是long类型，所以直接返回即可
            // 如果数据集中有唯一标识符，应该使用该标识符
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MyViewHolder viewholder;
            if (convertView == null) {
                convertView = View.inflate(MainActivity.this, R.layout.adapter_view1, null);
                viewholder = new MyViewHolder();
                viewholder.item_name = convertView.findViewById(R.id.item_name);
                viewholder.item_price=convertView.findViewById(R.id.item_price);
                viewholder.item_pic=convertView.findViewById(R.id.item_pic);

                convertView.setTag(viewholder); // 将ViewHolder实例设置为Tag
            } else {
                viewholder = (MyViewHolder) convertView.getTag(); // 从Tag中获取ViewHolder实例
            }

            goods good=datas.get(position);
            viewholder.item_name.setText(good.getName());
            viewholder.item_price.setText(good.getPrice());
            viewholder.item_pic.setImageResource(good.getIcon());
            return convertView;
        }

        class MyViewHolder {
            TextView item_name;
            TextView item_price;
            ImageView item_pic;
        }
    }




}