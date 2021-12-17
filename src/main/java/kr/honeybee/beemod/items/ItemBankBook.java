package kr.honeybee.beemod.items;

import kr.honeybee.beemod.BeeMod;

public class ItemBankBook extends BeeItem {
    public ItemBankBook() {
        super("bankbook", "bankbook");

        setCreativeTab(BeeMod.beeItemTab);
        setMaxStackSize(1);
    }
}
