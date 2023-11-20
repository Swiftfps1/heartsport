package stomas2023.example.heartsport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class Princi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_princi);

        // Encuentra la referencia al ImageButton ibTiempo por su ID
        ImageButton ibTiempo = findViewById(R.id.ibTiempo);

        // Agrega un OnClickListener al ImageButton ibTiempo
        ibTiempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define la intención de cambiar a la actividad Ahora
                Intent intent = new Intent(Princi.this, Ahora.class);

                // Inicia la actividad Ahora
                startActivity(intent);
            }
        });

        // Encuentra la referencia al ImageButton ibRegistro por su ID
        ImageButton ibRegistro = findViewById(R.id.ibRegistro);

        // Agrega un OnClickListener al ImageButton ibRegistro
        ibRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define la intención de cambiar a la actividad Historial
                Intent intent = new Intent(Princi.this, Historial.class);

                // Inicia la actividad Historial
                startActivity(intent);
            }
        });

        // Encuentra la referencia al ImageButton ibMapa por su ID
        ImageButton ibMapa = findViewById(R.id.ibMapa);

        // Agrega un OnClickListener al ImageButton ibMapa
        ibMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define la intención de cambiar a la actividad MapaActivity
                Intent intent = new Intent(Princi.this, Mapa.class);

                // Inicia la actividad MapaActivity
                startActivity(intent);
            }
        });
    }
}
