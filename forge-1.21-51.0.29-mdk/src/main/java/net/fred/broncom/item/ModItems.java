package net.fred.broncom.item;

import net.fred.broncom.BroncomMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.Registry;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BroncomMod.MOD_ID);

    public static final RegistryObject<Item> ENDERITE = ITEMS.register( "enderite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ENDERITE_SCRAP = ITEMS.register("enderite_scrap",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ENDERITE_CRYSTAL = ITEMS.register("enderite_crystal",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
