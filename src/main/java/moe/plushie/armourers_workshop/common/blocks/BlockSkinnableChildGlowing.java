package moe.plushie.armourers_workshop.common.blocks;

import moe.plushie.armourers_workshop.common.lib.LibBlockNames;
import moe.plushie.armourers_workshop.common.permission.IPermissionHolder;
import moe.plushie.armourers_workshop.common.tileentities.TileEntitySkinnableChild;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSkinnableChildGlowing extends BlockSkinnableChild {

    public BlockSkinnableChildGlowing() {
        super(LibBlockNames.SKINNABLE_CHILD_GLOWING);
        this.setLightLevel(1.0F);
    }
    
    @Override
    public TileEntity createNewTileEntity(World world, int p_149915_2_) {
        return new TileEntitySkinnableChild();
    }
    
    @Override
    public String getPermissionName() {
        return ((IPermissionHolder)ModBlocks.skinnable).getPermissionName();
    }
}
