package xyz.srnyx.pl3xmap.supervanish;

import net.pl3x.map.core.Pl3xMap;
import net.pl3x.map.core.player.PlayerRegistry;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import xyz.srnyx.annoyingapi.AnnoyingPlugin;


public class Pl3xMapSuperVanish extends AnnoyingPlugin {
    @NotNull private final PlayerListener listener = new PlayerListener(this);
    @Nullable public PlayerRegistry mapPlayerRegistry;

    public Pl3xMapSuperVanish() {
        options.bStatsOptions(bStatsOptions -> bStatsOptions.id(21336));
    }

    @Override
    public void enable() {
        reload();
    }

    @Override
    public void reload() {
        final PluginManager manager = Bukkit.getPluginManager();
        if (!manager.isPluginEnabled("SuperVanish") || !manager.isPluginEnabled("PremiumVanish")) {
            LOGGER.severe("SuperVanish/PremiumVanish not found!");
            listener.unregister();
            return;
        }
        mapPlayerRegistry = Pl3xMap.api().getPlayerRegistry();
        listener.register();
    }
}
