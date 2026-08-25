package xyz.srnyx.pl3xmapsupervanish.messages;

import org.jetbrains.annotations.NotNull;
import xyz.srnyx.annoyingapi.message.MessagesProvider;
import xyz.srnyx.pl3xmapsupervanish.Pl3xMapSuperVanish;


public class PMSVMessagesProvider extends MessagesProvider {
    @NotNull private final Pl3xMapSuperVanish plugin;

    public PMSVMessagesProvider(@NotNull Pl3xMapSuperVanish plugin) {
        this.plugin = plugin;

        defaults
                .prefix("&5&lPMAP-SV &8&l| &d")
                .p("&d")
                .s("&5");
    }

    @Override @NotNull
    public Pl3xMapSuperVanish getAnnoyingPlugin() {
        return plugin;
    }
}
