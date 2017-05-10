package com.mzx.pc.myview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Btn2Activity extends AppCompatActivity {

    private CakeSurfaceView cakeSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn2);

        cakeSurfaceView = (CakeSurfaceView) findViewById(R.id.cakeSurfaceView1);
        List<CakeSurfaceView.CakeValue> cakeValues2 = new ArrayList<CakeSurfaceView.CakeValue>();
        cakeValues2.add(new CakeSurfaceView.CakeValue("猫猫猫", 12f,"详细信息"));
        cakeValues2.add(new CakeSurfaceView.CakeValue("狗狗狗", 0f,"详细信息自动换行"));
        cakeValues2.add(new CakeSurfaceView.CakeValue("acorn", 24f,"橡果"));
        cakeValues2.add(new CakeSurfaceView.CakeValue("人人人", 0f));
        cakeValues2.add(new CakeSurfaceView.CakeValue("瓜皮", 0f));
        cakeValues2.add(new CakeSurfaceView.CakeValue("鸭嘴兽", 1f));
        cakeSurfaceView.setData(cakeValues2);
        //设置饼图信息的显示位置(目前只有bottom模式支持点击动画)
        cakeSurfaceView.setGravity(CakeSurfaceView.Gravity.bottom);
        //设置饼图信息与饼图的间隔(dp)
        cakeSurfaceView.setDetailTopSpacing(15);
        //设置饼图的每一项的点击事件
        cakeSurfaceView.setOnItemClickListener(new CakeSurfaceView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(Btn2Activity.this, "点击:" + position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
