package net.ben.a_random_mod.item;

import net.ben.a_random_mod.ARandomMod;
import net.ben.a_random_mod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ARandomMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> COURSE_TAB=CREATIVE_MODE_TABS.register("course_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.CHEESE.get()))
                    .title(Component.translatable("creativetab.course_tab"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModItems.CHEESE.get());
                        output.accept(ModItems.CHEESE_ESSENCE.get());
                        output.accept(ModItems.LOOKY_LOOKY.get());
                        output.accept(ModBlocks.CHEESE_BLOCK.get());
                        output.accept(ModBlocks.CHEESE_ORE_BLOCK.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
