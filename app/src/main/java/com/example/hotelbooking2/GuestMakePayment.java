package com.example.hotelbooking2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GuestMakePayment extends AppCompatActivity implements View.OnClickListener {
    private EditText textViewCreditCardType,textViewCreditCardNumber,textViewNameonCard,textViewExpiryDate,textViewBillingAddress;
    private Button Make_Payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guestmakepayment);


        Make_Payment = (Button) findViewById(R.id.MAKE_PAYMENT);
        Make_Payment.setOnClickListener(this);

        textViewCreditCardType = (EditText) findViewById(R.id.CreditCardType);
        textViewCreditCardNumber = (EditText) findViewById(R.id.CreditCardNumber);
        textViewNameonCard = (EditText) findViewById(R.id.NameonCard);
        textViewExpiryDate = (EditText) findViewById(R.id.ExpiryDate);
        textViewBillingAddress = (EditText) findViewById(R.id.BillingAddress);

        textViewCreditCardType.setText(SharedPrefManager.getInstance(this).getUserCreditCardType());
        textViewCreditCardNumber.setText(SharedPrefManager.getInstance(this).getUserCreditCardNumber());
        textViewNameonCard.setText(SharedPrefManager.getInstance(this).getUserNameOnCard());
        textViewExpiryDate.setText(SharedPrefManager.getInstance(this).getUserExpiryDate());
        textViewBillingAddress.setText(SharedPrefManager.getInstance(this).getUserBillingAddress());





    }


    @Override
    public void onClick(View view) {
        if(view == Make_Payment){
            Toast.makeText(this, "PAYMENT SUCCESSFULL. RESERVATION COMPLETED.", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(), GuestHomeScreen.class));
        }

    }
}