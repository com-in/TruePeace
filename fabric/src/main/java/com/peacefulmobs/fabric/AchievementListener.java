package com.peacefulmobs.fabric;

import com.peacefulmobs.core.features.AchievementManager;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;

public class AchievementListener {
    public static void registerEventListeners() {
        // 注册实体伤害事件
        ServerLivingEntityEvents.HURT.register((entity, source, amount) -> {
            // 检查伤害来源是否是玩家
            if (source.getAttacker() != null && source.getAttacker().getType().getRegistryName().toString().equals("minecraft:player")) {
                // 检查被攻击的是否是怪物
                if (entity != null && entity.getType().getRegistryName().toString().startsWith("minecraft:")) {
                    // 检查是否是和平模式
                    boolean isPeacefulMode = entity.getWorld().getDifficulty().getId() == 0;
                    // 授予玩家"叛徒"成就，只有在和平模式下才会授予
                    AchievementManager.grantTraitorAchievement(source.getAttacker(), isPeacefulMode);
                    if (isPeacefulMode) {
                        System.out.println("Granted traitor achievement to player for attacking " + entity.getType().getRegistryName() + " in peaceful mode");
                    }
                }
            }
        });
    }
    
    // 可以添加其他与成就相关的方法
}
