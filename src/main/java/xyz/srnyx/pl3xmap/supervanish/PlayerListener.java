package xyz.srnyx.pl3xmap.supervanish;

import de.myzelyam.api.vanish.PlayerHideEvent;
import de.myzelyam.api.vanish.PlayerShowEvent;
import de.myzelyam.api.vanish.VanishAPI;

import net.pl3x.map.core.player.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import org.jetbrains.annotations.NotNull;

import xyz.srnyx.annoyingapi.AnnoyingListener;


public class PlayerListener extends AnnoyingListener {
    @NotNull private final Pl3xMapSuperVanish plugin;

    public PlayerListener(@NotNull Pl3xMapSuperVanish plugin) {
        this.plugin = plugin;
    }

    @Override @NotNull
    public Pl3xMapSuperVanish getAnnoyingPlugin() {
        return plugin;
    }

    @EventHandler
    public void onPlayerHide(@NotNull PlayerHideEvent event) {
        if (plugin.mapPlayerRegistry == null) return; // This should never happen, but just in case
        final Player mapPlayer = plugin.mapPlayerRegistry.get(event.getPlayer().getUniqueId());
        if (mapPlayer != null) mapPlayer.setHidden(true, false);
    }

    @EventHandler
    public void onPlayerShow(@NotNull PlayerShowEvent event) {
        if (plugin.mapPlayerRegistry == null) return; // This should never happen, but just in case
        final Player mapPlayer = plugin.mapPlayerRegistry.get(event.getPlayer().getUniqueId());
        if (mapPlayer != null) mapPlayer.setHidden(false, false);
    }

    @EventHandler
    public void onPlayerJoin(@NotNull PlayerJoinEvent event) {
        if (plugin.mapPlayerRegistry == null) return; // This should never happen, but just in case
        final org.bukkit.entity.Player player = event.getPlayer();
        final Player mapPlayer = plugin.mapPlayerRegistry.get(player.getUniqueId());
        if (mapPlayer != null) mapPlayer.setHidden(VanishAPI.isInvisible(player), false);
    }
}
