package com.example.sciencecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView input;
    TextView screen_with_resultat;
    String first_value, second_value, symbol;
    Double number1, number2, output;
    int len, i;
    Boolean comma, isComplexFunction;

    public boolean isNumeric(String string) {
        if (string.matches("\\d+(?:\\.\\d+)?")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (TextView) findViewById(R.id.input);
        screen_with_resultat = (TextView) findViewById(R.id.sign);
        comma = false;
        isComplexFunction = false;
    }

    public void btnClick_0(View view) {
        input.setText(input.getText() + "0");
    }

    public void btnClick_1(View view) {
        input.setText(input.getText() + "1");
    }

    public void btnClick_2(View view) {
        input.setText(input.getText() + "2");
    }

    public void btnClick_3(View view) {
        input.setText(input.getText() + "3");
    }

    public void btnClick_4(View view) {
        input.setText(input.getText() + "4");
    }

    public void btnClick_5(View view) {
        input.setText(input.getText() + "5");
    }

    public void btnClick_6(View view) {
        input.setText(input.getText() + "6");
    }

    public void btnClick_7(View view) {
        input.setText(input.getText() + "7");
    }

    public void btnClick_8(View view) {
        input.setText(input.getText() + "8");
    }

    public void btnClick_9(View view) {
        input.setText(input.getText() + "9");
    }

    public void onClick_comma(View view) {
        if (!comma) {
            if (input.getText().equals("")) {

                input.setText("0.");
            } else {

                input.setText(input.getText() + ".");
            }

            comma = true;
        }
    }


    public void onClick_plus(View view) {
        symbol = "+";
        first_value = input.getText().toString();
        screen_with_resultat.setText(first_value + "+");
        input.setText(null);
        comma = false;
    }

    public void onClick_minus(View view) {
        symbol = "-";
        first_value = input.getText().toString();
        screen_with_resultat.setText(first_value + "-");
        input.setText(null);
        comma = false;
    }

    public void onClick_divide(View view) {
        symbol = "/";
        first_value = input.getText().toString();
        screen_with_resultat.setText(first_value + "÷");
        input.setText(null);
        comma = false;
    }

    public void onClick_multiply(View view) {
        first_value = input.getText().toString();
        symbol = "*";
        screen_with_resultat.setText(first_value + "*");
        input.setText(null);
        comma = false;
    }

    public void onClick_clear(View view) {
        first_value = null;
        second_value = null;
        symbol = null;
        input.setText(null);
        screen_with_resultat.setText(null);
        comma = false;
    }

    public void onClick_erase(View view) {
        if (input.getText().equals("")) {
            input.setText(null);
        } else if (!input.getText().equals("")) {
            len = input.getText().length();
            input.setText(input.getText().subSequence(0, input.getText().length() - 1));
        }
    }

    // Complex functions: log, ln, pow, sqrt
    public void onClick_log(View view) {
        symbol = "log";
        screen_with_resultat.setText("log");
        input.setText(null);
        comma = false;
        isComplexFunction = true;
    }

    public void onClick_ln(View view) {
        symbol = "ln";
        input.setText(null);
        screen_with_resultat.setText("ln");
        comma = false;

    }

    public void onClick_pow(View view) {
        symbol = "pow";
        first_value = input.getText().toString();
        input.setText(null);
        screen_with_resultat.setText("xⁿ");
        comma = false;

    }

    public void onClick_sqrt(View view) {
        symbol = "sqrt";
        input.setText(null);
        screen_with_resultat.setText("√");
        comma = false;
    }

    public void onClick_exp(View view) {
        symbol = "exp";
        input.setText(null);
        screen_with_resultat.setText("e^x");
        comma = false;
    }

    public void onClick_factorial(View view) {
        symbol = "factorial";
        input.setText(null);
        screen_with_resultat.setText("!");
        comma = false;
    }

    // Trigonometric functions: sin, cos, tan

    public void onClick_sin(View view) {
        symbol = "sin";
        input.setText(null);
        screen_with_resultat.setText("sin");
        comma = false;
    }

    public void onClick_cos(View view) {
        symbol = "cos";
        input.setText(null);
        screen_with_resultat.setText("cos");
        comma = false;
    }

    public void onClick_tan(View view) {
        symbol = "tan";
        input.setText(null);
        screen_with_resultat.setText("tan");
        comma = false;
    }

    public void onClick_pi(View view) {
        if (!input.getText().equals("")) {
            screen_with_resultat.setText("Syntax error");
        } else {
            input.setText(input.getText() + "3.1415926536");
            screen_with_resultat.setText("π");
            comma = false;
        }

    }

    public void onClick_e(View view) {
        if (!input.getText().equals("")) {
            screen_with_resultat.setText("Syntax error");
        } else {
            input.setText(input.getText() + "2.71828182846");
            screen_with_resultat.setText("e");
            comma = false;
        }

    }

    public void onClick_equal(View view) {

        if (isNumeric(input.getText().toString()) && symbol == null) {
            screen_with_resultat.setText(input.getText().toString());
        } else if (input.getText().toString().equals("")) {
            screen_with_resultat.setText("Syntax Error!");
        } else if (input.getText().toString().equals("null") || input.getText().toString().equals("") || input.getText().toString().equals(" ")) {
            screen_with_resultat.setText("Syntax Error");
        } else if ((symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/")) && first_value.equals("")) {
            input.setText(null);
            screen_with_resultat.setText("Syntax Error!");
        } else {

            switch (symbol) {
                case "+":
                    second_value = input.getText().toString();
                    number1 = Double.parseDouble(first_value);
                    number2 = Double.parseDouble(second_value);
                    output = number1 + number2;
                    input.setText(output + "");
                    symbol = null;
                    screen_with_resultat.setText(first_value + "+" + second_value + "=");
                    break;
                case "-":
                    second_value = input.getText().toString();
                    number1 = Double.parseDouble(first_value);
                    number2 = Double.parseDouble(second_value);
                    output = number1 - number2;
                    input.setText(output + "");
                    symbol = null;
                    screen_with_resultat.setText(first_value + "-" + second_value + "=");
                    break;
                case "/":
                    second_value = input.getText().toString();
                    number1 = Double.parseDouble(first_value);
                    number2 = Double.parseDouble(second_value);
                    output = number1 / number2;
                    input.setText(output + "");
                    symbol = null;
                    screen_with_resultat.setText(first_value + "÷" + second_value + "=");
                    break;
                case "*":
                    second_value = input.getText().toString();
                    number1 = Double.parseDouble(first_value);
                    number2 = Double.parseDouble(second_value);
                    output = number1 * number2;
                    input.setText(output + "");
                    symbol = null;
                    screen_with_resultat.setText(first_value + "×" + second_value + "=");
                    break;
                case "sin":
                    second_value = input.getText().toString();
                    number1 = Double.parseDouble(second_value);
                    output = Math.sin(number1);
                    input.setText(output + "");
                    symbol = null;
                    screen_with_resultat.setText("sin(" + second_value + ")" + "=");
                    break;

                case "cos":
                    second_value = input.getText().toString();
                    number1 = Double.parseDouble(second_value);
                    input.setText(Math.cos(number1) + "");
                    symbol = null;
                    screen_with_resultat.setText("cos(" + second_value + ")" + "=");
                    break;
                case "tan":
                    second_value = input.getText().toString();
                    number1 = Double.parseDouble(second_value);
                    input.setText(Math.tan(number1) + "");
                    symbol = null;
                    screen_with_resultat.setText("tan(" + second_value + ")" + "=");
                    break;
                case "log":
                    second_value = input.getText().toString();
                    number1 = Double.parseDouble(second_value);
                    input.setText(Math.log10(number1) + "");
                    symbol = null;
                    screen_with_resultat.setText("log(" + second_value + ")" + "=");

                    break;
                case "ln":
                    second_value = input.getText().toString();
                    number1 = Double.parseDouble(second_value);
                    input.setText(Math.log(number1) + "");
                    symbol = null;
                    screen_with_resultat.setText("ln(" + second_value + ")" + "=");
                    break;
                case "pow":
                    second_value = input.getText().toString();
                    number1 = Double.parseDouble((first_value));
                    number2 = Double.parseDouble(second_value);
                    input.setText(Math.pow(number1, number2) + "");
                    symbol = null;
                    screen_with_resultat.setText(first_value + '^' + second_value + "=");
                    break;
                case "sqrt":
                    second_value = input.getText().toString();
                    number1 = Double.parseDouble(second_value);
                    input.setText(Math.sqrt(number1) + "");
                    symbol = null;
                    screen_with_resultat.setText('√' + second_value + "=");
                    break;
                case "exp":
                    first_value = input.getText().toString();
                    number1 = Double.parseDouble(first_value);
                    input.setText(Math.exp(number1) + "");
                    symbol = null;
                    screen_with_resultat.setText("e^" + first_value + "=");
                    break;
                case "factorial":
                    first_value = input.getText().toString();
                    number1 = Double.parseDouble((first_value));
                    i = Integer.parseInt(first_value) - 1;

                    while (i > 0) {
                        number1 = number1 * i;
                        i--;
                    }

                    input.setText(number1 + "");
                    symbol = null;
                    screen_with_resultat.setText(first_value + "!");
                    break;
                default:
                    break;
            }
        }

    }
}
