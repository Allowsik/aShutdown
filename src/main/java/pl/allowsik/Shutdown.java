package pl.allowsik;

import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class Shutdown implements CommandExecutor{

    private final aShutdown plugin;
    public Shutdown(aShutdown plugin){ this.plugin = plugin; }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(args.length==1) {
            Bukkit.getOnlinePlayers().forEach(p -> {
                p.showTitle(Title.title(Utils.colorMsg("&4&lRESTART"), Utils.colorMsg("&8Serwer zrestartuje się za &c" + args[0] + " &8sekund!")));
                p.sendMessage(Utils.colorMsg(" &4&lRESTART &7Serwer zrestartuje się za &c" + args[0] + " &7sekund!"));
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_PLACE, SoundCategory.MASTER, 1, 1);
            });

            new BukkitRunnable() {
                int time = Integer.parseInt(args[0]);
                @Override
                public void run() {
                    if (time == 0) {
                        stopServer();
                        cancel();
                    }
                    if (time==60 || time==30 || time==20 || time==10 || time==3 || time==2 || time==1){
                        Bukkit.broadcast(Utils.colorMsg(" &4&lRESTART &7Serwer zrestartuje się za &c" + time + " &7sekund"));
                        Bukkit.getOnlinePlayers().forEach(p -> {
                            p.showTitle(Title.title(Utils.colorMsg("&4&lRESTART"), Utils.colorMsg("&8Serwer zrestartuje się za &c" + time + " &8sekund!")));
                            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_PLACE, SoundCategory.MASTER, 1, 1);
                        });
                    }
                    time -= 1;
                }
            }.runTaskTimerAsynchronously(this.plugin, 0L, 20L);
            return true;
        }

        sender.sendMessage(Utils.colorMsg("&8>> &cPoprawne użycie: /shutdown <czas>"));
        return false;
    }
    public void stopServer(){
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getOnlinePlayers().forEach(p -> p.kick(Utils.colorMsg("&4&lRESTART&r &7Serwer się restartuje!")));
                Bukkit.shutdown();
            }
        }.runTask(plugin);
    }
}