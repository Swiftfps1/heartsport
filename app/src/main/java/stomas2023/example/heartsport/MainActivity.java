package stomas2023.example.heartsport;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Agregar un retraso de 3 segundos antes de pasar a la ventana principal
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Crear un Intent para pasar a la ventana principal (Historial)
                Intent intent = new Intent(MainActivity.this, Princi.class);
                startActivity(intent);

                // Asegurarse de que la actividad actual se cierre después de pasar a la nueva actividad
                finish();
            }
        }, 3000); // 3000 milisegundos (3 segundos)
    }
}
