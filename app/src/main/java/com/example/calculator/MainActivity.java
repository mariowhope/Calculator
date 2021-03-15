package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
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
    // Operator Plus (+)
    public void buttonPlusClicked (View view){
        // hide keyboard after onClick event
        editTextSecondNumber.onEditorAction(EditorInfo.IME_ACTION_DONE);
        // warning toast :: invalid input
        if(editTextFirstNumber.getText().toString().equals("") || editTextSecondNumber.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this,getResources().getString(R.string.editText_isNaN),Toast.LENGTH_LONG).show();
        }else {
            Double numA = Double.parseDouble(editTextFirstNumber.getText().toString());
            Double numB = Double.parseDouble(editTextSecondNumber.getText().toString());
            // reset result view string to default value
            textViewResult.setText(getResources().getString(R.string.calc_result));
            Double result = numA + numB;
            // concat result
            textViewResult.setText(textViewResult.getText() + result.toString());
            // additionally I've placed the result on editTextFirstNumber.
            // editTextFirstNumber.setText(result.toString());
        }
    }
    // Operator Minus (-)
    public void buttonMinusClicked (View view){
        // hide keyboard after onClick event
        editTextSecondNumber.onEditorAction(EditorInfo.IME_ACTION_DONE);
        // warning toast :: invalid input
        if(editTextFirstNumber.getText().toString().equals("") || editTextSecondNumber.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this,getResources().getString(R.string.editText_isNaN),Toast.LENGTH_LONG).show();
        }else {
            Double numA = Double.parseDouble(editTextFirstNumber.getText().toString());
            Double numB = Double.parseDouble(editTextSecondNumber.getText().toString());
            // reset result view string to default value
            textViewResult.setText(getResources().getString(R.string.calc_result));
            Double result = numA - numB;
            // concat result
            textViewResult.setText(textViewResult.getText() + result.toString());
            // additionally I've placed the result on editTextFirstNumber.
            // editTextFirstNumber.setText(result.toString());
        }
    }
    // Operator Multiply (*)
    public void buttonMultiplyClicked (View view){
        // hide keyboard after onClick event
        editTextSecondNumber.onEditorAction(EditorInfo.IME_ACTION_DONE);
        // warning toast :: invalid input
        if(editTextFirstNumber.getText().toString().equals("") || editTextSecondNumber.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this,getResources().getString(R.string.editText_isNaN),Toast.LENGTH_LONG).show();
        }else {
            Double numA = Double.parseDouble(editTextFirstNumber.getText().toString());
            Double numB = Double.parseDouble(editTextSecondNumber.getText().toString());
            // reset result view string to default value
            textViewResult.setText(getResources().getString(R.string.calc_result));
            Double result = numA * numB;
            // concat result
            textViewResult.setText(textViewResult.getText() + result.toString());
            // Additionally I've placed the result on editTextFirstNumber.
            // editTextFirstNumber.setText(result.toString());
        }
    }
    // Operator Divide (/)
    public void buttonDivideClicked (View view){
        // hide keyboard after onClick event
        editTextSecondNumber.onEditorAction(EditorInfo.IME_ACTION_DONE);
        // warning toast :: Divide by Zero
        if (editTextSecondNumber.getText().toString().equals("0")) {
            Toast.makeText(MainActivity.this,getResources().getString(R.string.zero_division),Toast.LENGTH_LONG).show();
        // warning toast :: Invalid Input
        }else if(editTextFirstNumber.getText().toString().equals("") || editTextSecondNumber.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this,getResources().getString(R.string.editText_isNaN),Toast.LENGTH_LONG).show();
        }else {
            Double num = Double.parseDouble(editTextFirstNumber.getText().toString());
            Double den = Double.parseDouble(editTextSecondNumber.getText().toString());
            // reset result view string to default value
            textViewResult.setText(getResources().getString(R.string.calc_result));
            Double result = num / den;
            // remove the decimal character if it is not relevant
            //TODO:if(result % 1 == 0) {

            // concat result
            textViewResult.setText(textViewResult.getText() + result.toString());
            // Additionally I've placed the result on editTextFirstNumber.
            // editTextFirstNumber.setText(result.toString());
        }
    }
}