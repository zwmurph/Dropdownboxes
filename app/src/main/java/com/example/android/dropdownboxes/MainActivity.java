package com.example.android.dropdownboxes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * If it isn't automatically added, make sure:
 * import android.widget.AdapterView.OnItemSelectedListener;
 * is imported
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Call this method to initiate the creation of the Spinner
        createSpinnerOptions();

        //Get the spinner as an object and call the OnItemSelectedListener on it to create the listener
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
    }

    /**
     * The method that creates the spinner options
     */
    public void createSpinnerOptions() {
        //Create the spinner as an object
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Create an ArrayAdapter using the the array of options and the style of the text before selection layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, R.layout.spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    /**
     * This sub-class controls what happens when the listener detects something has been selected
     */
    public class MyOnItemSelectedListener implements OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            //When an item is selected, do this:
            TextView spinnerStringOut = (TextView) findViewById(R.id.spinnerText);
            spinnerStringOut.setText(parent.getItemAtPosition(pos).toString());
        }

        public void onNothingSelected(AdapterView parent) {
            // Do nothing when nothing is selected.
        }
    }
}


