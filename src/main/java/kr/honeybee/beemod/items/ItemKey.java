package kr.honeybee.beemod.items;

import kr.honeybee.beemod.BeeMod;

public class ItemKey extends BeeItem {
    public ItemKey() {
        super("key", "key");

        setCreativeTab(BeeMod.beeItemTab);
        setMaxStackSize(1);
    }
}
