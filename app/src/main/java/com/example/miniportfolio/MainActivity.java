package com.example.miniportfolio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.textView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button secondActivityBtn = findViewById(R.id.btnAboutMe);
        secondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), com.example.miniportfolio.SecondActivity.class );
                startIntent.putExtra("com.example.miniportfolio.SOMETHING", "About me");
                startActivity(startIntent);
            }
        });

        Button portfolioView = findViewById((R.id.btnWebsiteView));
        portfolioView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String portfolio = "https://josephine-closan.netlify.app/";
                Uri webAddress = Uri.parse(portfolio);

                Intent goToMyPortfolio = new Intent(Intent.ACTION_VIEW, webAddress);

                startActivity(goToMyPortfolio);
            }
        });
    }
}