package kr.honeybee.beemod.items;

import kr.honeybee.beemod.BeeMod;
import net.minecraft.item.Item;

public class BeeItem extends Item {
    public BeeItem(String registryName, String translationKey) {
        setRegistryName(registryName);
        setTranslationKey(translationKey);

        setCreativeTab(BeeMod.beeTab);
    }
}
