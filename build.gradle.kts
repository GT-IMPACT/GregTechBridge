import com.gtnewhorizons.retrofuturagradle.modutils.ModUtils
import settings.getVersionMod

plugins {
    alias(libs.plugins.setup.minecraft)
    alias(libs.plugins.setup.publish)
    id(libs.plugins.buildconfig.get().pluginId)
}

val modId: String by extra
val modName: String by extra
val modGroup: String by extra
val modAdapter: String by extra

extra.set("modVersion", getVersionMod())

buildConfig {
    packageName(modGroup)
    buildConfigField("String", "MODID", "\"${modId}\"")
    buildConfigField("String", "MODNAME", "\"${modName}\"")
    buildConfigField("String", "VERSION", "\"${getVersionMod()}\"")
    buildConfigField("String", "GROUPNAME", "\"${modGroup}\"")
    buildConfigField("String", "MODADAPTER", "\"${modAdapter}\"")
}

repositories {
    maven("https://maven.accident.space/repository/maven-public/") {
        mavenContent {
            includeGroup("space.impact")
            includeGroup("com.github.GTNewHorizons")
            includeGroupByRegex("space\\.impact\\..+")
        }
        credentials {
            username = System.getenv("MAVEN_USER") ?: "NONE"
            password = System.getenv("MAVEN_PASSWORD") ?: "NONE"
        }
    }
}

val modUtils = extensions.getByType<ModUtils>()

dependencies {
    testImplementation("junit:junit:4.13.2")
    // Regression fixture containing the legacy NEE integration used by Impact-Core.
    testImplementation("space.impact:Impact-Core:1.1.0.36:dev") {
        isTransitive = false
    }
    api("space.impact:Forgelin:2.1.1")
    implementation("com.github.GTNewHorizons:NotEnoughItems:2.8.158-GTNH:dev")
    implementation("com.github.GTNewHorizons:DuraDisplay:1.4.6:dev") {
        isTransitive = false
    }
    implementation("com.github.GTNewHorizons:Applied-Energistics-2-Unofficial:rv3-beta-1082-GTNH:dev")
    implementation("com.github.GTNewHorizons:NotEnoughEnergistics:1.7.47:dev")
    implementation("com.github.GTNewHorizons:AE2FluidCraft-Rework:1.5.113-gtnh:dev")
    // BlockCableBus exposes the optional RedNet interface in its class signature.
    compileOnly("curse.maven:minefactory-reloaded-66672:2366150") {
        isTransitive = false
    }
    implementation("space.impact:gregtech-impact:5.09.35.37:dev") {
        exclude(group = "space.impact", module = "VirtualWorld")
        exclude(group = "com.github.GTNewHorizons", module = "CodeChickenCore")
        exclude(group = "com.github.GTNewHorizons", module = "appliedenergistics2")
    }

    runtimeOnlyNonPublishable("space.impact:VirtualWorld:2.0.3") {
        exclude(group = "com.github.GTNewHorizons", module = "CodeChickenCore")
    }
    runtimeOnlyNonPublishable("net.industrial-craft:industrialcraft-2:2.2.828-experimental:dev")
    runtimeOnlyNonPublishable(modUtils.deobfuscate("curse.maven:journeymap-32274:4500659"))
}
