package dev.emortal.datadependency;

import net.minestom.server.extensions.Extension;
import org.litote.kmongo.serialization.SerializationClassMappingTypeService;

public class MinestomExtension extends Extension {
    @Override
    public void initialize() {
        System.setProperty("org.litote.mongo.mapping.service", SerializationClassMappingTypeService.class.getName());
        getLogger().info("[DataDependency] Initialized!");
    }

    @Override
    public void terminate() {
        getLogger().info("[DataDependency] Terminated!");
    }
}
