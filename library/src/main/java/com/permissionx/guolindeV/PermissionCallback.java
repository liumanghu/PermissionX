package com.permissionx.guolindeV;

import java.util.List;

public abstract class PermissionCallback {
    public Boolean allGranded = null;
    public List<String> deniedList = null;

    public abstract void afterCallback();

}
