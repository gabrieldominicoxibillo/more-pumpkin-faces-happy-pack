package com.more_pumpkin_faces;

import com.more_pumpkin_faces.block.ModBlocks;
import com.more_pumpkin_faces.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// This is the main class that Fabric calls when your mod loads
// It implements ModInitializer which is required for all Fabric mods
public class MorePumpkinFacesEmotions implements ModInitializer {

    // MOD_ID is used throughout your mod to identify your content
    // It must match the "id" field in fabric.mod.json
    public static final String MOD_ID = "more_pumpkin_faces_emotions";

    // Logger for debugging - helps you see what's happening in the console
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // This method runs when Minecraft loads your mod
    // It's called during game startup
    @Override
    public void onInitialize() {
        // Initialize blocks first - blocks must exist before items can reference them
        ModBlocks.initialize();

        // Initialize items second - items will reference the blocks we just created
        ModItems.initialize();

        // Log a message to confirm the mod loaded successfully
        LOGGER.info("More Pumpkin Faces: Emotions Pack has been loaded!");
    }
}