package com.huangr.frameanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AnimationsContainer.FramesSequenceAnimation framesSequenceAnimation;
    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtControl = (TextView) findViewById(R.id.txt_control);
        ImageView ivDevSearching = (ImageView) findViewById(R.id.iv_dev_searching);

        txtControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPlaying){
                    framesSequenceAnimation.start();
                    txtControl.setText("结束帧动画");
                    isPlaying = true;
                }else{
                    framesSequenceAnimation.stop();
                    txtControl.setText("开始帧动画");
                    isPlaying = false;
                }
            }
        });
        /**
         * 将帧动画资源id以字符串数组形式写到values/arrays.xml中
         * FPS为每秒播放帧数，FPS = frame_anim1/T，（T--每帧间隔时间秒）
         */
        framesSequenceAnimation = AnimationsContainer.getInstance(this, R.array.loading_anim, 20)
                .createProgressDialogAnim(ivDevSearching);
    }
}
