/**
 * @author Aleksey Terzi
 *
 */

package com.lishid.orebfuscator.nms.v1_8_R3;

import com.lishid.orebfuscator.nms.IBlockInfo;

import net.minecraft.server.v1_8_R3.Block;
import net.minecraft.server.v1_8_R3.IBlockData;

public class BlockInfo implements IBlockInfo {

	private final int x;
	private final int y;
	private final int z;
	private final IBlockData blockData;

	public BlockInfo(int x, int y, int z, IBlockData blockData) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.blockData = blockData;
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public int getZ() {
		return this.z;
	}

	@Override
	public int getCombinedId() {
		Block block = this.blockData.getBlock();
		return Block.getId(block) << 4 | block.toLegacyData(this.blockData);
	}

	public IBlockData getBlockData() {
		return this.blockData;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof BlockInfo)) {
			return false;
		}
		BlockInfo object = (BlockInfo) other;

		return this.x == object.x && this.y == object.y && this.z == object.z;
	}

	@Override
	public int hashCode() {
		return this.x ^ this.y ^ this.z;
	}

	@Override
	public String toString() {
		return this.x + " " + this.y + " " + this.z;
	}
}