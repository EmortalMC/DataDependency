package dev.emortal.datadependency;

import com.google.inject.Inject;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import org.litote.kmongo.serialization.SerializationClassMappingTypeService;

import java.util.logging.Logger;

@Plugin(id = "datadependency", name = "DataDependency")
public class VelocityPlugin {
    @Inject
    public void VelocityTest(ProxyServer server, Logger logger) {
        System.setProperty("org.litote.mongo.mapping.service", SerializationClassMappingTypeService.class.getName());
        logger.info("[DataDependency] Initialized!");
    }
}
