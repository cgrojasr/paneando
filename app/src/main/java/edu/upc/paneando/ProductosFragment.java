package edu.upc.paneando;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import edu.upc.paneando.dao.ProductoDAO;
import edu.upc.paneando.models.Producto;
import edu.upc.paneando.util.CustomAdapter;
import edu.upc.paneando.util.VolleyCallBack;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductosFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView rcvProductos;
    private ProductoDAO objProductoDAO;
    private List<Producto> productos = new ArrayList<>();
    private CustomAdapter customAdapter;


    public ProductosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductosFragment newInstance(String param1, String param2) {
        ProductosFragment fragment = new ProductosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_productos, container, false);
        rcvProductos = view.findViewById(R.id.rcvProductos);
        rcvProductos.setLayoutManager(new LinearLayoutManager(getContext()));

        //objProductoDAO = new ProductoDAO(getContext());
        //productos = objProductoDAO.Listar();
        Listar_Productos(new VolleyCallBack() {
            @Override
            public void onSuccess() {
                customAdapter = new CustomAdapter(getContext(), productos);
                rcvProductos.setAdapter(customAdapter);
            }
        });

        return view;
    }

    public void Listar_Productos(final VolleyCallBack callBack){
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String api = "http://10.0.2.2:5198/api/Producto";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, api,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<Producto>>(){}.getType();
                        productos = gson.fromJson(response, type);
                        Log.e("api", "json: " + response);
                        callBack.onSuccess();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("api", "error: " + error);
            }
        });

        queue.add(stringRequest);
    }
}