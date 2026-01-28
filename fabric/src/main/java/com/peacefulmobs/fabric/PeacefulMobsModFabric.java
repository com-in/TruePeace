package com.peacefulmobs.fabric;

import com.peacefulmobs.PeacefulMobsMod;
import com.peacefulmobs.core.features.MobSpawningManager;
import com.peacefulmobs.core.features.MobAggressionManager;
import com.peacefulmobs.core.features.TradingSystemManager;
import com.peacefulmobs.core.features.AchievementManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.player.PlayerInteractEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;

public class PeacefulMobsModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // 初始化共享核心
        PeacefulMobsMod.init();
        
        // 注册事件监听器
        registerEventListeners();
        
        // 注册怪物生成
        registerMobSpawns();
        
        // 注册交易系统
        registerTradingSystem();
        
        // 注册成就系统
        registerAchievements();
    }
    
    private void registerEventListeners() {
        // 注册服务器生命周期事件
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            System.out.println("Server starting - registering Peaceful Mobs Mod features");
        });
        
        // 注册玩家交互事件
        PlayerInteractEvents.ENTITY_RIGHT_CLICK.register((player, world, hand, entity, hitResult) -> {
            // 处理玩家与怪物的交互
            MobSpawningListener.handleEntityInteract(player, world, hand, entity, hitResult);
            TradingSystemListener.handleEntityInteract(player, world, hand, entity, hitResult);
        });
        
        // 注册实体事件
        ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
            // 处理实体加载事件
            MobAggressionListener.handleEntityLoad(entity, world);
        });
        
        // 注册怪物生成监听器
        MobSpawningListener.registerMobSpawns();
        
        // 注册怪物仇恨监听器
        MobAggressionListener.registerEventListeners();
        
        // 注册成就监听器
        AchievementListener.registerEventListeners();
        
        System.out.println("Registered event listeners for Fabric");
    }
    
    private void registerMobSpawns() {
        // 启用和平模式下的怪物生成
        MobSpawningManager.enablePeacefulMobSpawning();
        System.out.println("Registered mob spawns for Fabric");
    }
    
    private void registerTradingSystem() {
        // 注册交易系统
        System.out.println("Registered trading system for Fabric");
    }
    
    private void registerAchievements() {
        // 注册成就系统
        AchievementManager.registerAchievements();
        System.out.println("Registered achievements for Fabric");
    }
}
