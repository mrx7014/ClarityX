package com.mrx7014.clarityx;

import android.os.Build;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MainHook implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {        
        XposedBridge.log("ClarityX: Hooking into: " + lpparam.packageName);

        // ro.product.manufacturer
        XposedHelpers.setStaticObjectField(Build.class, "MANUFACTURER", "OnePlus");

        // ro.product.brand
        XposedHelpers.setStaticObjectField(Build.class, "BRAND", "oplus");

        // ro.product.device
        XposedHelpers.setStaticObjectField(Build.class, "DEVICE", "OPD2404");

        // ro.product.system.device
        XposedHelpers.setStaticObjectField(Build.class, "SYSTEM.DEVICE", "OPD2404");

        // ro.build.tags
        XposedHelpers.setStaticObjectField(Build.class, "TAGS", "release-keys");

        // ro.build.type
        XposedHelpers.setStaticObjectField(Build.class, "TYPE", "user");

        // ro.product.product
        XposedHelpers.setStaticObjectField(Build.class, "PRODUCT", "OPD2404");

        // ro.product.name
        XposedHelpers.setStaticObjectField(Build.class, "name", "OPD2404");

        // ro.product.system.name
        XposedHelpers.setStaticObjectField(Build.class, "name", "OPD2404");

        // ro.product.vendor.name
        XposedHelpers.setStaticObjectField(Build.class, "name", "OPD2404");

        // ro.product.system_ext.name
        XposedHelpers.setStaticObjectField(Build.class, "name", "OPD2404");

        // ro.product.system.name
        XposedHelpers.setStaticObjectField(Build.class, "SYSTEM.NAME", "OPD2404");

        // ro.product.vendor.name
        XposedHelpers.setStaticObjectField(Build.class, "VENDOR.NAME", "OPD2404");

        // ro.product.system_ext.name
        XposedHelpers.setStaticObjectField(Build.class, "SYSTEM_EXT.NAME", "OPD2404");

        // ro.system_ext.model
        XposedHelpers.setStaticObjectField(Build.class, "SYSTEM_EXT.MODEL", "OPD2404");

        // ro.product.model
        XposedHelpers.setStaticObjectField(Build.class, "PRODUCT.MODEL", "OPD2404");

        // ro.product.vendor.model
        XposedHelpers.setStaticObjectField(Build.class, "VENDOR.MODEL", "OPD2404");

        // ro.product.system.model
        XposedHelpers.setStaticObjectField(Build.class, "SYSTEM.MODEL", "OPD2404");

        // ro.product.flavor
        XposedHelpers.setStaticObjectField(Build.class, "FLAVOUR", "OPD2404-user");

        // ro.soc.model
        XposedHelpers.setStaticObjectField(Build.class, "SOC.MODEL", "SM8650-AB");

        // ro.product.board
        XposedHelpers.setStaticObjectField(Build.class, "BOARD", "OPD2404");

        // ro.build.id
        XposedHelpers.setStaticObjectField(Build.class, "ID", "UP1A.231005.007");

        // ro.build.fingerprint
        XposedHelpers.setStaticObjectField(Build.class, "FINGERPRINT", "oplus/ossi/ossi:14/UKQ1.231108.001/1726145855261:user/release-keys");
    }
}
