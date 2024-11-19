package adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asd.R;
import com.example.asd.goods;

import java.util.List;



public class ListView1Adapter extends BaseAdapter {
    private List<goods> datas;
    private Context context;
    private LayoutInflater inflater;

    public ListView1Adapter(){

    }

    public ListView1Adapter(Context context, List<goods> datas) {
        this.context = context;
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);
    }

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
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_view1, parent, false);
            holder = new ViewHolder();
            holder.item_name = convertView.findViewById(R.id.item_name);
            holder.item_price=convertView.findViewById(R.id.item_price);
            holder.item_pic=convertView.findViewById(R.id.item_pic);

            convertView.setTag(holder); // 将ViewHolder实例设置为Tag
        } else {
            holder = (ViewHolder) convertView.getTag(); // 从Tag中获取ViewHolder实例
        }

      goods good=datas.get(position);
holder.item_name.setText(good.getName());
        holder.item_price.setText(good.getPrice());
        holder.item_pic.setImageResource(good.getIcon());
        return convertView;
    }

    class ViewHolder {
        TextView item_name;
        TextView item_price;
        ImageView item_pic;
    }

    public void remove(int position) {
        if (position >= 0 && position < datas.size()) {
            datas.remove(position);
            notifyDataSetChanged();
        } else {
            // 可以选择抛出异常，或者记录错误日志，或者什么都不做
            // 这里只是简单地打印一条错误信息
            Log.e("ListView1Adapter", "Invalid position for removal: " + position);
        }
    }
}
