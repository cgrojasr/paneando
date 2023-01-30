package edu.upc.paneando.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.upc.paneando.CarritoFragment;
import edu.upc.paneando.R;
import edu.upc.paneando.dao.CarritoItemDAO;
import edu.upc.paneando.models.CarritoItem;

public class CarritoItemAdapter extends RecyclerView.Adapter<CarritoItemAdapter.MyViewHolder> {

    private Context context;
    private List<CarritoItem> items = new ArrayList<>();
    private CarritoItemDAO objCarritoItemDAO;

    public CarritoItemAdapter(Context context, List<CarritoItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public CarritoItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.carritoitem_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarritoItemAdapter.MyViewHolder holder, int position) {
        CarritoItem item = items.get(position);
        holder.txtItemNombre.setText(item.getNombre()+"");
        holder.txtItemCantidad.setText(item.getCantidad().toString()+"");
        holder.txtItemValorVenta.setText(item.getValor_total().toString()+"");

        holder.btnItemEliminar.setOnClickListener(view -> {
            objCarritoItemDAO = new CarritoItemDAO(context);
            objCarritoItemDAO.Eliminar_PorId(item.getId_item());
            ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frmCatalogo, new CarritoFragment())
                    .commit();
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtItemNombre, txtItemValorVenta, txtItemCantidad;
        ImageView imgItemImagen;
        Button btnItemEliminar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtItemNombre = itemView.findViewById(R.id.txtItemNombre);
            txtItemValorVenta = itemView.findViewById(R.id.txtItemValorVenta);
            txtItemCantidad = itemView.findViewById(R.id.txtItemCantidad);
            //imgItemImagen = itemView.findViewById(R.id);
            btnItemEliminar = itemView.findViewById(R.id.btnItemEliminar);
        }
    }
}
