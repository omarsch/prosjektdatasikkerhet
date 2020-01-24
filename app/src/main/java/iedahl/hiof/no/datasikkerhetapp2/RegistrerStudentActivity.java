package iedahl.hiof.no.datasikkerhetapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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
        final TextView textview = findViewById(R.id.textView4);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://158.39.188.214/foreleser/api/student/add.php";

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
                        textview.setText(test);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String err = "That didn't work!";
                textview.setText(err);
            }
        });

        // Add the request to the RequestQueue.
        queue.add(req);

    }
}
