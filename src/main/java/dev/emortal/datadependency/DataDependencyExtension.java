package dev.emortal.datadependency;

import net.minestom.server.extensions.Extension;

public class DataDependencyExtension extends Extension {
    @Override
    public void initialize() {
        getLogger().info("[DataDependency] Initialized!");
    }

    @Override
    public void terminate() {
        getLogger().info("[DataDependency] Terminated!");
    }
}