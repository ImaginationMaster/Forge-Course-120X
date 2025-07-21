package net.ben.a_random_mod.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class Looky_looky extends Item {
    public Looky_looky(Properties pProperties){
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()){
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;
            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState blockState = pContext.getLevel().getBlockState(positionClicked.below(i));

                if (isValuableBlock(blockState)){
                    outputValuableCoordinates(positionClicked.below(i),player,blockState.getBlock());
                    foundBlock = true;
                    break;
                }
            }

            if(!foundBlock)  {
                outputNoValuableFound(player);
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.get)

                );

        return InteractionResult.SUCCESS;
    }

    private void outputNoValuableFound(Player player) {
        player.sendSystemMessage(Component.translatable( "item.mccourse.metal_detecter.no_valubles"));

    }

    private void outputValuableCoordinates(BlockPos below, Player player, Block block) {
        player.sendSystemMessage(Component.literal( "I looked at " + I18n.get(block.getDescriptionId()
                + "   at (" + below.getX() + ", " +  below.getY() + ", " +  below.getZ()+ ")")));
    }

    private boolean isValuableBlock(BlockState blockState) {
        return blockState.is(Blocks.CHEST) || blockState.is(Blocks.END_PORTAL_FRAME) || blockState.is(Blocks.ENDER_CHEST)
                || blockState.is(Blocks.NETHERITE_BLOCK) || blockState.is(Blocks.ANCIENT_DEBRIS) || blockState.is(Blocks.DIAMOND_BLOCK);
    }
}
