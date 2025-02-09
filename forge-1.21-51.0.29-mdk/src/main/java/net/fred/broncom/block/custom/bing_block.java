package net.fred.broncom.block.custom;

import net.fred.broncom.BroncomMod;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class bing_block extends Block {
    public bing_block(Properties pProperties) {
        super(pProperties);
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
}
