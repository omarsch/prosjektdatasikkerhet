package iedahl.hiof.no.datasikkerhetapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoggInnStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logg_inn_student);

        final EditText txtBrukernavnStudent = findViewById(R.id.txtBrukernavnStudent);
        final EditText txtPassordstudent = findViewById(R.id.txtPassordStudent);
        final Button btnStudentLoggInn = findViewById(R.id.btnStudentLoggInn);
        final ImageView imgTilbakeLogin = findViewById(R.id.imgTilbakeLogin);

        btnStudentLoggInn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(v.getContext());
                String url ="http://158.39.188.214/foreleser/api/student/verify.php";

                // Request a string response from the provided URL.
                JsonObjectRequest req = new JsonObjectRequest(url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                //VolleyLog.v("Response:%n %s", response.toString(4));
                                //hvis man blir logget inn og får en respons fra serveren skal det dukke opp en toast med "yay" nederst
                                String test = "Yay!";
                                Toast.makeText(LoggInnStudentActivity.this, test, Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String err = "That didn't work!";
                        Toast.makeText(LoggInnStudentActivity.this, err, Toast.LENGTH_SHORT).show();
                    }
                })
                {
                    String brukernavn = txtBrukernavnStudent.toString();
                    String passord = txtPassordstudent.toString();

                    //legger til Headers
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String>();

                        /*headers.put("EMAIL", brukernavn);
                        headers.put("PASSWORD", passord);*/

                        //tester systemet med ferdige data
                        headers.put("EMAIL", "enis_jasharaj@hotmail.com");
                        headers.put("PASSWORD", "esel123");

                        return headers;
                    }

                };

                // Add the request to the RequestQueue.
                queue.add(req);
            }
        });

        imgTilbakeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMain = new Intent (v.getContext(), MainActivity.class);
                startActivity(toMain);
            }
        });
    }
}
