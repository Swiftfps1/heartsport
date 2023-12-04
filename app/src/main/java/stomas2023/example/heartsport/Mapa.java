package stomas2023.example.heartsport;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import stomas2023.example.heartsport.databinding.ActivityMapaBinding;

public class Mapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Agregar marcadores para puntos de salud en Chillán, Chile
        agregarMarcador(-36.607568, -72.096405, "Hospital Clínico Herminda Martin",
                "Lunes a Viernes: 8:00 AM - 6:00 PM\nSábado: 9:00 AM - 1:00 PM",
                "+56 9 1234 5678");
        agregarMarcador(-36.608311, -72.102335, "Hospital Nuevo Chillán",
                "Lunes a Domingo: 24 horas",
                "+56 9 2345 6789");
        agregarMarcador(-36.616359, -72.105816, "Clínica Chillán",
                "Lunes a Sábado: 9:00 AM - 7:00 PM",
                "+56 9 3456 7890");
        agregarMarcador(-36.608979, -72.092148, "Consultorio Chillán Viejo",
                "Lunes a Viernes: 7:30 AM - 5:00 PM",
                "+56 9 4567 8901");

        // Puedes agregar más marcadores según sea necesario

        // Mover la cámara a una ubicación inicial
        LatLng ubicacionInicial = new LatLng(-36.608979, -72.092148);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacionInicial, 12));

        // Configurar un adaptador personalizado para las ventanas de información
        mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter());
    }

    private void agregarMarcador(double latitud, double longitud, String titulo, String horarios, String numeroContacto) {
        LatLng ubicacion = new LatLng(latitud, longitud);
        Marker marker = mMap.addMarker(new MarkerOptions().position(ubicacion).title(titulo));
        // Almacenar información adicional en el marcador
        marker.setTag(new MarcadorInfo(horarios, numeroContacto));
    }

    // Clase para almacenar información adicional del marcador
    private static class MarcadorInfo {
        final String horarios;
        final String numeroContacto;

        MarcadorInfo(String horarios, String numeroContacto) {
            this.horarios = horarios;
            this.numeroContacto = numeroContacto;
        }
    }

    // Adaptador personalizado para las ventanas de información
    // Adaptador personalizado para las ventanas de información
    // Adaptador personalizado para las ventanas de información
    private class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

        private final View window;

        CustomInfoWindowAdapter() {
            // Inflar el diseño personalizado para la ventana de información una sola vez
            window = getLayoutInflater().inflate(R.layout.custtom_info_window, null);
        }

        @Override
        public View getInfoWindow(Marker marker) {
            // Utiliza la ventana de información predeterminada
            return null;
        }

        @Override
        public View getInfoContents(Marker marker) {
            // Obtener información adicional del marcador
            MarcadorInfo marcadorInfo = (MarcadorInfo) marker.getTag();
            if (marcadorInfo != null) {
                // Actualizar el diseño con la información del marcador
                TextView txtTitulo = window.findViewById(R.id.txtTitulo);
                TextView txtHorarios = window.findViewById(R.id.txtHorarios);
                TextView txtNumeroContacto = window.findViewById(R.id.txtNumeroContacto);

                txtTitulo.setText(marker.getTitle());
                txtHorarios.setText("Horarios: " + marcadorInfo.horarios);
                txtNumeroContacto.setText("Contacto: " + marcadorInfo.numeroContacto);
            }

            return window;
        }
    }}

