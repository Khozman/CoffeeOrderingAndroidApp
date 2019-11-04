/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
//    boolean whippedCream = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate){

        return ("Name: " + name +
                " \nAdd Whipped cream? " + addWhippedCream +
                " \nAdd Chocolate? " + addChocolate +
                "\nQuantity: " + quantity +
                "\nTotal: R " + price +
                "\nThank you!");
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText name = (EditText) findViewById(R.id.name_text_input);
        String setName = name.getText().toString();

        // Figure out if the user wants whipped cream topping
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        // Figure out if the user wants chocolate topping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        // Calculate the price
        int price = calculatePrice(hasChocolate, hasWhippedCream);

        // Display the order summary on the screen
        String message = createOrderSummary(setName, price, hasWhippedCream, hasChocolate);
        displayMessage(message);
    }

    private int calculatePrice(boolean hasChocolate, boolean hasWhippedCream) {

        int pricePerCup = 5;

        if(hasChocolate){
            pricePerCup = pricePerCup + 2;
        }

        if(hasWhippedCream){
            pricePerCup = pricePerCup + 1;
        }

        return pricePerCup * quantity;
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view){
        if (quantity < 100) {
            quantity = quantity + 1;
        } else {
            quantity = 100;
        }
        display(quantity);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view){
        if (quantity > 0){
            quantity = quantity - 1;
        } else {
            quantity = 0;
        }
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}
