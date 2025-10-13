//#1 the block (rotatable pumpkin)
package com.more_pumpkin_faces.item.pumpkinhelmets;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

// how it all connects
//
//you’ll have three parts:
//
//your rotatable block → PumpkinHelmetHappyBlock (based on your Angry example)
//
//your wearable item → PumpkinHelmetHappy (extends BlockItem + Equipment)
//
//your blockstate JSON → controls which model faces which direction.

public class PumpkinHelmetHappyBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
//— This defines a new block class named PumpkinHelmetHappyBlock.
//— It inherits from Block, so it behaves like a normal block with extra custom behavior.
//— FACING is a property that tells Minecraft which direction the block is facing. Here, it uses HORIZONTAL_FACING (north, south, east, west only).
    public PumpkinHelmetHappyBlock(Settings settings) {
        super(settings);
        // default facing
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }
//— This runs when the block is created.
//— super(settings) passes the block’s settings (like strength, opacity) to the parent Block class.
//— setDefaultState(...) sets how the block faces by default. If you place it without special direction logic, it will face north.


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
//— This tells Minecraft which block states to track for this block.
//— Here it adds the FACING property so the game knows it can rotate and stores that direction in the world.


    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        // makes the block face the player when placed
        return this.getDefaultState().with(FACING, context.getHorizontalPlayerFacing().getOpposite());
    }
 //— This controls how the block decides its rotation when placed.
    //— context.getHorizontalPlayerFacing() gets the direction the player is facing.
    //— .getOpposite() flips it, so the pumpkin faces toward the player.
    //— It returns a new block state with that direction applied.

}
