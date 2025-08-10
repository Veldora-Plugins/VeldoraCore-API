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
    private String moduleName;
    private Addon addon;

    public AddonSettingsFile(Addon addon, String moduleName){
        this.moduleName = moduleName;
        this.addon = addon;
        setup();
    }

    
    public FileConfiguration get(){
        return configuration;
    }

    public void setup() {
        file = new File(addon.getPlugin().getDataFolder(), "modules/" + addon.getName() + "/" + moduleName + ".yml");
        if (!file.exists()) {
            InputStream inputStream = addon.getClass().getClassLoader().getResourceAsStream(moduleName+".yml");
            if (inputStream == null) {
                addon.getPlugin().getLogger().severe(moduleName+ " not found in resources");
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
            addon.getPlugin().getLogger().severe("Failed to save "+moduleName+".yml: " + e.getMessage());
        }
    }

    public void reloadFile() {
        configuration = YamlConfiguration.loadConfiguration(file);
        InputStream defConfigStream = addon.getClass().getClassLoader().getResourceAsStream(moduleName+".yml");
        if (defConfigStream != null) {
            configuration.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream, Charsets.UTF_8)));
        }
    }

}
