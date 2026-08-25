plugins {
    java
    id("xyz.srnyx.gradle-galaxy") version "c151767"
    id("com.gradleup.shadow") version "9.6.1"
    id("me.modmuss50.mod-publish-plugin") version "675051c"
    id("io.papermc.hangar-publish-plugin") version "0.1.4"
    id("xyz.jpenilla.run-paper") version "3.1.0"
}

group = "xyz.srnyx"
description = "Hide players vanished with SuperVanish on Pl3xMap"

galaxy {
    dependency {
        add {
            repositories.add("https://libraries.minecraft.net")
            group = "com.mojang"
            artifact = "brigadier"
            version = "1.0.18"
        }
    }

    minecraft {
        spigotAPI("1.19.4")
        annoyingAPI("45ae893")

        runPaper {
            action {
                downloadPlugins {
                    modrinth("pl3xmap", "1.21.11-539")
                    // SuperVanish isn't on/updated-on Modrinth/GitHub/etc.
                }
            }
        }

        dependency {
            required {
                repositories.add("https://api.modrinth.com/maven")
                group = "maven.modrinth"
                artifact = "pl3xmap"
                version = "1.19.4-SNAPSHOT"

                pluginYml = "Pl3xMap"
                modrinth = "pl3xmap"
                hangar = "Pl3xMap"
            }

            required {
                repositories.add(JITPACK)
                group = "com.github.LeonMangler"
                artifact = "SuperVanish"
                version = "6.2.18-3"

                // pluginYml not set because it can be either SuperVanish or PremiumVanish (softDepended manually)
                curseforge = "supervanish"
            }
        }

        pluginYml {
            developerData(SRNYX)
            main = "${getPackage()}.Pl3xMapSuperVanish"

            softDepend.addAll("SuperVanish", "PremiumVanish")
        }

        platformPublishing {
            github("srnyx/pl3xmap-supervanish")
            modrinth("46A5q0pA")
            hangar("Pl3xMap-SuperVanish")
            spigot("117638")
            curseforge("1051275")

            projectData("pl3xmap-supervanish")
        }
    }
}
