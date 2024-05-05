package com.example.lntfinalproject_reynard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class LuasFragment extends Fragment {
    EditText sisi_persegi1, sisi_persegi2, alas_segitiga, tinggi_segitiga, radius_lingkaran;
    TextView result_persegi, result_segitiga, result_lingkaran;
    Button button_persegi, button_segitiga, button_lingkaran;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View view =  inflater.inflate(R.layout.activity_luas_fragment, container, false);
        sisi_persegi1 = view.findViewById(R.id.persegi_sisi1);
        sisi_persegi2 = view.findViewById(R.id.persegi_sisi2);
        alas_segitiga = view.findViewById(R.id.segitiga_alas);
        tinggi_segitiga = view.findViewById(R.id.segitia_tinggi);
        radius_lingkaran = view.findViewById(R.id.radius_lingkaran);
        result_persegi = view.findViewById(R.id.result_persegi);
        result_lingkaran = view.findViewById(R.id.result_lingkaran);
        result_segitiga = view.findViewById(R.id.result_segitiga);
        button_persegi = view.findViewById(R.id.button_persegi);
        button_lingkaran = view.findViewById(R.id.button_lingkaran);
        button_segitiga = view.findViewById(R.id.button_segitiga);

        button_persegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_sisi1 = sisi_persegi1.getText().toString().trim();
                String new_sisi2 = sisi_persegi2.getText().toString().trim();

                if(new_sisi1.isEmpty() && new_sisi2.isEmpty())
                {
                    Toast.makeText(getActivity(), "Please Fill Both Entries", Toast.LENGTH_SHORT).show();
                }else
                {
                    double sisi1 = Double.parseDouble(new_sisi1);
                    double sisi2 = Double.parseDouble(new_sisi2);
                    double result = sisi1 * sisi2;

                    result_persegi.setText("Result: " + result);
                }
            }
        });

        button_segitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_sisi1 = alas_segitiga.getText().toString().trim();
                String new_sisi2 = tinggi_segitiga.getText().toString().trim();

                if(new_sisi1.isEmpty() && new_sisi2.isEmpty())
                {
                    Toast.makeText(getActivity(), "Please Fill Both Entries", Toast.LENGTH_SHORT).show();
                }else
                {
                    double sisi1 = Double.parseDouble(new_sisi1);
                    double sisi2 = Double.parseDouble(new_sisi1);
                    double result = sisi1 * sisi2 / 2;

                    result_segitiga.setText("Result: " + result);
                }
            }
        });

        button_lingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_radius = radius_lingkaran.getText().toString().trim();


                if(new_radius.isEmpty())
                {
                    Toast.makeText(getActivity(), "Please Fill The Entry", Toast.LENGTH_SHORT).show();
                }else
                {
                    double radius = Double.parseDouble(new_radius);
                    double result = 3.14 * radius * radius;

                    result_segitiga.setText("Result: " + result);
                }
            }
        });
        return view;
    }
}