package com.masaibar.homewifi.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.masaibar.homewifi.R;
import com.masaibar.homewifi.utils.DebugUtil;

public class MapActivity extends AppCompatActivity {

    private static final String EXTRA_FENCE_ID = "fenceId";

    public static void start(Context context, String fenceId) {
        DebugUtil.assertion(!TextUtils.isEmpty(fenceId), "fenceId is empty");
        Intent intent = new Intent(context, MapActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(EXTRA_FENCE_ID, fenceId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    }
}
