package edu.upc.paneando.util;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.upc.paneando.CarritoFragment;
import edu.upc.paneando.CatalogoActivity;
import edu.upc.paneando.ProductosFragment;
import edu.upc.paneando.R;
import edu.upc.paneando.dao.CarritoItemDAO;
import edu.upc.paneando.models.CarritoItem;
import edu.upc.paneando.models.Producto;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private List<Producto> productos = new ArrayList<>();
    private CarritoItemDAO objCarritoItemDAO;

    public CustomAdapter(Context context, List<Producto> productos) {
        this.context = context;
        this.productos = productos;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.producto_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        Producto producto = productos.get(position);
        holder.txtNombre.setText(producto.getNombre()+"");
        holder.txtValorVenta.setText(producto.getValor_venta().toString()+"");
        //holder.imgProducto.setImageResource(producto.getImage());
        holder.btnAgregar.setOnClickListener(view -> {
//            Intent intent = new Intent(context, CatalogoActivity.class);
//            context.startActivity(intent);
            objCarritoItemDAO = new CarritoItemDAO(context);
            CarritoItem objCarritoItem = new CarritoItem(null, producto.getId_producto(),
                    producto.getNombre(), producto.getValor_venta(), 10, null);
            objCarritoItemDAO.Registrar(objCarritoItem);
            List<CarritoItem> lista = new ArrayList<>();
            lista = objCarritoItemDAO.Listar();
            ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frmCatalogo, new CarritoFragment())
                    .commit();
        });
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre, txtValorVenta;
        ImageView imgProducto;
        Button btnAgregar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtValorVenta = itemView.findViewById(R.id.txtValorVenta);
            btnAgregar = itemView.findViewById(R.id.btnAgregar);
            imgProducto = itemView.findViewById(R.id.imgProducto);
        }
    }
}
