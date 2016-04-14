package com.example.tommy.sunshineiak;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.container,new PlaceholderFragment())
                    .commit();
        }
    }
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            String[] data = new String[]{
                    "Minggu - hujan - 30/60",
                    "Senin - cerah - 35/67",
                    "Selasa - mendung - 36/67",
                    "Rabu - berawan - 30/60",
                    "Kamis - hujan - 30/60",
                    "Jumat - sangat cerah - 30/60",
                    "Sabtu - hujan - 30/60",
            };
            List<String> weekForecast = new ArrayList<String>(Arrays.asList(data));
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    getActivity(),
                    R.layout.list_item_forecast,
                    R.id.list_item_forecast_textview,
                    weekForecast
            );
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            ListView listView = (ListView)rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(adapter);
            return rootView;
        }
    }
}
