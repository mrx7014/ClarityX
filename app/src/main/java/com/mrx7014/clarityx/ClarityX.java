package com.mrx7014.clarityx;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.Arrays;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

@SuppressLint("DiscouragedPrivateApi")
@SuppressWarnings("ConstantConditions")
public class ClarityX implements IXposedHookLoadPackage {

    private static final String TAG = "ClarityX";

    // Packages to Spoof as OnePlus Pad Pro
    private static final String[] packagesToChangeOP8P = {
        "com.netease.lztgglobal",
        "com.pubg.imobile",
        "com.pubg.krmobile",
        "com.rekoo.pubgm",
        "com.riotgames.league.wildrift",
        "com.riotgames.league.wildrifttw",
        "com.riotgames.league.wildriftvn",
        "com.riotgames.league.teamfighttactics",
        "com.riotgames.league.teamfighttacticstw",
        "com.riotgames.league.teamfighttacticsvn",
        "com.tencent.ig",
        "com.tencent.tmgp.pubgmhd",
        "com.vng.pubgmobile",
        "vng.games.revelation.mobile",
        "com.ngame.allstar.eu",
        "com.mojang.minecraftpe",
        "com.YoStar.AetherGazer",
        "com.miHoYo.GenshinImpact",
        "com.garena.game.lmjx"
    };

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        String packageName = loadPackageParam.packageName;

        // OnePlus
        if (Arrays.asList(packagesToChangeOP8P).contains(packageName)) {
            propsToChangeOP8P();
            XposedBridge.log("Spoofed " + packageName + " as OnePlus Pad Pro");
        }
    }

    // Props to Spoof as OnePlus Pad Pro
    private static void propsToChangeOP8P() {
        setPropValue("MANUFACTURER", "OnePlus");
        setPropValue("MODEL", "OPD2404");
        serPropValue("SOC.MANUFACTURER", "SM8650-AB");
        setPropValue("GPU.MODEL", "Adreno750");
        setPropValue("FINGERPRINT", "oplus/ossi/ossi:14/UKQ1.231108.001/1726145855261:user/release-keys");
        setPropValue("ID", "UP1A.231005.007");
        
    }

    private static void setPropValue(String key, Object value) {
        try {
            Log.d(TAG, "Defining prop " + key + " to " + value.toString());
            Field field = Build.class.getDeclaredField(key);
            field.setAccessible(true);
            field.set(null, value);
            field.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            XposedBridge.log("Failed to set prop: " + key + "\n" + Log.getStackTraceString(e));
        }
    }
}
