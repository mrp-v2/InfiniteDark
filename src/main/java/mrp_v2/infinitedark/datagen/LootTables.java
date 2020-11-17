package mrp_v2.infinitedark.datagen;

import mrp_v2.infinitedark.util.ObjectHolder;
import net.minecraft.data.loot.BlockLootTables;

class LootTables extends mrp_v2.mrp_v2datagenlibrary.datagen.LootTables
{
    public LootTables()
    {
        this.addLootTable(ObjectHolder.DARK_BLOCK.get(), this::registerDropSelfLootTable);
        this.addLootTable(ObjectHolder.DARK_SLAB_BLOCK.get(),
                (block) -> this.registerLootTable(block, BlockLootTables::droppingSlab));
        this.addLootTable(ObjectHolder.DARK_STAIRS_BLOCK.get(), this::registerDropSelfLootTable);
        this.addLootTable(ObjectHolder.DARK_GLASS_BLOCK.get(), this::registerDropSelfLootTable);
    }
}
