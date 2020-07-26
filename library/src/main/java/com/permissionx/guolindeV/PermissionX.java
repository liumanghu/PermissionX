package com.permissionx.guolindeV;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class PermissionX {
    private static final String TGA = "InvisibleFragment";
    private static PermissionX permissionX;

    private PermissionX(){

    }

    public static PermissionX getInstance(){
        if (permissionX == null){
            permissionX = new PermissionX();
        }
        return permissionX;
    }

    public void request(FragmentActivity activity,String[] permissions,PermissionCallback callback){
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        Fragment existedFragment = fragmentManager.findFragmentByTag(TGA);
        InvisibleFragment fragment;
        if (existedFragment != null) fragment = (InvisibleFragment) existedFragment;
        else {
            InvisibleFragment invisibleFragment = new InvisibleFragment();
            fragmentManager.beginTransaction().add(invisibleFragment,TGA).commitNow();
            fragment = invisibleFragment;
        }
        fragment.requestNow(callback,permissions);
    }
}
