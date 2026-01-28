package com.peacefulmobs.forge;

import com.peacefulmobs.core.features.AchievementManager;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class AchievementListener {
    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        // 检查伤害来源是否是玩家
        if (event.getSource().getEntity() != null && event.getSource().getEntity().getType().getRegistryName().toString().equals("minecraft:player")) {
            // 检查被攻击的是否是怪物
            if (event.getEntityLiving() != null && event.getEntityLiving().getType().getRegistryName().toString().startsWith("minecraft:")) {
                // 检查是否是和平模式
                boolean isPeacefulMode = event.getEntityLiving().level.getDifficulty().getId() == 0;
                // 授予玩家"叛徒"成就，只有在和平模式下才会授予
                AchievementManager.grantTraitorAchievement(event.getSource().getEntity(), isPeacefulMode);
                if (isPeacefulMode) {
                    System.out.println("Granted traitor achievement to player for attacking " + event.getEntityLiving().getType().getRegistryName() + " in peaceful mode");
                }
            }
        }
    }
    
    // 可以添加其他与成就相关的事件监听器
}
