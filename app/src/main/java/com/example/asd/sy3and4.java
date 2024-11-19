package com.example.asd;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import adapter.ListView1Adapter;

public class sy3and4 extends AppCompatActivity implements AbsListView.OnItemLongClickListener, ActionMode.Callback {
    private ActionMode actionMode;
    private ListView list_view;
    private ListView1Adapter listView1Adapter;
    private int selectedPosition=-1;
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
        datas.add(new goods("Liontest","1",R.drawable.lion));
        datas.add(new goods("Tiger","2",R.drawable.tiger));
        datas.add(new goods("Monkey","3",R.drawable.monkey));
        datas.add(new goods("Dog","4",R.drawable.dog));
        datas.add(new goods("Cat","5",R.drawable.cat));
        datas.add(new goods("Elephont","6",R.drawable.elephant));
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        // 创建上下文菜单
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.dele) {
            // 处理删除操作
            listView1Adapter.remove(1);
            listView1Adapter.notifyDataSetChanged();
            // 注意：您需要跟踪当前选中的项的位置，这里省略了这部分逻辑
            mode.finish(); // 完成ActionMode
            return true;
        }
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        actionMode = null;
        // 清除选中状态等清理工作...
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        if (actionMode != null) {
            return false;
        }
        selectedPosition = position;
        actionMode = startActionMode(this);
        view.setSelected(true);
        return true;
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
                convertView = View.inflate(sy3and4.this, R.layout.adapter_view1, null);
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