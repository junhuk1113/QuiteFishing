package net.pmkjun.quitefishing.forge;

import net.pmkjun.quitefishing.QuiteFishing;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(QuiteFishing.MOD_ID)
public class QuiteFishingForge {
    public QuiteFishingForge() {
        QuiteFishing.init();
    }
}