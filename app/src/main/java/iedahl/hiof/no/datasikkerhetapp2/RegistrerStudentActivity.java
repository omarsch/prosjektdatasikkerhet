package iedahl.hiof.no.datasikkerhetapp2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;

public class RegistrerStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrer_student);

        final EditText txtNyStudentNavn = findViewById(R.id.txtNyStudentNavn);
        final EditText txtNyStudentEpost = findViewById(R.id.txtNyStudentEpost);
        final Spinner spnNyStudentKull = findViewById(R.id.spnNyStudentKull);
        final Spinner spnNyStudentStudie = findViewById(R.id.spnNyStudentStudie);
        final EditText txtNyStudentPassord = findViewById(R.id.txtNyStudentPassord);
        final Button btnNyStudentRegistrer = findViewById(R.id.btnNyStudentRegistrer);
        final ImageView imgTilbakeReg = findViewById(R.id.imgTilbakeReg);

        ArrayAdapter<CharSequence> studieAdapter = ArrayAdapter.createFromResource(this, R.array.studieprogram, android.R.layout.simple_spinner_item);
        studieAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnNyStudentStudie.setAdapter(studieAdapter);

        ArrayAdapter<CharSequence> kullAdapter = ArrayAdapter.createFromResource(this, R.array.kull, android.R.layout.simple_spinner_item);
        kullAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnNyStudentKull.setAdapter(kullAdapter);

        btnNyStudentRegistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(v.getContext());
                String url ="http://158.39.188.214/foreleser/api/student/add.php";

                String navn = txtNyStudentNavn.toString();
                String epost = txtNyStudentEpost.toString();
                String kull = spnNyStudentKull.getSelectedItem().toString();
                String studie = spnNyStudentStudie.getSelectedItem().toString();
                String passord = txtNyStudentPassord.toString();

                /*HashMap<String, String> params = new HashMap<String, String>();
                params.put("name", navn);
                params.put("password", passord);
                params.put("email", epost);
                params.put("course", studie);
                params.put("year", kull);*/

                //tester systemet med ferdige data
                HashMap<String, String> params = new HashMap<String, String>();
                params.put("name", "Enis");
                params.put("password", "esel123");
                params.put("email", "enisj@hiof.no");
                params.put("course", "4");
                params.put("year", "2020");

                // Request a string response from the provided URL.
                JsonObjectRequest req = new JsonObjectRequest(url, new JSONObject(params),
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                //VolleyLog.v("Response:%n %s", response.toString(4));
                                //hvis man blir logget inn og får en respons fra api'et skal det stå "yay" i tekstfeltet øverst
                                String test = "Yay!";
                                Toast.makeText(RegistrerStudentActivity.this, test, Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String err = "That didn't work!";
                        Toast.makeText(RegistrerStudentActivity.this, err, Toast.LENGTH_SHORT).show();
                    }
                });

                // Add the request to the RequestQueue.
                queue.add(req);
            }
        });

        imgTilbakeReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMain = new Intent (v.getContext(), MainActivity.class);
                startActivity(toMain);
            }
        });
    }
}
