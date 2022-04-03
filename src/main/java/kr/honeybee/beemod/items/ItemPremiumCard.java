package kr.honeybee.beemod.items;

import kr.honeybee.beemod.BeeMod;

public class ItemPremiumCard extends BeeItem {
    public ItemPremiumCard() {
        super("premium_card", "premium_card");

        setCreativeTab(BeeMod.beeItemTab);
        setMaxStackSize(1);
    }
}
