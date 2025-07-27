package net.fred.broncom.util;

import net.fred.broncom.BroncomMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(BroncomMod.MOD_ID, name);
        }

    }

    public static class Blocks {


        
    }
}
