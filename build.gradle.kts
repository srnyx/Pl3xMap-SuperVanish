import xyz.srnyx.gradlegalaxy.enums.Repository
import xyz.srnyx.gradlegalaxy.enums.repository
import xyz.srnyx.gradlegalaxy.utility.setupAnnoyingAPI
import xyz.srnyx.gradlegalaxy.utility.spigotAPI


plugins {
    java
    id("xyz.srnyx.gradle-galaxy") version "1.2.2"
    id("io.github.goooler.shadow") version "8.1.8"
}

spigotAPI("1.19.4")
setupAnnoyingAPI("5.0.0", "xyz.srnyx", "1.1.1", "Hide players vanished with SuperVanish on Pl3xMap")

repository("https://api.modrinth.com/maven", "https://libraries.minecraft.net") // Pl3xMap & SuperVanish
repository(Repository.JITPACK) // SuperVanish

dependencies {
    compileOnly("maven.modrinth", "pl3xmap", "1.19.4-SNAPSHOT") // Pl3xMap
    compileOnly("com.github.LeonMangler", "SuperVanish", "6.2.18-3") // SuperVanish
    compileOnly("com.mojang", "brigadier", "1.0.18")
}
