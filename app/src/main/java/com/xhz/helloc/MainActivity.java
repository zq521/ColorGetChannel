package com.xhz.helloc;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.xhz.helloc.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        mBinding.btnGetChannel.setOnClickListener(this);
    }

    private native int[] getChannel(int color);

    @Override
    public void onClick(View view) {
        if (TextUtils.isEmpty(mBinding.etEditColor.getText())) {
            Toast.makeText(this, "请输入文本", Toast.LENGTH_SHORT).show();
            return;
        }

        long value = Long.parseLong(mBinding.etEditColor.getText().toString(), 16);
        int intValue = (int) value;
        int[] channel = getChannel(intValue);

        mBinding.etAlpha.setText(String.valueOf(channel[0]));
        mBinding.etRed.setText(String.valueOf(channel[1]));
        mBinding.etGreen.setText(String.valueOf(channel[2]));
        mBinding.etBlue.setText(String.valueOf(channel[3]));


    }

    static {
        System.loadLibrary("native-lib");
    }
}
