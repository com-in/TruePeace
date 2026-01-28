package com.peacefulmobs.forge;

import com.peacefulmobs.core.features.MobAggressionManager;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MobAggressionListener {
    @SubscribeEvent
    public void onLivingSetAttackTarget(LivingSetAttackTargetEvent event) {
        // 检查目标是否是玩家
        if (event.getTarget() != null && event.getTarget().getType().getRegistryName().toString().equals("minecraft:player")) {
            // 取消怪物对玩家的攻击目标
            event.setCanceled(true);
            System.out.println("Canceled mob attack on player: " + event.getEntityLiving().getType().getRegistryName());
        }
    }
    
    // 可以添加其他与怪物仇恨相关的事件监听器
}
