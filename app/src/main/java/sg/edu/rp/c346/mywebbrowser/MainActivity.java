package sg.edu.rp.c346.mywebbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLoad;
    WebView wvMyPage;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoad = findViewById(R.id.btnLoad);
        wvMyPage = findViewById(R.id.wvView);
        et1 = findViewById(R.id.et1);


        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et1.getText().toString().length()==0){
                    Toast.makeText(MainActivity.this, "Write Something", Toast.LENGTH_LONG);
                    return;
                }
                String url = et1.getText().toString();
                WebSettings webSettings = wvMyPage.getSettings();
                webSettings.setJavaScriptEnabled(true);
                webSettings.setAllowFileAccess(false);
                webSettings.setBuiltInZoomControls(true);
                wvMyPage.loadUrl(url);
            }
        });

        wvMyPage.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }
}
