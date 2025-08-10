package net.weesli.veldoracore.api;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class AddonSettingsFile {

    private File file;
    private FileConfiguration configuration;
    private String moduleName;

    public AddonSettingsFile(String moduleName){
        this.moduleName = moduleName;
        file = new File(VeldoraCore.getInstance().getDataPath().resolve("addons/" + moduleName).toFile(), "settings.yml");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        create();
    }

    public void create(){
        configuration = YamlConfiguration.loadConfiguration(file);
        configuration.options().copyDefaults(true);
        save();
    }

    public void reload(){
        configuration = YamlConfiguration.loadConfiguration(file);
    }

    public void save(){
        try {
            configuration.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
