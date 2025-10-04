package net.pmkjun.quitefishing.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.pmkjun.quitefishing.util.QuiteFishingConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.NoSuchElementException;

@Mixin(ClientPacketListener.class)
public abstract class FishingBobberSilentMixin{

    Minecraft client = Minecraft.getInstance();

    @Inject(method = "handleSoundEvent(Lnet/minecraft/network/protocol/game/ClientboundSoundPacket;)V", at = {@At("HEAD")}, cancellable = true)
    public void handleSoundEvent(ClientboundSoundPacket packet, CallbackInfo info) {
        try{
            if(packet.getSound().unwrapKey().get().location().getPath().equals("entity.fishing_bobber.splash") &&
            QuiteFishingConfig.isMuteotherfishingbobber){
                info.cancel();
            }
        }
        catch(NoSuchElementException e){}
    }
}
