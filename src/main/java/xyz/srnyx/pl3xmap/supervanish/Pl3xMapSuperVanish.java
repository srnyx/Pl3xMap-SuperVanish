package xyz.srnyx.pl3xmap.supervanish;

import de.myzelyam.supervanish.SuperVanish;
import de.myzelyam.supervanish.visibility.FileVanishStateMgr;

import net.pl3x.map.core.Pl3xMap;
import net.pl3x.map.core.player.PlayerRegistry;

import org.bukkit.Bukkit;

import org.jetbrains.annotations.Nullable;

import xyz.srnyx.annoyingapi.AnnoyingPlugin;


public class Pl3xMapSuperVanish extends AnnoyingPlugin {
    @Nullable public FileVanishStateMgr vanishStateManager;
    @Nullable public PlayerRegistry mapPlayerRegistry;

    public Pl3xMapSuperVanish() {
        options
                .bStatsOptions(bStatsOptions -> bStatsOptions.id(21336))
                .registrationOptions.toRegister(new PlayerListener(this));
    }

    @Override
    public void enable() {
        final SuperVanish superVanish = (SuperVanish) Bukkit.getPluginManager().getPlugin("SuperVanish");
        if (superVanish == null) {
            getLogger().severe("SuperVanish not found! Disabling...");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        vanishStateManager = superVanish.getVanishStateMgr();
        mapPlayerRegistry = Pl3xMap.api().getPlayerRegistry();
    }
}
