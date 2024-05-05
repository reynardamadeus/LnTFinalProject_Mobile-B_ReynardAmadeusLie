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

public class VolumeFragment extends Fragment {
    EditText panjang_balok, lebar_balok, tinggi_balok, panjang_alaspiramid, lebar_alaspiramid, tinggi_piramid,
    radius_tabung, tinggi_tabung;
    TextView result_balok, result_piramid, result_tabung;
    Button button_balok, button_piramid, button_tabung;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.activity_volume_fragment, container, false);
        panjang_balok = view.findViewById(R.id.panjang_balok);
        lebar_balok = view.findViewById(R.id.lebar_balok);
        tinggi_balok = view.findViewById(R.id.tinggi_balok);
        panjang_alaspiramid = view.findViewById(R.id.panjang_alaspiramid);
        lebar_alaspiramid = view.findViewById(R.id.lebar_alaspiramid);
        tinggi_piramid = view.findViewById(R.id.tinggi_piramid);
        radius_tabung = view.findViewById(R.id.radius_tabung);
        tinggi_tabung = view.findViewById(R.id.tinggi_tabung);
        result_balok = view.findViewById(R.id.result_balok);
        result_piramid = view.findViewById(R.id.result_piramid);
        result_tabung = view.findViewById(R.id.result_tabung);
        button_balok = view.findViewById(R.id.button_balok);
        button_piramid = view.findViewById(R.id.button_piramid);
        button_tabung = view.findViewById(R.id.button_tabung);

        button_balok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string_panjang = panjang_balok.getText().toString();
                String string_lebar = lebar_balok.getText().toString();
                String string_tinggi = tinggi_balok.getText().toString();

                if(string_panjang.isEmpty() && string_lebar.isEmpty() && string_tinggi.isEmpty())
                {
                    Toast.makeText(getActivity(), "Please Fill All The Blanks", Toast.LENGTH_SHORT).show();
                }else
                {
                    double panjang = Double.parseDouble(string_panjang);
                    double lebar = Double.parseDouble(string_lebar);
                    double tinggi = Double.parseDouble(string_tinggi);
                    double result = panjang * lebar * tinggi;
                    result_balok.setText("Result: " + result);
                }
            }
        });
        button_piramid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string_panjang = panjang_alaspiramid.getText().toString();
                String string_lebar = lebar_alaspiramid.getText().toString();
                String string_tinggi = tinggi_piramid.getText().toString();

                if(string_panjang.isEmpty() && string_lebar.isEmpty() && string_tinggi.isEmpty())
                {
                    Toast.makeText(getActivity(), "Please Fill All The Blanks", Toast.LENGTH_SHORT).show();
                }else
                {
                    double panjang_alas = Double.parseDouble(string_panjang);
                    double lebar_alas = Double.parseDouble(string_lebar);
                    double tinggi_piramid = Double.parseDouble(string_tinggi);
                    double result = panjang_alas * lebar_alas * tinggi_piramid / 3;
                    result_piramid.setText("Result: " + result);
                }
            }

        });

        button_tabung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string_radius = radius_tabung.getText().toString();
                String string_tinggi = tinggi_tabung.getText().toString();

                if(string_radius.isEmpty()  && string_tinggi.isEmpty())
                {
                    Toast.makeText(getActivity(), "Please Fill All The Blanks", Toast.LENGTH_SHORT).show();
                }else
                {
                    double radius = Double.parseDouble(string_radius);
                    double tinggi_tabung = Double.parseDouble(string_tinggi);
                    double result = 3.14 * radius * radius * tinggi_tabung;
                    result_tabung.setText("Result: " + result);
                }
            }

        });
        return view;
    }
}