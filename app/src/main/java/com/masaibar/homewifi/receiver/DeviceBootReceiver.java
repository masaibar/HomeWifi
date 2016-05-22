package com.masaibar.homewifi.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.masaibar.homewifi.Geo;
import com.masaibar.homewifi.GeoHashMap;
import com.masaibar.homewifi.GeoHashMapManager;
import com.masaibar.homewifi.utils.DebugUtil;
import com.masaibar.homewifi.utils.GeofenceManager;

import java.util.Map;

/**
 * Created by masaibar on 2016/05/22.
 */
public class DeviceBootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        DebugUtil.log("!!! BootCompletedReceiver onReceive, action :" + intent.getAction());

        GeoHashMap geoHashMap = GeoHashMapManager.getInstance().getSavedGeoHashMap(context);

        //保存されているGeoFenceをぜんぶ舐めて、設定が有効なら再設定を行う
        for (Map.Entry<String, Geo> entry : geoHashMap.entrySet()) {
            String fenceId = entry.getKey();
            Geo geo = entry.getValue();
            if (geo.isEnabled()) {
                new GeofenceManager(context).update(fenceId, geo);
            }
        }
    }
}
