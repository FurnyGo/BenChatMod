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
                new ConfigBoolean("globalChat", Value.GLOBAL_MODE.getAsBoolean(), "Global chat"),
                new ConfigString("globalChatPrefix", Value.GLOBAL_PREFIX.getAsString(), "Global chat prefix"),
                new ConfigString("globalChatCommand", Value.GLOBAL_COMMAND.getAsString(), "Global chat command"),
                new ConfigBoolean("globalChatAntiAntiSpam", Value.GLOBAL_SPAM.getAsBoolean(), "Global chat antiantispam"),
                new ConfigBoolean("globalChatColor", Value.GLOBAL_COLOR.getAsBoolean(), "Global chat color"),


                new ConfigBoolean("localChat", Value.LOCAL_MODE.getAsBoolean(), "Local chat"),
                new ConfigString("localChatPrefix", Value.LOCAL_PREFIX.getAsString(), "Local chat prefix"),
                new ConfigString("localChatCommand", Value.LOCAL_COMMAND.getAsString(), "LOCAL chat command"),
                new ConfigBoolean("localChatAntiAntiSpam", Value.LOCAL_SPAM.getAsBoolean(), "Local chat antiantispam"),
                new ConfigBoolean("localChatColor", Value.LOCAL_COLOR.getAsBoolean(), "Local chat color"),


                new ConfigBoolean("clanChat", Value.CLAN_MODE.getAsBoolean(), "Clan chat"),
                new ConfigString("clanChatPrefix", Value.CLAN_PREFIX.getAsString(), "Clan chat prefix"),
                new ConfigString("clanChatCommand", Value.CLAN_COMMAND.getAsString(), "Clan chat command"),
                new ConfigBoolean("clanChatAntiAntiSpam", Value.CLAN_SPAM.getAsBoolean(), "Clan chat antiantispam"),
                new ConfigBoolean("clanChatColor", Value.CLAN_COLOR.getAsBoolean(), "Clan chat color"),


                new ConfigBoolean("privateChat", Value.PRIVATE_MODE.getAsBoolean(), "Private chat"),
                new ConfigString("privateChatPrefix", Value.PRIVATE_PREFIX.getAsString(), "Private chat prefix"),
                new ConfigString("privateChatArrow", Value.PRIVATE_ARROW.getAsString(), "Private chat arrow"),
                new ConfigString("privateChatCommand", Value.PRIVATE_COMMAND.getAsString(), "Private chat command"),
                new ConfigBoolean("privateChatAntiAntiSpam", Value.PRIVATE_SPAM.getAsBoolean(), "Private chat antiantispam"),
                new ConfigBoolean("privateChatColor", Value.PRIVATE_COLOR.getAsBoolean(), "Private chat color")
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

    /*private static ImmutableList<String> rawPresets() {
        ImmutableList.Builder<String> builder = ImmutableList.builder();
        return builder
                .add(Value.COPY_MESSAGE.getAsString())
                .add(Value.PREVIEW_CONTENT.getAsString())
                .add(Value.ENABLED.getAsString())
                .build();
    }*/

    public enum Value {
        GLOBAL_MODE("true"),
        GLOBAL_PREFIX("[ɢ]"),
        GLOBAL_COMMAND("!"),
        GLOBAL_SPAM("true"),
        GLOBAL_COLOR("true"),
        LOCAL_MODE("true"),
        LOCAL_PREFIX("[ʟ]"),
        LOCAL_COMMAND(""),
        LOCAL_SPAM("true"),
        LOCAL_COLOR("true"),
        CLAN_MODE("true"),
        CLAN_PREFIX("клан:"),
        CLAN_COMMAND("/cc"),
        CLAN_SPAM("false"),
        CLAN_COLOR("false"),
        PRIVATE_MODE("true"),
        PRIVATE_PREFIX("| ["),
        PRIVATE_ARROW("->"),
        PRIVATE_COMMAND("/tell"),
        PRIVATE_SPAM("true"),
        PRIVATE_COLOR("true");


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

        /*public double getAsDouble() {
            return Double.parseDouble(value);
        }*/
    }
}
