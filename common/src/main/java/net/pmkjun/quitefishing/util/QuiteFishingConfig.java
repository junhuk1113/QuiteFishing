package net.pmkjun.quitefishing.util;

import eu.midnightdust.lib.config.MidnightConfig;

/** Every option in a MidnightConfig class has to be public and static, so we can access it from other classes.
 * The config class also has to extend MidnightConfig*/

public class QuiteFishingConfig extends MidnightConfig {
    @Entry(category = "QuiteFishing") public static boolean isMuteotherfishingbobber = true;               // Example for a boolean option
    @Entry(category = "QuiteFishing", isSlider = true, min = 0f, max = 1f, precision = 1000) public static float floatSlider = 0.2f;
}
