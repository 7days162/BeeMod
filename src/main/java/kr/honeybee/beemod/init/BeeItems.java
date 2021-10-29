package kr.honeybee.beemod.init;

import kr.honeybee.beemod.items.ItemCard;
import net.minecraft.item.Item;

public class BeeItems {
    public static Item CARD;

    static {
        CARD = new ItemCard();
    }

    public static void register() {
        registerItem(CARD);
    }

    private static void registerItem(Item item) {
        RegistrationHandler.Items.add(item);
    }
}
