package net.pmkjun.quitefishing.fabric;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import eu.midnightdust.lib.config.MidnightConfig;
import net.pmkjun.quitefishing.QuiteFishing;

public class QuiteFishingModMenu implements ModMenuApi{
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
      return parent -> MidnightConfig.getScreen(parent, QuiteFishing.MOD_ID);
    }
}
