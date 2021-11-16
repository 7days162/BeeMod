package kr.honeybee.beemod.items;

import kr.honeybee.beemod.BeeMod;

public class ItemCard extends BeeItem {
    public ItemCard() {
        super("card", "card");

        setCreativeTab(BeeMod.beeItemTab);
        setMaxStackSize(1);
    }
}
