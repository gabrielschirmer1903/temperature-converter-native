package br.edu.unijui.termometro;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    Button ConvertButton;
    TextInputEditText TemperatureInput;
    TextView OutputTemperature;

    RadioButton InputFahrenheit;
    RadioButton InputKelvin;
    RadioButton InputCelsius;

    RadioButton OutputFahrenheit;
    RadioButton OutputKelvin;
    RadioButton OutputCelsius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConvertButton = findViewById(R.id.ConvertButton);
        TemperatureInput = findViewById(R.id.TemperatureInput);
        OutputTemperature = findViewById(R.id.OutputTemperature);

        InputFahrenheit = findViewById(R.id.inputFahrenheit);
        InputKelvin = findViewById(R.id.inputKelvin);
        InputCelsius = findViewById(R.id.inputCelsius);

        OutputFahrenheit = findViewById(R.id.outputFahrenheit);
        OutputCelsius = findViewById(R.id.outputCelsius);
        OutputKelvin = findViewById(R.id.outputKelvin);


        ConvertButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String valueInput = TemperatureInput.getText().toString();

                if (valueInput == "") return;
                
                if (OutputKelvin.isChecked()) {
                    OutputTemperature.setText(toKelvin(valueInput));
                } else if (OutputCelsius.isChecked()) {
                    
                } else if (OutputFahrenheit.isChecked()) {
                    
                }

                // Log.d("MainActivity", valueInput.toString());
            }

            public String toKelvin(String temperature) {
                Integer _temp = Integer.valueOf(temperature);

                if (InputCelsius.isChecked()) {
                    _temp = _temp +273;
                    return _temp.toString();

                } else if (InputFahrenheit.isChecked()) {
                    _temp = (((_temp - 32) * 9) /5 ) + 273;
                    return _temp.toString();
                } else return temperature;
            };

            public String toFahrenheit(String temperature) {
                Integer _temp = Integer.valueOf(temperature);

                if (InputCelsius.isChecked()) {
                    _temp = (((_temp - 32) * 5 )/9);
                    return _temp.toString();

                } else if (InputFahrenheit.isChecked()) {
                    _temp = (((_temp - 32) * 9) /5 ) + 273;
                    return _temp.toString();
                } else return temperature;
            };
        });
    }
}

