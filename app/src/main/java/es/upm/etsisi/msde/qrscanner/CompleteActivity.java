package es.upm.etsisi.msde.qrscanner;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CompleteActivity extends AppCompatActivity {

    private static final String TAG = "CompleteDeliveryActivity";

    TextView textViewCurrentBarcode;
    TextView textViewMessage;
    TextView textViewEmail;
    Button buttonCompleteDelivery;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);

        textViewMessage = findViewById(R.id.textViewMessage);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewCurrentBarcode = findViewById(R.id.textViewCurrentBarcode);
        buttonCompleteDelivery = findViewById(R.id.buttonCompleteDelivery);

        String sEmail = getIntent().getStringExtra("email");
        String sBarcode = getIntent().getStringExtra("barcode");
        Log.d(TAG, "signedInWithEmail:"+sEmail+"scannedQRCode: "+sBarcode);

        Toast.makeText(CompleteActivity.this, "QR " + sBarcode + " processed", Toast.LENGTH_SHORT).show();


        buttonCompleteDelivery.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(CompleteActivity.this, ScanActivity.class);
                intent.putExtra("email", getIntent().getStringExtra("email"));
                startActivity(intent);
                finish();

            }
        });


        textViewMessage.setText("Barcode successfully read !");
        textViewEmail.setText(sEmail);
        textViewCurrentBarcode.setText(sBarcode);

    }

}