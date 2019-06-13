package com.kamau.gabriel.kiswahili;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SwahiliActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SwahiliAdapter swahili;
    private RecyclerView.LayoutManager layoutManager;

    private Button translate;
    private Button exit;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swahili);
        recyclerView = findViewById(R.id.translateRecycler);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        translate = findViewById(R.id.translate);
        exit = findViewById(R.id.exit);
        editText = findViewById(R.id.editText);

        swahili = new SwahiliAdapter();
        recyclerView.setAdapter(swahili);
        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swahili.setDataSet(
                        kiswahiliwords(editText.getText().toString()));
                swahili.notifyDataSetChanged();

            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    String[] kiswahiliwords(String word){
        List<String> maneno = new ArrayList<>();
        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(getAssets().open("kamusi.csv")))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[1].equals(word)){
                    maneno.add(values[0]);
                }

            }
            String[] arr = new String[maneno.size()];
            for (int i = 0; i < maneno.size(); i++) {
                arr[i] = maneno.get(i);
            }

            return arr;

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return new String[]{"Hakuna neno"};

    }
}




