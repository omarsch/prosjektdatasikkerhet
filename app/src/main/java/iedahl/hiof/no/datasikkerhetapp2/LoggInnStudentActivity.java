package iedahl.hiof.no.datasikkerhetapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class LoggInnStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logg_inn_student);

        final EditText txtBrukernavnStudent = findViewById(R.id.txtBrukernavnStudent);
        final EditText txtPassordstudent = findViewById(R.id.txtPassordStudent);
        final TextView textview = findViewById(R.id.textView);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://158.39.188.214/foreleser/api/student/verify.php?EMAIL=enis_jasharaj@hotmail.com&PASSWORD=esel123";

        /*HashMap<String, String> params = new HashMap<String, String>();
        params.put("EMAIL", "enis_jasharaj@hotmail.com");
        params.put("PASSWORD", "esel123");*/

        // Request a string response from the provided URL.
        JsonObjectRequest req = new JsonObjectRequest(url, null,
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
