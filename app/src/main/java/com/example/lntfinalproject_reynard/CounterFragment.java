package com.example.lntfinalproject_reynard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class CounterFragment extends Fragment {
    TextView show_count;
    Button plus, minus, reset;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private int curr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.activity_counter_fragment, container, false);
        show_count = view.findViewById(R.id.show);
        plus = view.findViewById(R.id.addition);
        minus = view.findViewById(R.id.subtract);
        reset = view.findViewById(R.id.reset);
        sharedPreferences = getActivity().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        curr = sharedPreferences.getInt("count", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        show_count.setText(String.valueOf(curr));
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + 1;
                show_count.setText(String.valueOf(curr));
                editor.putInt("counter", curr);
                editor.apply();
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr - 1;
                show_count.setText(String.valueOf(curr));
                editor.putInt("counter", curr);
                editor.apply();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = 0;
                show_count.setText(String.valueOf(curr));
                editor.putInt("counter", curr);
                editor.apply();
            }
        });
        return view;
    }
}