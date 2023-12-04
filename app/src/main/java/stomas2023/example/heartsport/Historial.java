package stomas2023.example.heartsport;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Historial extends AppCompatActivity {

    private ListView listRecibir;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> mantenimientosKeys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        // Configurar el ListView
        listRecibir = findViewById(R.id.idlist);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());
        listRecibir.setAdapter(adapter);
        mantenimientosKeys = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mantenimientosRef = database.getReference("Android");

        mantenimientosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                adapter.clear();
                mantenimientosKeys.clear();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String mantenimientoKey = ds.getKey();
                    mantenimientosKeys.add(mantenimientoKey);
                    String android = ds.child("Android").getValue(String.class);

                    String mantenimientoData = "Android: " + android;

                    String elementoLista = mantenimientoData;
                    adapter.add(elementoLista);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Manejar errores si es necesario
            }
        });
    }
}
