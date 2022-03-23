package furnygo.benchat;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import fi.dy.masa.malilib.config.ConfigUtils;
import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.IConfigHandler;
import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.malilib.config.options.ConfigString;
import fi.dy.masa.malilib.util.FileUtils;
import fi.dy.masa.malilib.util.JsonUtils;

import java.io.File;

public class BenChatConfig implements IConfigHandler {
    public static final ImmutableList<IConfigBase> OPTIONS = getConfig();

    private static ImmutableList<IConfigBase> getConfig() {
        return ImmutableList.of(
                new ConfigString("copyMessage", Value.COPY_MESSAGE.getAsString(), "Message in the tooltip."),
                new ConfigBoolean("copyPreview", Value.PREVIEW_CONTENT.getAsBoolean(), "Preview content in the tooltip."),
                new ConfigBoolean("copyColors", Value.COPY_COLORS.getAsBoolean(), "Copy color codes or not."),
                new ConfigBoolean("tooltipEnabled", Value.TOOLTIP_ENABLED.getAsBoolean(), "Click to disable any sort of overlay when hovering a message."),
                new ConfigBoolean("enabled", Value.ENABLED.getAsBoolean(), "Enable?"),
                new ConfigBoolean("globalChat", Value.GLOBAL_MODE.getAsBoolean(), "Global chat"),
                new ConfigString("globalChatPrefix", Value.GLOBAL_PREFIX.getAsString(), "Clan chat prefix"),
                new ConfigBoolean("localChat", Value.LOCAL_MODE.getAsBoolean(), "Local chat"),
                new ConfigString("localChatPrefix", Value.LOCAL_PREFIX.getAsString(), "Clan chat prefix"),
                new ConfigBoolean("clanChat", Value.CLAN_MODE.getAsBoolean(), "Clan chat"),
                new ConfigString("clanChatPrefix", Value.CLAN_PREFIX.getAsString(), "Clan chat prefix"),
                new ConfigBoolean("privateChat", Value.PRIVATE_MODE.getAsBoolean(), "Private chat"),
                new ConfigString("privateChatPrefix", Value.PRIVATE_PREFIX.getAsString(), "Private chat prefix"),
                new ConfigString("privateChatArrow", Value.PRIVATE_ARROW.getAsString(), "Private chat arrow")
        );
    }

    public static void loadFromFile() {
        File configFile = new File(FileUtils.getConfigDirectory(), "benchat.json");

        if (configFile.exists() && configFile.isFile() && configFile.canRead()) {
            JsonElement element = JsonUtils.parseJsonFile(configFile);

            if (element != null && element.isJsonObject()) {
                JsonObject root = element.getAsJsonObject();
                ConfigUtils.readConfigBase(root, "BenChat", OPTIONS);
            }
        }
    }

    public static void saveToFile() {
        File dir = FileUtils.getConfigDirectory();

        if ((dir.exists() && dir.isDirectory()) || dir.mkdirs()) {
            JsonObject root = new JsonObject();
            ConfigUtils.writeConfigBase(root, "BenChat", OPTIONS);
            JsonUtils.writeJsonToFile(root, new File(dir, "benchat.json"));
        }
    }

    @Override
    public void load() {
        loadFromFile();
    }

    @Override
    public void save() {
        saveToFile();
    }

    private static ImmutableList<String> rawPresets() {
        ImmutableList.Builder<String> builder = ImmutableList.builder();
        return builder
                .add(Value.COPY_MESSAGE.getAsString())
                .add(Value.PREVIEW_CONTENT.getAsString())
                .add(Value.ENABLED.getAsString())
                .build();
    }

    public enum Value {
        COPY_MESSAGE("&9&lСкопировать текст"),
        PREVIEW_CONTENT("true"),
        COPY_COLORS("true"),
        TOOLTIP_ENABLED("true"),
        ENABLED("true"),
        GLOBAL_MODE("true"),
        GLOBAL_PREFIX("[ɢ]"),
        LOCAL_MODE("true"),
        LOCAL_PREFIX("[ʟ]"),
        CLAN_MODE("true"),
        CLAN_PREFIX("клан:"),
        PRIVATE_MODE("true"),
        PRIVATE_PREFIX("| ["),
        PRIVATE_ARROW("->");


        private final String value;

        Value(String value) {
            this.value = value;
        }

        public String getAsString() {
            return value;
        }

        public boolean getAsBoolean() {
            return Boolean.parseBoolean(value);
        }

        public double getAsDouble() {
            return Double.parseDouble(value);
        }
    }
}
