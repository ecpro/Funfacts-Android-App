package com.piyush.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FunFactsActivity extends AppCompatActivity {

    private static final String TAG = FunFactsActivity.class.getSimpleName();

    // Declare our view variables
    private TextView factTextView;
    private Button showFactButton;
    private RelativeLayout layout;

    private FactBook factBook = new FactBook();
    private String fact = factBook.getFunFacts().getFunFacts()[0];
    private Integer color = Color.parseColor(factBook.getColorWheel().getColors()[0]);

    private static final String FUN_FACT = "FUN_FACT";
    private static final String COLOR = "COLOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // assign the views from the layout file to the corresponding variables
        factTextView = findViewById(R.id.factTextView);
        showFactButton = findViewById(R.id.showFactButton);
        layout = findViewById(R.id.funFactLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fact = factBook.getFunFacts().getFacts();
                color = factBook.getColorWheel().getColor();
                factTextView.setText(fact);
                layout.setBackgroundColor(color);
                showFactButton.setTextColor(color);
                Log.d(TAG, "funFact activity");
            }
        };
        showFactButton.setOnClickListener(listener);
        Toast.makeText(this, "Enjoy the fun facts", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(FUN_FACT, fact);
        outState.putInt(COLOR, color);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        fact = savedInstanceState.getString(FUN_FACT);
        color = savedInstanceState.getInt(COLOR);
        factTextView.setText(fact);
        layout.setBackgroundColor(color);
        showFactButton.setTextColor(color);
    }
}
