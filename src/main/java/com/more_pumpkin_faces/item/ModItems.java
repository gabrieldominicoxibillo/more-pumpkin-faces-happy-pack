package com.more_pumpkin_faces.item;

import com.more_pumpkin_faces.MorePumpkinFacesEmotions;
import com.more_pumpkin_faces.item.pumpkinhelmets.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import com.more_pumpkin_faces.block.ModBlocks;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.List;

// This class handles registering all the wearable pumpkin helmet items
// Each item is a BlockItem that can be worn in the helmet slot
public class ModItems {

    // Register each pumpkin helmet item
    // Each one:
    //   - Is a custom class (like PumpkinHelmetHappy) that extends BlockItem
    //   - References its corresponding block (from ModBlocks)
    //   - Has maxCount(1) so it can only stack to 1 (like armor)

    public static final Item PUMPKIN_HELMET_HAPPY = register(
            new PumpkinHelmetHappy(
                    ModBlocks.PUMPKIN_HAPPY_BLOCK,
                    new Item.Settings().maxCount(1)
            ),
            "pumpkin_helmet_happy"
    );

    public static final Item PUMPKIN_HELMET_EVIL_GRIN = register(
            new PumpkinHelmetEvilGrin(
                    ModBlocks.PUMPKIN_EVIL_GRIN_BLOCK,
                    new Item.Settings().maxCount(1)
            ),
            "pumpkin_helmet_evil_grin"
    );

    public static final Item PUMPKIN_HELMET_FRIENDLY_SMILE = register(
            new PumpkinHelmetFriendlySmile(
                    ModBlocks.PUMPKIN_FRIENDLY_SMILE_BLOCK,
                    new Item.Settings().maxCount(1)
            ),
            "pumpkin_helmet_friendly_smile"
    );

    public static final Item PUMPKIN_HELMET_TOOTHY_GRIN = register(
            new PumpkinHelmetToothyGrin(
                    ModBlocks.PUMPKIN_TOOTHY_GRIN_BLOCK,
                    new Item.Settings().maxCount(1)
            ),
            "pumpkin_helmet_toothy_grin"
    );

    public static final Item PUMPKIN_HELMET_WICKED_SMILE = register(
            new PumpkinHelmetWickedSmile(
                    ModBlocks.PUMPKIN_WICKED_SMILE_BLOCK,
                    new Item.Settings().maxCount(1)
            ),
            "pumpkin_helmet_wicked_smile"
    );

    public static final Item PUMPKIN_HELMET_MENACING_FANGS = register(
            new PumpkinHelmetMenacingFangs(
                    ModBlocks.PUMPKIN_MENACING_FANGS_BLOCK,
                    new Item.Settings().maxCount(1)
            ),
            "pumpkin_helmet_menacing_fangs"
    );

    public static final Item PUMPKIN_HELMET_SILLY_FACE = register(
            new PumpkinHelmetSillyFace(
                    ModBlocks.PUMPKIN_SILLY_FACE_BLOCK,
                    new Item.Settings().maxCount(1)
            ),
            "pumpkin_helmet_silly_face"
    );

    public static final Item PUMPKIN_HELMET_SCARY_TEETH = register(
            new PumpkinHelmetScaryTeeth(
                    ModBlocks.PUMPKIN_SCARY_TEETH_BLOCK,
                    new Item.Settings().maxCount(1)
            ),
            "pumpkin_helmet_scary_teeth"
    );

    public static final Item PUMPKIN_HELMET_TRIANGLE_EYES = register(
            new PumpkinHelmetTriangleEyes(
                    ModBlocks.PUMPKIN_TRIANGLE_EYES_BLOCK,
                    new Item.Settings().maxCount(1)
            ),
            "pumpkin_helmet_triangle_eyes"
    );

    public static final Item PUMPKIN_HELMET_CROOKED_SMILE = register(
            new PumpkinHelmetCrookedSmile(
                    ModBlocks.PUMPKIN_CROOKED_SMILE_BLOCK,
                    new Item.Settings().maxCount(1)
            ),
            "pumpkin_helmet_crooked_smile"
    );

    public static final Item PUMPKIN_HELMET_MONSTER_GRIN = register(
            new PumpkinHelmetMonsterGrin(
                    ModBlocks.PUMPKIN_MONSTER_GRIN_BLOCK,
                    new Item.Settings().maxCount(1)
            ),
            "pumpkin_helmet_monster_grin"
    );

    // Helper method to register an item
    // This reduces code duplication
    // Parameters:
    //   item - the Item instance to register
    //   path - the registry name (like "pumpkin_helmet_happy")
    // Returns: the registered item (so we can assign it to our static fields)

    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        Identifier itemID = Identifier.of(MorePumpkinFacesEmotions.MOD_ID, id);

        // Register the item.
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

        // Return the registered item!
        return registeredItem;
    }

    // This method is called from the main mod class
    // It forces the class to load and register all items
    public static void initialize() {
        MorePumpkinFacesEmotions.LOGGER.info("Registering items for " + MorePumpkinFacesEmotions.MOD_ID);
        // Get the event for modifying entries in the ingredients group.
// And register an event handler that adds our suspicious item to the ingredients group.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> { for (Item item : ModItems.ALL_ITEMS) { itemGroup.add(item); } });
   }


    public static final List<Item> ALL_ITEMS = List.of(
            // 🟠 Pumpkin Helmets
            PUMPKIN_HELMET_HAPPY



    );
}
