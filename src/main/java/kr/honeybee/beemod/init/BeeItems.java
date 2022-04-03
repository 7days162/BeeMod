package kr.honeybee.beemod.init;

import kr.honeybee.beemod.items.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BeeItems {
    public static Item CARD, PREMIUM_CARD;
    public static Item BANKBOOK_BLACK, BANKBOOK_BLUE, BANKBOOK_GRAY, BANKBOOK_GREEN, BANKBOOK_ORANGE, BANKBOOK_YELLOW, BANKBOOK_PURPLE;
    public static Item SAVINGBANKBOOK_BLUE, SAVINGBANKBOOK_PINK, SAVINGBANKBOOK_YELLOW;
    public static Item CHEON, OCHEON, MAN, OMAN;
    public static Item WHITE_UMBRELLA, YELLOW_UMBRELLA, WHITE_YELLOW_UMBRELLA;

    public static ItemBlock CLEAR_GLASS_ITEM;
    public static ItemBlock ATM_ITEM;

    static {
        CARD = new ItemCard();
        PREMIUM_CARD = new ItemPremiumCard();

        BANKBOOK_BLACK = new ItemBankBook("black"); // 예금통장
        BANKBOOK_BLUE = new ItemBankBook("blue"); // 예금통장
        BANKBOOK_GRAY = new ItemBankBook("gray"); // 예금통장
        BANKBOOK_GREEN = new ItemBankBook("green"); // 예금통장
        BANKBOOK_ORANGE = new ItemBankBook("orange"); // 예금통장
        BANKBOOK_YELLOW = new ItemBankBook("yellow"); // 예금통장
        BANKBOOK_PURPLE = new ItemBankBook("purple"); // 예금통장

        SAVINGBANKBOOK_BLUE = new ItemSavingBankBook("blue");
        SAVINGBANKBOOK_PINK = new ItemSavingBankBook("pink");
        SAVINGBANKBOOK_YELLOW = new ItemSavingBankBook("yellow");

        CHEON = new ItemBill("cheon");
        OCHEON = new ItemBill("ocheon");
        MAN = new ItemBill("man");
        OMAN = new ItemBill("oman");
        WHITE_UMBRELLA = new ItemUmbrella.WhiteUmbrella();
        YELLOW_UMBRELLA = new ItemUmbrella.YellowUmbrella();
        WHITE_YELLOW_UMBRELLA = new ItemUmbrella.WhiteYellowUmbrella();

        // ITEM BLOCK
        CLEAR_GLASS_ITEM = new ItemBlockBase(BeeBlocks.CLEAR_GLASS);
        ATM_ITEM = new ItemBlockBase(BeeBlocks.ATM);
    }

    public static void register() {
        registerItem(CARD);
        registerItem(BANKBOOK_BLACK);
        registerItem(BANKBOOK_GRAY);
        registerItem(BANKBOOK_BLUE);
        registerItem(BANKBOOK_GREEN);
        registerItem(BANKBOOK_ORANGE);
        registerItem(BANKBOOK_YELLOW);
        registerItem(BANKBOOK_PURPLE);
        registerItem(CHEON);
        registerItem(OCHEON);
        registerItem(MAN);
        registerItem(OMAN);

        registerItem(CLEAR_GLASS_ITEM);
        registerItem(ATM_ITEM);

        registerItem(WHITE_UMBRELLA);
        registerItem(YELLOW_UMBRELLA);
        registerItem(WHITE_YELLOW_UMBRELLA);

        registerItem(PREMIUM_CARD);
        registerItem(SAVINGBANKBOOK_BLUE);
        registerItem(SAVINGBANKBOOK_PINK);
        registerItem(SAVINGBANKBOOK_YELLOW);
    }

    private static void registerItem(Item item) {
        RegistrationHandler.Items.add(item);
    }
}
