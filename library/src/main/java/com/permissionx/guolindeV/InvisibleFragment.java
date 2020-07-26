package com.permissionx.guolindeV;

import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class InvisibleFragment extends Fragment {
    public PermissionCallback callback;

    public void requestNow (PermissionCallback cd,String[] permissions){
        callback = cd;
        requestPermissions(permissions,1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1){
            ArrayList<String> deniedList = new ArrayList<>();
            for (int i=0;i<grantResults.length;++i){
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED)deniedList.add(permissions[i]);
            }
            Boolean isEmpty = deniedList.isEmpty();
            callback.allGranded = isEmpty;
            callback.deniedList = deniedList;
            callback.afterCallback();
        }
    }
}
