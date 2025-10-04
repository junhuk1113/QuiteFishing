package net.pmkjun.quitefishing.fabric;

import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;
import net.pmkjun.quitefishing.QuiteFishing;
import net.pmkjun.quitefishing.util.QuiteFishingConfig;

public final class QuiteFishingFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MidnightConfig.init(QuiteFishing.MOD_ID, QuiteFishingConfig.class);
        QuiteFishing.init();
    }
}
