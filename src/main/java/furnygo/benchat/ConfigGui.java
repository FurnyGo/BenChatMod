package furnygo.benchat;

import fi.dy.masa.malilib.gui.GuiConfigsBase;
import org.apache.logging.log4j.LogManager;

import java.util.List;

public class ConfigGui extends GuiConfigsBase {
    public ConfigGui() {
        super(10, 50, "benchat", null, "BenChat config");
    }

    @Override
    public List<ConfigOptionWrapper> getConfigs() {
        return ConfigOptionWrapper.createFor(ChatUtilsConfig.OPTIONS);
    }

    @Override
    protected void onSettingsChanged() {
        super.onSettingsChanged();
        ChatUtilsConfig.saveToFile();
        ChatUtilsConfig.loadFromFile();
        LogManager.getLogger().info("Настройки сохранены.");
    }
}
