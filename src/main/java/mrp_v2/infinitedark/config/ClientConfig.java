package mrp_v2.infinitedark.config;

import mrp_v2.infinitedark.InfiniteDark;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;

@Mod.EventBusSubscriber(modid = InfiniteDark.ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientConfig
{
    public static final String TRANSLATION_KEY = InfiniteDark.ID + ".config.gui.";
    public static final ClientConfig INSTANCE;
    public static final ForgeConfigSpec INSTANCE_SPEC;

    static
    {
        final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
        INSTANCE = specPair.getLeft();
        INSTANCE_SPEC = specPair.getRight();
    }

    private final ForgeConfigSpec.IntValue holdingDarkBlockBrightness;
    private int cachedColor;

    public ClientConfig(ForgeConfigSpec.Builder builder)
    {
        builder.comment(" Infinite Dark Client settings").push("client");
        holdingDarkBlockBrightness = builder.comment(" The brightness of dark blocks when a dark block is being held.")
                .translation(TRANSLATION_KEY + "holding_dark_block_brightness")
                .defineInRange("holding_dark_block_brightness", 64, 1, 255);
        builder.pop();
    }

    @SubscribeEvent public static void onFileChange(final ModConfig.Reloading configEvent)
    {
        LogManager.getLogger().debug(InfiniteDark.ID + " config just got changed on the file system!");
        INSTANCE.updateColor();
    }

    private void updateColor()
    {
        int color = this.holdingDarkBlockBrightness.get();
        this.cachedColor = (color << 16) | (color << 8) | color;
    }

    @SubscribeEvent public static void onLoad(final ModConfig.Loading configEvent)
    {
        LogManager.getLogger()
                .debug("Loaded " + InfiniteDark.ID + " config file {}", configEvent.getConfig().getFileName());
        INSTANCE.updateColor();
    }

    public int getColor()
    {
        return this.cachedColor;
    }
}
