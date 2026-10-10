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

dependencies {
    api("space.impact:Forgelin:2.1.1")
    implementation("com.github.GTNewHorizons:DuraDisplay:1.4.6:dev") {
        isTransitive = false
    }
    implementation("space.impact:gregtech-impact:5.09.35.37:dev") {
        exclude(group = "space.impact", module = "VirtualWorld")
    }

    runtimeOnlyNonPublishable("space.impact:VirtualWorld:2.0.3")
    runtimeOnlyNonPublishable("net.industrial-craft:industrialcraft-2:2.2.828-experimental:dev")
}
