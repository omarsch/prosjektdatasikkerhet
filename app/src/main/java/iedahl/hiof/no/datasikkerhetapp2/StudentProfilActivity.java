package iedahl.hiof.no.datasikkerhetapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StudentProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profil);

        final ImageView imgTilbakeProf = findViewById(R.id.imgTilbakeProf);

        imgTilbakeProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMain = new Intent (v.getContext(), MainActivity.class);
                startActivity(toMain);
            }
        });
    }
}
