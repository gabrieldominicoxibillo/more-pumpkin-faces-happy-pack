package com.more_pumpkin_faces.item.pumpkinhelmets;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

// Generic rotatable pumpkin block - works for all face types
public class RotatablePumpkinBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public RotatablePumpkinBlock(Settings settings) {
        super(settings);
        // Default facing north
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        // Face the block toward the player when placed
        return this.getDefaultState().with(FACING, context.getHorizontalPlayerFacing().getOpposite());
    }
}