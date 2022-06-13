package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketer.FarmerOverview;
import com.example.marketer.R;

import java.util.List;

public class FarmerAdapter extends RecyclerView.Adapter<FarmerAdapter.viewHolder>{

    private List<FarmerOverview> dataList;
    private Context context;

    public FarmerAdapter(Context context, List<FarmerOverview> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView farmerName,farmerEmail, farmerWalletBalance;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            farmerName = itemView.findViewById(R.id.farmerName);
            farmerEmail = itemView.findViewById(R.id.farmerEmail);
            farmerWalletBalance = itemView.findViewById(R.id.farmerWalletBalance);

        }
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_farmer_list, parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.farmerName.setText(dataList.get(position).getName());
        holder.farmerEmail.setText(dataList.get(position).getEmail());
        holder.farmerWalletBalance.setText(dataList.get(position).getWallet_balance());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
