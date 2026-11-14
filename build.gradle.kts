plugins {
    id("minecraft-setup")
    id("publish-setup")
}

impactMod {
    modId.set("gregtechbridge")
    modName.set("GregTechBridge")
    modGroup.set("space.impact.gregtechbridge")
    mavenGroup.set("space.impact")
    mavenUrl.set("https://maven.accident.space/repository/maven-releases/")
    usesMixins.set(true)
    mixinDebug.set(true)
    coreModClass.set("mixinplugin.VWEarlyMixins")
    shadeDependencies.set(true)
    minimizeShadedDependencies.set(true)
    relocateShadedDependencies.set(true)
}

val modId = impactMod.modId.get()
val modName = impactMod.modName.get()
val modGroup = impactMod.modGroup.get()

buildConfig {
    packageName(modGroup)
    buildConfigField("String", "MODID", "\"${modId}\"")
    buildConfigField("String", "MODNAME", "\"${modName}\"")
    buildConfigField("String", "VERSION", "\"${project.version}\"")
    buildConfigField("String", "GROUPNAME", "\"${modGroup}\"")
    buildConfigField("String", "MODADAPTER", "\"net.shadowfacts.forgelin.KotlinAdapter\"")
    useKotlinOutput {
        topLevelConstants = true
        internalVisibility = false
    }
}

dependencies {
    testImplementation("junit:junit:4.13.2")
    api("space.impact:Forgelin:2.1.3:dev")
    compileOnly("com.github.GTNewHorizons:NotEnoughItems:2.8.158-GTNH:dev")
    compileOnly("com.github.GTNewHorizons:DuraDisplay:1.4.6:dev") { isTransitive = false }
    compileOnly("com.github.GTNewHorizons:Applied-Energistics-2-Unofficial:rv3-beta-1099-GTNH:dev") { isTransitive = false }
    compileOnly("com.github.GTNewHorizons:NotEnoughEnergistics:1.8.0:dev") { isTransitive = false }
    compileOnly("com.github.GTNewHorizons:AE2FluidCraft-Rework:1.6.0-gtnh:dev") { isTransitive = false }
    compileOnly("space.impact:gregtech-impact:5.09.37.11:dev") { isTransitive = false }
    compileOnly("com.github.GTNewHorizons:modularui:1.1.24:dev") { isTransitive = false }
    compileOnly("com.github.GTNewHorizons:ModularUI2:2.3.92-1.7.10:dev") { isTransitive = false }
    compileOnly("curse.maven:minefactory-reloaded-66672:2366150") { isTransitive = false }
    compileOnly("net.industrial-craft:industrialcraft-2:2.2.828-experimental:dev")
    runtimeOnlyNonPublishable("net.industrial-craft:industrialcraft-2:2.2.828-experimental:dev")
    runtimeOnlyNonPublishable(modUtils.deobfuscate("curse.maven:journeymap-32274:4500659"))
    testRuntimeOnly("com.github.GTNewHorizons:WirelessCraftingTerminal:1.12.16:dev") { isTransitive = false }
    testRuntimeOnly("com.github.GTNewHorizons:waila:1.19.34:dev") { isTransitive = false }
    testRuntimeOnly("it.unimi.dsi:fastutil:8.5.18")
}

configurations.testImplementation {
    // The linkage tests read the same mod bytecode the bridge compiles against.
    extendsFrom(configurations.compileOnly.get())
}

tasks.test {
    useJUnit()
    javaLauncher.set(javaToolchains.launcherFor {
        languageVersion.set(JavaLanguageVersion.of(8))
    })
}
