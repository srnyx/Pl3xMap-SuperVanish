package xyz.srnyx.pl3xmap.supervanish;

import de.myzelyam.api.vanish.PlayerHideEvent;
import de.myzelyam.api.vanish.PlayerShowEvent;

import net.pl3x.map.core.player.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import org.jetbrains.annotations.NotNull;

import xyz.srnyx.annoyingapi.AnnoyingListener;

import java.util.UUID;


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
        final Player player = plugin.mapPlayerRegistry.get(event.getPlayer().getUniqueId());
        if (player != null) player.setHidden(true, false);
    }

    @EventHandler
    public void onPlayerShow(@NotNull PlayerShowEvent event) {
        if (plugin.mapPlayerRegistry == null) return; // This should never happen, but just in case
        final Player player = plugin.mapPlayerRegistry.get(event.getPlayer().getUniqueId());
        if (player != null) player.setHidden(false, false);
    }

    @EventHandler
    public void onPlayerJoin(@NotNull PlayerJoinEvent event) {
        if (plugin.vanishStateManager == null || plugin.mapPlayerRegistry == null) return; // This should never happen, but just in case
        final UUID uuid = event.getPlayer().getUniqueId();
        final Player player = plugin.mapPlayerRegistry.get(uuid);
        if (player != null) player.setHidden(plugin.vanishStateManager.isVanished(uuid), false);
    }
}
