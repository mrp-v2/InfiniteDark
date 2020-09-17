package mrp_v2.infinitedark.datagen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import mrp_v2.infinitedark.InfiniteDark;
import mrp_v2.infinitedark.util.ObjectHolder;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LootTableGenerator extends LootTableProvider
{
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>>
            lootTables = ImmutableList.of(Pair.of(LootTables::new, LootParameterSets.BLOCK));

    public LootTableGenerator(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables()
    {
        return lootTables;
    }

    @Override protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker)
    {
        map.forEach(
                (resourceLocation, lootTable) -> LootTableManager.func_227508_a_(validationtracker, resourceLocation,
                        lootTable));
    }

    @Override public String getName()
    {
        return super.getName() + ": " + InfiniteDark.ID;
    }

    private static class LootTables extends BlockLootTables
    {
        private final ArrayList<Block> knownBlocks;

        public LootTables()
        {
            this.knownBlocks = new ArrayList<>();
            this.knownBlocks.add(ObjectHolder.DARK_BLOCK);
        }

        @Override protected void addTables()
        {
            for (Block knownBlock : this.knownBlocks)
            {
                this.registerDropSelfLootTable(knownBlock);
            }
        }

        @Override protected Iterable<Block> getKnownBlocks()
        {
            return this.knownBlocks;
        }
    }
}
