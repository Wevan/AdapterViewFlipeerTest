package com.example.wean.adapterviewflipeertest;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int[] imageIds =new int[]{
            R.drawable.shuangzi,R.drawable.shuangyu,R.drawable.baiyang,R.drawable.chunv,R.drawable.jinniu,R.drawable.juxie,R.drawable.sheshou,R.drawable.shizi,R.drawable.shuiping,R.drawable.mojie,R.drawable.tiancheng
    };
    private AdapterViewFlipper flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flipper= (AdapterViewFlipper) findViewById(R.id.flipper);
        BaseAdapter adapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ImageView imageView=new ImageView(MainActivity.this);
                imageView.setImageResource(imageIds[i]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };
        flipper.setAdapter(adapter);
    }
    public void prev(View source){
        flipper.showPrevious();
        flipper.stopFlipping();
    }
    public void next(View source){
        flipper.showNext();
        flipper.stopFlipping();
    }
    public void auto(View source){
        flipper.startFlipping();
        flipper.setFlipInterval(1000);
    }
}
