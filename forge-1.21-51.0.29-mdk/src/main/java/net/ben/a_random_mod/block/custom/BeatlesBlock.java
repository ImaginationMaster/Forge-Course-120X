package net.ben.a_random_mod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BeatlesBlock extends Block {
    public BeatlesBlock(Properties pPropeties) {
        super(pPropeties);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState,
                                              Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
            if (pPlayer.isCrouching()){
                pLevel.playSound(null,pPos, SoundEvents.GENERIC_EXPLODE.get(), SoundSource.BLOCKS, 4.5f, 1.0f);
                return ItemInteractionResult.SUCCESS;
            } else {
                pLevel.playSound(null,pPos, SoundEvents.NOTE_BLOCK_BELL.get(), SoundSource.BLOCKS, 1.5f, 3.5f);
                return ItemInteractionResult.CONSUME;
            }
        }

        return super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult);

    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        pLevel.playSound(pEntity, pPos, SoundEvents.NOTE_BLOCK_BELL.get(), SoundSource.BLOCKS, 1f, 1f);
        super.stepOn(pLevel, pPos, pState, pEntity);
    }

}
