package xyz.srnyx.pl3xmap.supervanish;

import de.myzelyam.supervanish.SuperVanish;
import de.myzelyam.supervanish.visibility.FileVanishStateMgr;

import net.pl3x.map.core.Pl3xMap;
import net.pl3x.map.core.player.PlayerRegistry;

import org.bukkit.Bukkit;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import xyz.srnyx.annoyingapi.AnnoyingPlugin;


public class Pl3xMapSuperVanish extends AnnoyingPlugin {
    @NotNull private final PlayerListener listener = new PlayerListener(this);
    @Nullable public FileVanishStateMgr vanishStateManager;
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
        final SuperVanish superVanish = (SuperVanish) Bukkit.getPluginManager().getPlugin("SuperVanish");
        if (superVanish == null) { // This should never happen, but just in case
            LOGGER.severe("SuperVanish not found!");
            listener.unregister();
            return;
        }
        vanishStateManager = superVanish.getVanishStateMgr();
        mapPlayerRegistry = Pl3xMap.api().getPlayerRegistry();
        listener.register();
    }
}
