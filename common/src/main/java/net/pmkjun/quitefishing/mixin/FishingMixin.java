package net.pmkjun.quitefishing.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.pmkjun.quitefishing.QuiteFishing;
import net.pmkjun.quitefishing.util.QuiteFishingConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(FishingHook.class)
public abstract class FishingMixin {
    private static final Logger LOGGER = LogManager.getLogger(QuiteFishing.MOD_ID);
    private static final Minecraft mc = Minecraft.getInstance();
    private boolean previouscaughtFish = false;

    @Shadow
    private boolean biting;

    @Shadow @Nullable public abstract Player getPlayerOwner();
    
    @Inject(method = "tick",at = @At("HEAD"))
    private void ontickMixin(CallbackInfo ci){
        String bobberOwner;
        try{
            bobberOwner = getPlayerOwner().getName().getString();
        }
        catch (NullPointerException e){
            //System.out.println("null2!");
            return;
        }

        if(bobberOwner.equals(mc.player.getName().getString()) && QuiteFishingConfig.isMuteotherfishingbobber
            && mc.isSameThread()){
            if(!previouscaughtFish && biting){
                LOGGER.info("fishBobber splash!");
                mc.getSoundManager().play(SimpleSoundInstance.forLocalAmbience(SoundEvents.FISHING_BOBBER_SPLASH,1.0F,QuiteFishingConfig.floatSlider));
                previouscaughtFish = true;
            }
            if(previouscaughtFish && !biting){
                previouscaughtFish = false;
            }

        }

    }


}