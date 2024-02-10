package net.pmkjun.quitefishing.fabric;

import net.pmkjun.quitefishing.QuiteFishing;
import net.fabricmc.api.ModInitializer;

public class QuiteFishingFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        QuiteFishing.init();
    }
}