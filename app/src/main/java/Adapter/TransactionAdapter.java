package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketer.AllTransactionOverview;
import com.example.marketer.R;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.viewHolder> {

    private List<AllTransactionOverview> dataList;
    private Context context;

    public TransactionAdapter(Context context, List<AllTransactionOverview> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView tvAmount;
        TextView tvAmount1;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            tvAmount = itemView.findViewById(R.id.tvamount);
            tvAmount1 = itemView.findViewById(R.id.tvamount1);

        }
    }

    @NonNull
    @Override
    public TransactionAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_transaction_history, parent,false);
        return new TransactionAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.viewHolder holder, int position) {
        holder.tvAmount.setText(dataList.get(position).getAmount());
        holder.tvAmount1.setText(dataList.get(position).getAmount());
        if (dataList.get(position).getType().equalsIgnoreCase("in")){
            holder.tvAmount.setVisibility(View.VISIBLE);
            holder.tvAmount1.setVisibility(View.GONE);
        }
        else{
            holder.tvAmount.setVisibility(View.GONE);
            holder.tvAmount1.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
