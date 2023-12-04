package stomas2023.example.heartsport;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Ahora extends AppCompatActivity {

    private static final int PROGRESS_MIN = 60;
    private static final int PROGRESS_MAX = 100;
    private ProgressBar progressBar;
    private TextView textViewProgreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahora);

        // Buscar el ProgressBar y el TextView por sus ID
        progressBar = findViewById(R.id.progreso);
        textViewProgreso = findViewById(R.id.pro);

        // Lanzar el hilo de actualización del progreso
        updateProgress();
    }

    private void updateProgress() {
        // Crear un hilo para simular el progreso
        new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                while (progressBar.getProgress() < PROGRESS_MAX) {
                    // Generar un valor aleatorio entre 80 y 240
                    int randomValue = random.nextInt(PROGRESS_MAX - PROGRESS_MIN + 1) + PROGRESS_MIN;

                    // Verificar si el valor aleatorio es menor que 30 o mayor que 170
                    if (randomValue < 55) {
                        // Mostrar mensaje en Log cuando la presión baja demasiado
                        Log.d("Presion", "Tu presión está baja. Busca ayuda.");
                    } else if (randomValue > 110) {
                        // Mostrar mensaje en Log cuando la presión sube demasiado
                        Log.d("Presion", "Tienes la presión muy alta. Respira.");
                    }

                    // Actualizar el progreso con el valor aleatorio
                    progressBar.setProgress(randomValue);

                    // Mostrar el progreso en el TextView
                    final String progressText = String.valueOf(randomValue) + "%";
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textViewProgreso.setText(progressText);
                        }
                    });

                    // Simular un retraso para que puedas ver el progreso
                    try {
                        Thread.sleep(500); // Puedes ajustar el tiempo de espera según tus necesidades
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}


