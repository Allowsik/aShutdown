package pl.allowsik;

import org.bukkit.plugin.java.JavaPlugin;

public final class aShutdown extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("shutdown").setExecutor(new Shutdown(this));
    }
}
