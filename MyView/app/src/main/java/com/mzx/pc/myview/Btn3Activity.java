package com.mzx.pc.myview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017/5/5.
 * 描述：
 * 作者：Mazhixia
 * 手机：
 * 微信：
 * 日期：2017/5/5
 */



public class Btn3Activity extends AppCompatActivity {

    private com.mzx.pc.myview.btn3.CakeSurfaceView  cakeSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn3);

        cakeSurfaceView = (com.mzx.pc.myview.btn3.CakeSurfaceView ) findViewById(R.id.cakeSurfaceView1);
        List<com.mzx.pc.myview.btn3.CakeSurfaceView.CakeValue> cakeValues2 = new ArrayList<com.mzx.pc.myview.btn3.CakeSurfaceView.CakeValue>();
        cakeValues2.add(new com.mzx.pc.myview.btn3.CakeSurfaceView.CakeValue("在线", 15,"详细信息"));
        cakeValues2.add(new com.mzx.pc.myview.btn3.CakeSurfaceView.CakeValue("离线", 45,"详细信息自动换行"));
        cakeSurfaceView.setData(cakeValues2);
        //设置饼图信息的显示位置(目前只有bottom模式支持点击动画)
        cakeSurfaceView.setGravity(com.mzx.pc.myview.btn3.CakeSurfaceView.Gravity.bottom);
        //设置饼图信息与饼图的间隔(dp)
        cakeSurfaceView.setDetailTopSpacing(15);
        //设置饼图的每一项的点击事件
        cakeSurfaceView.setOnItemClickListener(new com.mzx.pc.myview.btn3.CakeSurfaceView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
//                Toast.makeText(Btn3Activity.this, "点击:" + position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
