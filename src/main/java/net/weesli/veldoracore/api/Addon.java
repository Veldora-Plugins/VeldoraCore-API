package net.weesli.veldoracore.api;

public abstract class Addon {

    private final VeldoraCore plugin = VeldoraCore.getInstance();
    private final AddonSettingsFile settingsFile = new AddonSettingsFile(this.getName());

    public abstract String getName();

    public abstract String getVersion();

    public abstract String getDescription();

    public abstract String getAuthor();


    public abstract void onEnable();

    public abstract void onDisable();

}
