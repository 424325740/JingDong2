package com.example.administrator.jingdong.jiesuo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.jingdong.R;
import com.example.administrator.jingdong.view.activity.WelcomeActivity;


public class jiesuoActivity extends Activity {
    private wzb_gesturelockview2 mGestureLockViewGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiesuo);
        mGestureLockViewGroup = findViewById(R.id.id_gestureLockViewGroup);
        mGestureLockViewGroup.setAnswer(new int[]{1, 4, 7, 8, 9});
        mGestureLockViewGroup
                .setOnGestureLockViewListener(new wzb_gesturelockview2.OnGestureLockViewListener() {
                    @Override
                    public void onUnmatchedExceedBoundary() {
                        Toast.makeText(jiesuoActivity.this, "错误5次...",
                                Toast.LENGTH_SHORT).show();
                        mGestureLockViewGroup.setUnMatchExceedBoundary(5);
                        finish();
                    }
                    @Override
                    public void onGestureEvent(boolean matched) {
                        Toast.makeText(jiesuoActivity.this, matched + "",
                                Toast.LENGTH_SHORT).show();
                        if (matched==true){
                            Intent intent = new Intent(jiesuoActivity.this, WelcomeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                    @Override
                    public void onBlockSelected(int cId) {
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
