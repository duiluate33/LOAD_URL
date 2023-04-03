package kr.ac.yeonsung.seoj.mobile1project_0829_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editUrl;
    WebView webV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editUrl = findViewById(R.id.edit_url);
        webV = findViewById(R.id.web_v);
        Button btnGo = findViewById(R.id.btn_go);
        Button btnBack = findViewById(R.id.btn_back); //다음으로 리스너 설정하기
        btnGo.setOnClickListener(btnListener); //연결하기
        btnBack.setOnClickListener(btnListener);//클릭된 아이디값에 따라 btngo 인지 btnback인지 달라지게 함
        webV.setWebViewClient(new WebViewClient1());
        WebSettings webSet = webV.getSettings();
        webSet.setBuiltInZoomControls(true); //확대,축소 가능하게함
        webSet.setJavaScriptEnabled(true); // 자바스크립트가 웹뷰에서 실행가능하게 함

    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_go: //go버튼이 클릭되었을때
                    webV.loadUrl(editUrl.getText().toString());
                    //에디트텍스트에 입력된 url을 전달해주면 아까 작성한 shouldOverrideUrlLoading이 실행됨
                    break;
                case R.id.btn_back:
                    webV.goBack(); //이전 화면으로 돌아감
                    break;
            }
        }
    };
    class WebViewClient1 extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}