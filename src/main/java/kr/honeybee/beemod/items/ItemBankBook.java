package kr.honeybee.beemod.items;

import kr.honeybee.beemod.BeeMod;

public class ItemBankBook extends BeeItem {
    public ItemBankBook(String color) {
        super("bankbook_" + color, "bankbook_" + color);

        setCreativeTab(BeeMod.beeItemTab);
        setMaxStackSize(1);
    }
}
