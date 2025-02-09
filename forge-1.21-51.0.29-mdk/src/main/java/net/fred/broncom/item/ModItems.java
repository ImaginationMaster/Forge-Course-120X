package net.fred.broncom.item;

import net.fred.broncom.BroncomMod;
import net.fred.broncom.item.custom.FeulItem;
import net.fred.broncom.item.custom.orb_of_sight_item;
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

    public static final RegistryObject<Item> ORB_OF_SIGHT = ITEMS.register("orb_of_sight",
            () -> new orb_of_sight_item(new Item.Properties().durability(1000)));

    public static final RegistryObject<Item> SMOOD = ITEMS.register("smood",
            () -> new Item(new Item.Properties().food(ModFoodProperties.SMOOD)));

    public static final RegistryObject<Item>  ULTRA_COAL= ITEMS.register("ultra_coal",
            () -> new FeulItem(new Item.Properties(), 2400));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
