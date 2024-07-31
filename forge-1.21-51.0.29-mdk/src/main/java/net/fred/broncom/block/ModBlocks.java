package net.fred.broncom.block;

import net.fred.broncom.BroncomMod;
import net.fred.broncom.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
          DeferredRegister.create(ForgeRegistries.BLOCKS, BroncomMod.MOD_ID);

    public static final RegistryObject<Block> ENDERITE_BLOCK = registerBlock( "enderite_block",
            ()-> new Block(BlockBehaviour.Properties.of().destroyTime(7.0F).explosionResistance(100.0F).friction(0.1F).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ENDERITE_CRYSTAL_BLOCK = registerBlock( "enderite_crystal_block",
            ()-> new Block(BlockBehaviour.Properties.of().destroyTime(6.0F).explosionResistance(90.0F).friction(0.3F).requiresCorrectToolForDrops()));


    private static <T extends Block>  RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
       return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
       return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }



}
