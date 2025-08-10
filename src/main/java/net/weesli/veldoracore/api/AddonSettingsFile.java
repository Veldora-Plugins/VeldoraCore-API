package net.weesli.veldoracore.api;

import com.google.common.base.Charsets;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AddonSettingsFile {

    private File file;
    private FileConfiguration configuration;
    private Addon addon;

    public AddonSettingsFile(Addon addon){
        this.addon = addon;
        setup();
    }

    
    public FileConfiguration get(){
        return configuration;
    }

    public void setup() {
        file = new File(addon.getPlugin().getDataFolder(), "addons/" + addon.getName() + "/settings.yml");
        if (!file.exists()) {
            InputStream inputStream = addon.getClass().getClassLoader().getResourceAsStream("settings.yml");
            if (inputStream == null) {
                addon.getPlugin().getLogger().severe("Settings file not found in resources");
                return;
            }
            configuration = YamlConfiguration.loadConfiguration(new InputStreamReader(inputStream));
        } else {
            configuration = YamlConfiguration.loadConfiguration(file);
        }
    }

    public void save() {
        try {
            configuration.save(file);
        } catch (Exception e) {
            addon.getPlugin().getLogger().severe("Failed to save settings.yml: " + e.getMessage());
        }
    }

    public void reloadFile() {
        configuration = YamlConfiguration.loadConfiguration(file);
        InputStream defConfigStream = addon.getClass().getClassLoader().getResourceAsStream("settings.yml");
        if (defConfigStream != null) {
            configuration.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, Charsets.UTF_8)));
        }
    }

}
