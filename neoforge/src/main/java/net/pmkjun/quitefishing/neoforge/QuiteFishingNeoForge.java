package net.pmkjun.quitefishing.neoforge;

import eu.midnightdust.lib.config.MidnightConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.pmkjun.quitefishing.QuiteFishing;
import net.neoforged.fml.common.Mod;
import net.pmkjun.quitefishing.util.QuiteFishingConfig;

@Mod(QuiteFishing.MOD_ID)
public final class QuiteFishingNeoForge {
    public QuiteFishingNeoForge(IEventBus modEventBus, ModContainer modContainer) {
        QuiteFishing.init();
        MidnightConfig.init(QuiteFishing.MOD_ID, QuiteFishingConfig.class);
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, (mc, screen) -> MidnightConfig.getScreen(screen, QuiteFishing.MOD_ID));
    }
}
