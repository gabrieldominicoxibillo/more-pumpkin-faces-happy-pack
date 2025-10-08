package com.more_pumpkin_faces.item.pumpkinhelmets;

import net.minecraft.block.Block;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Equipment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

// This class creates a wearable pumpkin helmet with a happy face
// It extends BlockItem (so it's based on a block) and implements Equipment (so it can be worn)
public class PumpkinHelmetCrookedSmile extends BlockItem implements Equipment {

    // Constructor - called when creating a new instance of this item
    // Parameters:
    //   block - the pumpkin block this item represents
    //   settings - item properties like max stack size
    public PumpkinHelmetCrookedSmile(Block block, Settings settings) {
        // Call the parent BlockItem constructor
        super(block, settings);
    }

    // Required by Equipment interface
    // Tells Minecraft this item goes in the HEAD (helmet) slot
    @Override
    public EquipmentSlot getSlotType() {
        return EquipmentSlot.HEAD;
    }

    // Adds custom text when hovering over the item in inventory
    // Parameters:
    //   stack - the ItemStack being hovered over
    //   context - provides world/player context
    //   tooltip - the list of Text lines to display
    //   type - basic or advanced tooltip mode
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        // Add a custom tooltip line
        // Text.literal creates plain text
        // .formatted applies color formatting
        tooltip.add(Text.literal("This pumpkin looks cheerful!").formatted(Formatting.GOLD));

        // Call parent method to include any default tooltip lines
        super.appendTooltip(stack, context, tooltip, type);
    }
}