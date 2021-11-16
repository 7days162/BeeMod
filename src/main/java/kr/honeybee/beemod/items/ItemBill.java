package kr.honeybee.beemod.items;

import kr.honeybee.beemod.BeeMod;

public class ItemBill extends BeeItem{
    public ItemBill(String name) {
        super(name, name);

        setCreativeTab(BeeMod.beeItemTab);
    }
}
