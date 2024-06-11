package net.kubia.minecraftmod.entity.custom;

import net.kubia.minecraftmod.entity.ai.JohnnySinsAttackGoal;
import net.kubia.minecraftmod.entity.client.JohnnySins;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class JohnnySinsEntity extends Monster {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(JohnnySinsEntity.class, EntityDataSerializers.BOOLEAN);
    public JohnnySinsEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    public int idleAnimationTimeout = 0;    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;


    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            setupAnimationStates();
        }
    }

        private void setupAnimationStates() {
            if(this.walkAnimation.isMoving()) {
                this.idleAnimationState.stop();
            }
            if (this.idleAnimationTimeout <= 0) {
                this.idleAnimationTimeout = this.random.nextInt(40) + 80;
                this.idleAnimationState.start(this.tickCount);

            } else {
              --this.idleAnimationTimeout;
            }

            if(this.isAttacking() && attackAnimationTimeout <= 0) {
                attackAnimationTimeout = 9; //Length in ticks of animation
            attackAnimationState.start(this.tickCount);
            } else {
                --this.attackAnimationTimeout;
            }


            if (!this.isAttacking()) {
                attackAnimationState.stop();
            }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0f;
        }
        this.walkAnimation.update(f, 0.2f);
    }


            public void setAttacking(boolean attacking) {
                this.entityData.set(ATTACKING, attacking);
            }

            public boolean isAttacking() {
                return this.entityData.get(ATTACKING);
            }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new JohnnySinsAttackGoal(this, 1, true));
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(0, new WaterAvoidingRandomStrollGoal(this, 0.1f));
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.ATTACK_KNOCKBACK, 1)
                .add(Attributes.FOLLOW_RANGE, 35.0)
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.ATTACK_DAMAGE, 3.0)
                .add(Attributes.ARMOR, 2.0)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);



    }
        protected SoundEvent getAmbientSound () {
        return SoundEvents.ZOMBIE_AMBIENT;
    }
        protected SoundEvent getHurtSound (DamageSource pDamageSource){
        return SoundEvents.ZOMBIE_HURT;
    }
        protected SoundEvent getDeathSound () {
        return SoundEvents.ZOMBIE_DEATH;
    }
}

