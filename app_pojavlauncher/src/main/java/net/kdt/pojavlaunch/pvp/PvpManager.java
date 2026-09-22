package net.kdt.pojavlaunch.pvp;

import android.content.Context;
import android.content.SharedPreferences;

public final class PvpManager {

    private static final String PREFS_NAME = "abg_xs_pvp";
    private static final String KEY_PVP_ENABLED = "pvp_enabled";

    private PvpManager() {
    }

    public static boolean isEnabled(Context context) {
        return getPreferences(context).getBoolean(KEY_PVP_ENABLED, false);
    }

    public static void enable(Context context) {
        getPreferences(context)
                .edit()
                .putBoolean(KEY_PVP_ENABLED, true)
                .apply();
    }

    public static void disable(Context context) {
        getPreferences(context)
                .edit()
                .putBoolean(KEY_PVP_ENABLED, false)
                .apply();
    }

    public static boolean toggle(Context context) {
        boolean enabled = !isEnabled(context);

        getPreferences(context)
                .edit()
                .putBoolean(KEY_PVP_ENABLED, enabled)
                .apply();

        return enabled;
    }

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(
                PREFS_NAME,
                Context.MODE_PRIVATE
        );
    }
}
