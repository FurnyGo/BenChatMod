package furnygo.benchat;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;

public class BenChatMod implements ModInitializer {
    @Override
    public void onInitialize() {
        // To prevent HeadlessExceptions when copying to clipboard.
        System.setProperty("java.awt.headless", "false");
        BenChatConfig.loadFromFile();
        LogManager.getLogger().info("§aBen activated!");
    }
}
