package kr.honeybee.beemod.init;

import kr.honeybee.beemod.BeeMod;
import kr.honeybee.beemod.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.LinkedList;
import java.util.List;

public class RegistrationHandler {
    public static void init() {
        BeeBlocks.register();
        BeeItems.register();
    }

    @Mod.EventBusSubscriber(modid = Reference.MOD_ID)
    public static class Items {
        private static final List<Item> ITEMS = new LinkedList<>();

        static void add(Item item) {
            ITEMS.add(item);
        }

        public static List<Item> getItems() {
            return ITEMS;
        }

        @SubscribeEvent
        public static void register(final RegistryEvent.Register<Item> event) {
            ITEMS.forEach(event.getRegistry()::register);
            ITEMS.forEach(BeeMod.proxy::registerModel);
        }
    }

    @Mod.EventBusSubscriber
    public static class Blocks {
        private static final List<Block> BLOCKS = new LinkedList<>();

        static void add(Block block) {
            BLOCKS.add(block);
        }

        public static List<Block> getBlocks() {
            return BLOCKS;
        }

        @SubscribeEvent
        public static void register(final RegistryEvent.Register<Block> event) {
            BLOCKS.forEach(event.getRegistry()::register);
        }
    }

    @Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
    public static class Models {
        @SubscribeEvent
        public static void register(ModelRegistryEvent event) {
            Items.ITEMS.forEach(Models::registerRender);
        }

        private static void registerRender(Item item) {
            assert item.getRegistryName() != null;
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }
}
