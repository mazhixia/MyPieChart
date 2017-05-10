package com.mzx.pc.myview;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;
import static com.mzx.pc.myview.TransUtil.obj2Float;

public class MainActivity extends AppCompatActivity
{
    GraphicalView graphicalView;
    private double[] values;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //显示的数据
        values = new double[]{412f,542f};
        CategorySeries dataset=buildCategoryDataset("饼图", values);

        //显示的颜色
        int[] colors={Color.BLUE,Color.GREEN};
        DefaultRenderer renderer=buildCategoryRenderer(colors);

        graphicalView= ChartFactory.getPieChartView(getBaseContext(), dataset, renderer);//饼状图
        initValueAnimator();
     }

    /** 旋转展现动画 */
    private ValueAnimator cakeValueAnimator;

    //动画
    private void initValueAnimator() {

        PropertyValuesHolder angleValues = PropertyValuesHolder.ofFloat(
                "angle", 0f, 360f);
        cakeValueAnimator = ValueAnimator.ofPropertyValuesHolder(angleValues);
        cakeValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float mAngle = obj2Float(animation.getAnimatedValue("angle"));
//                curAngle = mAngle;
                drawArc();
             }
        });
        cakeValueAnimator.setDuration(1500);
        cakeValueAnimator.setRepeatCount(0);
        cakeValueAnimator.setInterpolator(new DecelerateInterpolator());
        cakeValueAnimator.setRepeatMode(ValueAnimator.RESTART);
        cakeValueAnimator.start();
    }

    private void drawArc() {
        LinearLayout layout=(LinearLayout)findViewById(R.id.linearlayout);
        layout.removeAllViews();
        layout.setBackgroundColor(Color.BLACK);
        layout.addView(graphicalView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
    }

    protected DefaultRenderer buildCategoryRenderer(int[] colors){
        DefaultRenderer renderer = new DefaultRenderer();

        renderer.setLegendTextSize(20);//设置左下角表注的文字大小
//        renderer.setZoomButtonsVisible(true);//设置显示放大缩小按钮
        renderer.setZoomEnabled(true);//设置不允许放大缩小.
        renderer.setChartTitleTextSize(30);//设置图表标题的文字大小
        renderer.setChartTitle("统计");//设置图表的标题  默认是居中顶部显示
        renderer.setLabelsTextSize(20);//饼图上标记文字的字体大小
        renderer.setLabelsColor(Color.WHITE);//饼图上标记文字的颜色
        renderer.setPanEnabled(false);//设置是否可以平移
        renderer.setDisplayValues(true);//是否显示值
        renderer.setClickEnabled(true);//设置是否可以被点击
        renderer.setStartAngle(180);// 设置为水平显示
        renderer.setInScroll(true);
        renderer.setMargins(new int[]{20, 30, 15, 0});




        //margins - an array containing the margin size values, in this order: top, left, bottom, right
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            r.setChartValuesFormat(NumberFormat.getPercentInstance());// 设置百分比
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    };

    protected CategorySeries buildCategoryDataset(String title, final double[] values)
    {
         CategorySeries series = new CategorySeries(title);
         series.add("在线  ("+doubleTrans(values[0])+" 个 )", values[0]/(values[0]+values[1]));
         series.add("离线  ("+doubleTrans(values[1])+" 个 )",values[1]/(values[0]+values[1]));

         return series;
    }

    //double型显示为整数
    public static String doubleTrans(double d){
        if(Math.round(d)-d==0){
            return String.valueOf((long)d);
        }
        return String.valueOf(d);
    }
}
