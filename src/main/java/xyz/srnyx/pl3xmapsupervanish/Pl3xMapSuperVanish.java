package xyz.srnyx.pl3xmapsupervanish;

import net.pl3x.map.core.Pl3xMap;
import net.pl3x.map.core.player.PlayerRegistry;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.srnyx.annoyingapi.AnnoyingPlugin;
import xyz.srnyx.pl3xmapsupervanish.messages.PMSVMessagesProvider;

import java.util.logging.Level;


public class Pl3xMapSuperVanish extends AnnoyingPlugin {
    @NotNull private final PlayerListener listener = new PlayerListener(this);
    @Nullable public PlayerRegistry mapPlayerRegistry;

    public Pl3xMapSuperVanish() {
        options.statsOptions(statsOptions -> statsOptions
                .bStats(bStatsOptions -> bStatsOptions.id(21336))
                .fastStats(fastStatsOptions -> fastStatsOptions.id("c508b6f390bba6c4b29536f40ccbda03")));
    }

    @Override @NotNull
    public PMSVMessagesProvider getMessages() {
        return (PMSVMessagesProvider) super.getMessages();
    }

    @Override
    public void enable() {
        reload();
    }

    @Override
    public void reload() {
        final PluginManager manager = Bukkit.getPluginManager();
        if (!manager.isPluginEnabled("SuperVanish") && !manager.isPluginEnabled("PremiumVanish")) {
            log(Level.SEVERE, "SuperVanish/PremiumVanish not found!");
            listener.unregister();
            return;
        }
        mapPlayerRegistry = Pl3xMap.api().getPlayerRegistry();
        listener.register();
    }
}
