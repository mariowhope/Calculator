package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

/** List of views
 *  - textViewTittle        :: Label
 *  - textViewFirstNumber   :: Label
 *  - textViewSecondNumber  :: Label
 *  - textViewResult        :: Output
 *  - editTextFirstNumber   :: Input
 *  - editTextSecondNumber  :: Input
 */
public class MainActivity extends AppCompatActivity {

    // variables
    EditText editTextFirstNumber;
    EditText editTextSecondNumber;
    TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // fill variables with values from views
        editTextFirstNumber = findViewById(R.id.editTextFirstNumber);
        editTextSecondNumber = findViewById(R.id.editTextSecondNumber);
        textViewResult = findViewById(R.id.textViewResult);
    }
    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    public void operationClicked (View view){
        // hide keyboard after onClick event
        editTextSecondNumber.onEditorAction(EditorInfo.IME_ACTION_DONE);
        // warning toast :: invalid input
        if(editTextFirstNumber.getText().toString().equals("") || editTextSecondNumber.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this,getResources().getString(R.string.editText_isNaN),Toast.LENGTH_SHORT).show();
        }else {
            double numA = Double.parseDouble(editTextFirstNumber.getText().toString());
            double numB = Double.parseDouble(editTextSecondNumber.getText().toString());
            double result = 0;
            // reset result view string to default value
            textViewResult.setText(getResources().getString(R.string.calc_result));
            switch (view.getId()) {
                // Operator Plus (+)
                case R.id.buttonPlus:
                    result = numA + numB;
                    break;
                // Operator Minus (-)
                case R.id.buttonMinus:
                    result = numA - numB;
                    break;
                // Operator Multiply (*)
                case R.id.buttonMultiply:
                    result = numA * numB;
                    break;
                // Operator Divide (/)
                case R.id.buttonDivide:
                    if (editTextSecondNumber.getText().toString().equals("0")) {
                        Toast.makeText(MainActivity.this,
                                getResources().getString(R.string.zero_division),
                                Toast.LENGTH_LONG).show();
                    }else {
                        result = numA / numB;
                    }
                    break;
            }
            textViewResult.setText(textViewResult.getText() + String.valueOf(result));
        }
    }
}