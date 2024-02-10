package net.pmkjun.quitefishing.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.NetworkThreadUtils;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.listener.TickablePacketListener;
import net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.NoSuchElementException;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class FishingBobberSilentMixin implements TickablePacketListener, ClientPlayPacketListener {

    MinecraftClient client = MinecraftClient.getInstance();

    /**
     * @author
     * @reason
     */
    @Overwrite
    public void onPlaySound(PlaySoundS2CPacket packet) {
        NetworkThreadUtils.forceMainThread(packet, this, this.client);
        try {
            if (//FishHelperClient.getInstance().data.toggleMuteotherfishingbobber
                    packet.getSound().getKey().get().getValue().getPath().equals("entity.fishing_bobber.splash")) {
                System.out.println("sound ignored");
                return;
            }
        }
        catch (NoSuchElementException ignored){

        }
        this.client.world.playSound(this.client.player, packet.getX(), packet.getY(), packet.getZ(), packet.getSound(), packet.getCategory(), packet.getVolume(), packet.getPitch(), packet.getSeed());
    }



}
