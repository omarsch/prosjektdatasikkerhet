package iedahl.hiof.no.datasikkerhetapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //View variables
    private Button btnStudentLoggInn;
    private Button btnStudentRegistrer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStudentLoggInn = findViewById(R.id.btnStudentLoggInn);
        btnStudentRegistrer = findViewById(R.id.btnStudentRegistrer);

        btnStudentLoggInn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toStudentLoggInn = new Intent (v.getContext(), LoggInnStudentActivity.class);
                startActivity(toStudentLoggInn);
            }
        });

        btnStudentRegistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toStudentRegistrer = new Intent (v.getContext(), RegistrerStudentActivity.class);
                startActivity(toStudentRegistrer);
            }
        });
    }
}
