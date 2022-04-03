package kr.honeybee.beemod.items;

import kr.honeybee.beemod.BeeMod;

public class ItemSavingBankBook extends BeeItem {
    public ItemSavingBankBook(String color) {
        super("savingbankbook_" + color, "savingbankbook_" + color);

        setCreativeTab(BeeMod.beeItemTab);
        setMaxStackSize(1);
    }
}
