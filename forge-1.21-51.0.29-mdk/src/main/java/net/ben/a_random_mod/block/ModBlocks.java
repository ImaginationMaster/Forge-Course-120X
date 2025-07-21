package net.ben.a_random_mod.block;

import net.ben.a_random_mod.ARandomMod;
import net.ben.a_random_mod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ARandomMod.MOD_ID);

    public static final RegistryObject<Block> CHEESE_BLOCK = registerBlock("cheese_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instrument(NoteBlockInstrument.DIDGERIDOO)
                    .requiresCorrectToolForDrops().strength(0.5F, 6.0F).sound(SoundType.SOUL_SAND)));
    public static final RegistryObject<Block> CHEESE_ORE_BLOCK = registerBlock( "cheese_ore_block",
            ()-> new DropExperienceBlock(UniformInt.of(2,5), BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).strength(0.5F).requiresCorrectToolForDrops()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
