package com.sainttx.holograms.nms.v1_9_R1;

import com.sainttx.holograms.api.entity.Nameable;
import com.sainttx.holograms.api.line.HologramLine;
import net.minecraft.server.v1_9_R1.AxisAlignedBB;
import net.minecraft.server.v1_9_R1.DamageSource;
import net.minecraft.server.v1_9_R1.EntityArmorStand;
import net.minecraft.server.v1_9_R1.EntityHuman;
import net.minecraft.server.v1_9_R1.EntityPlayer;
import net.minecraft.server.v1_9_R1.EnumHand;
import net.minecraft.server.v1_9_R1.EnumInteractionResult;
import net.minecraft.server.v1_9_R1.EnumItemSlot;
import net.minecraft.server.v1_9_R1.ItemStack;
import net.minecraft.server.v1_9_R1.NBTTagCompound;
import net.minecraft.server.v1_9_R1.PacketPlayOutEntityTeleport;
import net.minecraft.server.v1_9_R1.SoundEffect;
import net.minecraft.server.v1_9_R1.Vec3D;
import net.minecraft.server.v1_9_R1.World;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftEntity;

public class EntityNameable extends EntityArmorStand implements Nameable {

    private boolean lockTick;
    private HologramLine parentPiece;

    public EntityNameable(World world, HologramLine parentPiece) {
        super(world);
        super.collides = false;
        setInvisible(true);
        setSmall(true);
        setArms(false);
        setGravity(true);
        setBasePlate(true);
        setMarker(true);
        this.parentPiece = parentPiece;
    }

    public void setLockTick(boolean lock) {
        lockTick = lock;
    }

    @Override
    public void setName(String text) {
        super.setCustomName(text);
        super.setCustomNameVisible(!text.isEmpty());
    }

    @Override
    public String getName() {
        return super.getCustomName();
    }

    @Override
    public void remove() {
        this.dead = true;
    }

    @Override
    public void setPosition(double x, double y, double z) {
        super.setPosition(x, y, z);
    }

    @Override
    public HologramLine getHologramLine() {
        return parentPiece;
    }

    // Overriden NMS methods

    @Override
    public void a(NBTTagCompound nbttagcompound) {

    }

    @Override
    public void b(NBTTagCompound nbttagcompound) {

    }

    @Override
    public boolean c(NBTTagCompound nbttagcompound) {
        return false;
    }

    @Override
    public boolean d(NBTTagCompound nbttagcompound) {
        return false;
    }

    @Override
    public void e(NBTTagCompound nbttagcompound) {

    }

    @Override
    public void f(NBTTagCompound nbttagcompound) {

    }

    @Override
    public boolean isInvulnerable(DamageSource source) {
        return true;
    }

    @Override
    public void setCustomName(String name) {

    }

    @Override
    public void setCustomNameVisible(boolean visible) {

    }

    @Override
    public EnumInteractionResult a(EntityHuman entityhuman, Vec3D vec3d, ItemStack itemstack, EnumHand enumhand) {
        return EnumInteractionResult.FAIL;
    }

    @Override
    public boolean c(int i, ItemStack item) {
        return false;
    }

    @Override
    public void a(AxisAlignedBB boundingBox) {

    }

    @Override
    public void m() {
        if (!lockTick) {
            super.m();
        }
    }

    @Override
    public void a(SoundEffect soundeffect, float f, float f1) {

    }

    @Override
    public boolean isCollidable() {
        return false;
    }

    @Override
    public void setInvisible(boolean flag) {
        super.setInvisible(true);
    }

    @Override
    public void setSlot(EnumItemSlot enumitemslot, ItemStack itemstack) {

    }

    @Override
    public void Q() {

    }

    @Override
    public boolean damageEntity(DamageSource damagesource, float f) {
        return false;
    }

    @Override
    public void die() {

    }

    @Override
    public CraftEntity getBukkitEntity() {
        if (super.bukkitEntity == null) {
            this.bukkitEntity = new CraftNameable(this.world.getServer(), this);
        }
        return this.bukkitEntity;
    }
}
