package com.peacefulmobs.fabric;

import com.peacefulmobs.core.features.MobAggressionManager;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;

public class MobAggressionListener {
    public static void registerEventListeners() {
        // 注册实体战斗事件
        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((world, entity, killedEntity) -> {
            // 处理实体杀死其他实体的事件
        });
        
        // 这里可以添加其他与怪物仇恨相关的事件监听器
    }
    
    public static void handleEntityLoad(Object entity, Object world) {
        // 处理实体加载事件
        // 这里可以添加怪物仇恨系统的初始化逻辑
        System.out.println("Handling entity load for " + entity.getClass().getSimpleName());
    }
    
    public static boolean shouldAttackPlayer(Object mob, Object player) {
        // 检查怪物是否应该攻击玩家
        // 在和平模式下，返回false
        return MobAggressionManager.shouldAttackPlayer(mob, player);
    }
}
