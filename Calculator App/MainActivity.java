package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
 private TextView resultTextView;
 private StringBuilder currentInput = new StringBuilder();
 private double currentResult = 0;
 private String currentOperator = "";
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 resultTextView = findViewById(R.id.tv);
 setClickListeners();
 }
 private void setClickListeners() {
 int[] digitButtonIds = {
 R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
 R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
 };
 for (int id : digitButtonIds) {
 Button button = findViewById(id);
 button.setOnClickListener(view -> onDigitClick(button.getText().toString()));
 }
 findViewById(R.id.btnAdd).setOnClickListener(view -> onOperatorClick("+"));
 findViewById(R.id.btnSubtract).setOnClickListener(view -> onOperatorClick("-"));
 findViewById(R.id.btnMultiply).setOnClickListener(view -> onOperatorClick("*"));
 findViewById(R.id.btnDivide).setOnClickListener(view -> onOperatorClick("/"));
 findViewById(R.id.btnEquals).setOnClickListener(view -> onEqualsClick());
 findViewById(R.id.btnDecimal).setOnClickListener(view -> onDecimalClick());
 findViewById(R.id.btnClear).setOnClickListener(view -> onClearClick());
 findViewById(R.id.btnAC).setOnClickListener(view -> onACClick());
 findViewById(R.id.btnOpenParenthesis).setOnClickListener(view -> onParenthesisClick("("));
 findViewById(R.id.btnCloseParenthesis).setOnClickListener(view -> onParenthesisClick(")"));
 }
 private void onDigitClick(String digit) {
 currentInput.append(digit);
 updateResult();
 }
 private void onOperatorClick(String operator) {
 if (currentInput.length() > 0) {
 currentResult = Double.parseDouble(currentInput.toString());
 currentOperator = operator;
 currentInput.setLength(0);
 }
 }
 private void onEqualsClick() {
 if (currentInput.length() > 0 && currentOperator.length() > 0) {
 double secondOperand = Double.parseDouble(currentInput.toString());
 switch (currentOperator) {
 case "+":
 currentResult += secondOperand;
 break;
 case "-":
 currentResult -= secondOperand;
 break;
 case "*":
 currentResult *= secondOperand;
 break;
 case "/":
 currentResult /= secondOperand;
 break;
 
}
 currentInput.setLength(0);
 currentInput.append(currentResult);
 currentOperator = "";
 updateResult();
 
}
 
}
 private void onDecimalClick() {
 if (!currentInput.toString().contains(".")) {
 currentInput.append(".");
 updateResult();
 
}
 
}
 private void onClearClick() {
 currentInput.setLength(0);
 currentResult = 0;
 currentOperator = "";
 updateResult();
 
}
 private void onACClick() {
 currentInput.setLength(0);
 currentResult = 0;
 currentOperator = "";
 updateResult();
 
}
 private void onParenthesisClick(String parenthesis) {
 currentInput.append(parenthesis);
 updateResult();
 
}
 private void updateResult() {
 resultTextView.setText(currentInput.toString());
 
}
}
