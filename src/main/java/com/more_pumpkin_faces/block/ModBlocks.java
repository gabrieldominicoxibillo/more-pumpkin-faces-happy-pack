package com.more_pumpkin_faces.block;

import com.more_pumpkin_faces.MorePumpkinFacesEmotions;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.more_pumpkin_faces.block.pumpkinhelmets.PumpkinHelmetHappyBlock;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import net.minecraft.block.Block;
import com.more_pumpkin_faces.block.pumpkinhelmets.RotatablePumpkinBlock;


public class ModBlocks {
    // Store all pumpkin blocks in a map for easy access
    public static final Map<String, Block> PUMPKIN_BLOCKS = new HashMap<>();

    // Define all your pumpkin face names in one place
    private static final String[] PUMPKIN_FACES = {
            "happy",
            "evil_grin",
            "friendly_smile",
            "toothy_grin",
            "wicked_smile",
            "menacing_fangs",
            "silly_face",
            "scary_teeth",
            "triangle_eyes",
            "crooked_smile",
            "monster_grin"
    };

    // Register all blocks at once
    static {
        for (String face : PUMPKIN_FACES) {
            String blockName = "pumpkin_helmet_" + face;
            Block block = register(
                    new RotatablePumpkinBlock(AbstractBlock.Settings.copy(Blocks.CARVED_PUMPKIN)),
                    blockName,
                    true
            );
            PUMPKIN_BLOCKS.put(face, block);
        }
    }

//  public static final Block PUMPKIN_HAPPY_BLOCK = register(
//          new PumpkinHelmetHappyBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()),
//          "pumpkin_helmet_happy",
//          true
//  );


//  public static final Block PUMPKIN_EVIL_GRIN_BLOCK = register(
//          new Block(AbstractBlock.Settings.copy(Blocks.CARVED_PUMPKIN)),
//          "pumpkin_evil_grin",
//          true
//  );

//  public static final Block PUMPKIN_FRIENDLY_SMILE_BLOCK = register(
//          new Block(AbstractBlock.Settings.copy(Blocks.CARVED_PUMPKIN)),
//          "pumpkin_friendly_smile",
//          true
//  );

//  public static final Block PUMPKIN_TOOTHY_GRIN_BLOCK = register(
//          new Block(AbstractBlock.Settings.copy(Blocks.CARVED_PUMPKIN)),
//          "pumpkin_toothy_grin",
//          true
//  );

//  public static final Block PUMPKIN_WICKED_SMILE_BLOCK = register(
//          new Block(AbstractBlock.Settings.copy(Blocks.CARVED_PUMPKIN)),
//          "pumpkin_wicked_smile",
//          true
//  );

//  public static final Block PUMPKIN_MENACING_FANGS_BLOCK = register(
//          new Block(AbstractBlock.Settings.copy(Blocks.CARVED_PUMPKIN)),
//          "pumpkin_menacing_fangs",
//          true
//  );

//  public static final Block PUMPKIN_SILLY_FACE_BLOCK = register(
//          new Block(AbstractBlock.Settings.copy(Blocks.CARVED_PUMPKIN)),
//          "pumpkin_silly_face",
//          true
//  );

//  public static final Block PUMPKIN_SCARY_TEETH_BLOCK = register(
//          new Block(AbstractBlock.Settings.copy(Blocks.CARVED_PUMPKIN)),
//          "pumpkin_scary_teeth",
//          true
//  );

//  public static final Block PUMPKIN_TRIANGLE_EYES_BLOCK = register(
//          new Block(AbstractBlock.Settings.copy(Blocks.CARVED_PUMPKIN)),
//          "pumpkin_triangle_eyes",
//          true
//  );

//  public static final Block PUMPKIN_CROOKED_SMILE_BLOCK = register(
//          new Block(AbstractBlock.Settings.copy(Blocks.CARVED_PUMPKIN)),
//          "pumpkin_crooked_smile",
//          true
//  );

//  public static final Block PUMPKIN_MONSTER_GRIN_BLOCK = register(
//          new Block(AbstractBlock.Settings.copy(Blocks.CARVED_PUMPKIN)),
//          "pumpkin_monster_grin",
//          true
//  );

    // --- Core register method ---
    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        Identifier id = Identifier.of(MorePumpkinFacesEmotions.MOD_ID, name);

        // Register the block itself
        Block registeredBlock = Registry.register(Registries.BLOCK, id, block);

        // Register the corresponding block item (so players can hold/place it)
        if (shouldRegisterItem) {
            Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));
        }

        return registeredBlock;
    }

   // // --- Init method to trigger registration ---
   // public static void initialize() {
   //     MorePumpkinFacesEmotions.LOGGER.info("Registering blocks for " + MorePumpkinFacesEmotions.MOD_ID);
   //     ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((entries) -> {
   //         entries.add(ModBlocks.PUMPKIN_BLOCKS.asItem());
//
   //     });
   // }

    // Init method to trigger registration
    // Called from your main mod class
    public static void initialize() {
        MorePumpkinFacesEmotions.LOGGER.info("Registering blocks for " + MorePumpkinFacesEmotions.MOD_ID);

        // Add all pumpkin blocks to the building blocks creative tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((entries) -> {
            for (Block block : PUMPKIN_BLOCKS.values()) {
                entries.add(block.asItem());
            }
        });
    }

}
