package mrp_v2.infinitedark.datagen;

import mrp_v2.infinitedark.util.ObjectHolder;
import net.minecraft.data.loot.BlockLoot;

class LootTables extends mrp_v2.mrplibrary.datagen.BlockLootTables
{
    public LootTables()
    {
        this.addLootTable(ObjectHolder.DARK_BLOCK.get(), this::dropSelf);
        this.addLootTable(ObjectHolder.DARK_SLAB_BLOCK.get(),
                (block) -> this.add(block, BlockLoot::createSlabItemTable));
        this.addLootTable(ObjectHolder.DARK_STAIRS_BLOCK.get(), this::dropSelf);
        this.addLootTable(ObjectHolder.DARK_GLASS_BLOCK.get(), this::dropSelf);
    }
}
