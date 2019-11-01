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
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String createOrderSummary(){
        String name = "Bheki-nkosi Khosa";
        return ("Name: " + name + "\nQuantity: " + quantity + "\nTotal: R " + quantity * 5 + "\nThank you!");
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        displayMessage(createOrderSummary());
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view){
        quantity = quantity + 1;
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
