package com.more_pumpkin_faces.item.pumpkinhelmets;

import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Equipment;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

// Generic wearable pumpkin helmet class
// Works for all pumpkin face types - no need for separate classes per face
public class PumpkinHelmet extends BlockItem implements Equipment {
    private final String faceName;

    // Constructor - stores which face type this helmet is
    public PumpkinHelmet(Block block, Settings settings, String faceName) {
        super(block, settings);
        this.faceName = faceName;
    }

    // Required by Equipment interface
    // Tells Minecraft this item goes in the HEAD (helmet) slot
    @Override
    public EquipmentSlot getSlotType() {
        return EquipmentSlot.HEAD;
    }

    // Adds custom tooltip text when hovering over the item
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        // Display the face type in the tooltip
        tooltip.add(Text.literal("A pumpkin with a " + faceName + " face!").formatted(Formatting.GOLD));
        super.appendTooltip(stack, context, tooltip, type);
    }
}