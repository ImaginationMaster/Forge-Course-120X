package net.fred.broncom.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.GatherComponentsEvent;

import java.util.List;

public class orb_of_sight_item extends Item {

    public orb_of_sight_item(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Player player = pContext.getPlayer();
        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();

            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 150; i++) {
                BlockState blockState = pContext.getLevel().getBlockState(positionClicked.below(i));

                if(isValuableBlock(blockState)){
                    outputValuableCoordinates(positionClicked.below(i),player, blockState.getBlock());
                    foundBlock = true;

                    break;
                }
            }

            if(!foundBlock) {
                outputNoValuableFound(player);
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, player, player.getEquipmentSlotForItem(player.getItemInHand(player.getUsedItemHand())));



        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag)
    {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.broncom.orb_of_sight.tooltip.shift"));
        }else{
            pTooltipComponents.add(Component.translatable("tooltip.broncom.orb_of_sight.tooltip"));
        }
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }

    private void outputNoValuableFound(Player player) {
        player.sendSystemMessage(Component.translatable( "item.broncom.orb_of_sight.no_valuables"));
    }

    private void outputValuableCoordinates(BlockPos below, Player player, Block block) {
        player.sendSystemMessage(Component.literal( "Valuable Found YAY! It's:  " + I18n.get(block.getDescriptionId()
        + "   at (" + below.getX() + ", " +  below.getY() + ", " +  below.getZ()+ ")")));
    }

    private boolean isValuableBlock(BlockState blockState) {
        return blockState.is(Blocks.DIAMOND_BLOCK) || blockState.is(Blocks.EMERALD_BLOCK) || blockState.is(Blocks.AMETHYST_BLOCK) || blockState.is(Blocks.GOLD_BLOCK) || blockState.is(Blocks.IRON_BLOCK) || blockState.is(Blocks.NETHERITE_BLOCK) || blockState.is(Blocks.DIAMOND_ORE) || blockState.is(Blocks.DEEPSLATE_DIAMOND_ORE) || blockState.is(Blocks.DEEPSLATE_GOLD_ORE)  || blockState.is(Blocks.DEEPSLATE_EMERALD_ORE) || blockState.is(Blocks.DEEPSLATE_IRON_ORE) || blockState.is(Blocks.DEEPSLATE_LAPIS_ORE) || blockState.is(Blocks.NETHER_QUARTZ_ORE) || blockState.is(Blocks.ANCIENT_DEBRIS) || blockState.is(Blocks.EMERALD_ORE) || blockState.is(Blocks.IRON_ORE) || blockState.is(Blocks.LAPIS_ORE) || blockState.is(Blocks.NETHER_QUARTZ_ORE) || blockState.is(Blocks.ENDER_CHEST) || blockState.is(Blocks.END_PORTAL_FRAME);
    }
}
