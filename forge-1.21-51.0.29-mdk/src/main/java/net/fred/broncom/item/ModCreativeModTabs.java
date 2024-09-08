package net.fred.broncom.item;

import net.fred.broncom.BroncomMod;
import net.fred.broncom.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BroncomMod.MOD_ID);

public static final RegistryObject<CreativeModeTab> BRONCOM_ORES = CREATIVE_MODE_TABS.register("broncom",
        () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.ENDERITE.get()))
        .title(Component.translatable("creativetab.broncom"))
                .displayItems((itemDisplayParameters, output) -> {
                    output.accept(ModItems.ENDERITE.get());
                    output.accept(ModItems.ENDERITE_SCRAP.get());
                    output.accept(ModItems.ENDERITE_CRYSTAL.get());

                    output.accept(ModBlocks.ENDERITE_BLOCK.get());
                    output.accept(ModBlocks.ENDERITE_CRYSTAL_BLOCK.get());
                    output.accept(ModBlocks.ENDERITE_ORE_BLOCK.get());
                }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
