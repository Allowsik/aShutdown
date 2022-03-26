package pl.allowsik;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.LinearComponents;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.title.Title;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;

public class Utils {
    // Constants for title and chat prefixes
    static final Component PIGMC_TITLE = LinearComponents.linear(TextDecoration.BOLD,
            TextColor.color(0xaaaaaa), Component.text("» "),
            TextColor.color(0xf264db), Component.text("P"),
            TextColor.color(0xf46bcc), Component.text("i"),
            TextColor.color(0xf672bd), Component.text("g"),
            TextColor.color(0xf879ae), Component.text("M"),
            TextColor.color(0xf97f9f), Component.text("C"),
            TextColor.color(0xfb8690), Component.text("."),
            TextColor.color(0xfd8d81), Component.text("p"),
            TextColor.color(0xff9472), Component.text("l"),
            TextColor.color(0xaaaaaa), Component.text(" «")
    );

    static final String PIGMC_TEXT = "§x§f§2§6§4§d§b§lP§x§f§4§6§b§c§c§li§x§f§6§7§2§b§d§lg§x§f§8§7§9§a§e§lM§x§f§9§7§f§9§f§lC§x§f§b§8§6§9§0§l.§x§f§d§8§d§8§1§lp§x§f§f§9§4§7§2§ll §8§o» &7";

    // Methods to make notifications easier and faster
    public static void sendAnnouncement(Player p, String subtitle, String message, boolean showMsgPrefix){
        p.showTitle(Title.title(PIGMC_TITLE, Component.text(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', subtitle))));
        if (showMsgPrefix){
            p.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', message));
        } else {
            p.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', PIGMC_TEXT + message));
        }
        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.MASTER, 1, 1);
    }

    public static void sendAnnouncement(Player p, String message){
        p.showTitle(Title.title(PIGMC_TITLE, Component.text(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', message))));
        p.sendMessage(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', PIGMC_TEXT + message));
        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.MASTER, 1, 1);
    }

    public static Component colorMsg(String message){
        return Component.text(ChatColor.translateAlternateColorCodes('&',message));
    }


} //
