import xyz.srnyx.gradlegalaxy.enums.Repository
import xyz.srnyx.gradlegalaxy.enums.repository
import xyz.srnyx.gradlegalaxy.utility.setupAnnoyingAPI
import xyz.srnyx.gradlegalaxy.utility.spigotAPI


plugins {
    java
    id("xyz.srnyx.gradle-galaxy") version "1.1.2"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

setupAnnoyingAPI("4460f574c3", "xyz.srnyx", "1.1.0", "Hide players vanished with SuperVanish on Pl3xMap")
spigotAPI("1.19.4")

repository("https://api.modrinth.com/maven", "https://libraries.minecraft.net") // Pl3xMap & SuperVanish
repository(Repository.JITPACK) // SuperVanish

dependencies {
    compileOnly("maven.modrinth", "pl3xmap", "1.19.4-SNAPSHOT") // Pl3xMap
    compileOnly("com.github.LeonMangler", "SuperVanish", "6.2.18-3") // SuperVanish
    compileOnly("com.mojang", "brigadier", "1.0.18")
}
