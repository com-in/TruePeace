package com.peacefulmobs.forge;

import com.peacefulmobs.PeacefulMobsMod;
import com.peacefulmobs.core.features.MobSpawningManager;
import com.peacefulmobs.core.features.MobAggressionManager;
import com.peacefulmobs.core.features.TradingSystemManager;
import com.peacefulmobs.core.features.AchievementManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PeacefulMobsMod.MOD_ID)
public class PeacefulMobsModForge {
    public PeacefulMobsModForge() {
        // 初始化共享核心
        PeacefulMobsMod.init();
        
        // 获取事件总线
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
        
        // 注册事件监听器
        registerEventListeners(modEventBus, forgeEventBus);
        
        // 注册怪物生成
        registerMobSpawns();
        
        // 注册交易系统
        registerTradingSystem();
        
        // 注册成就系统
        registerAchievements();
    }
    
    private void registerEventListeners(IEventBus modEventBus, IEventBus forgeEventBus) {
        // 注册模组事件监听器
        modEventBus.register(this);
        
        // 注册Forge事件监听器
        forgeEventBus.register(new MobSpawningListener());
        forgeEventBus.register(new MobAggressionListener());
        forgeEventBus.register(new TradingSystemListener());
        forgeEventBus.register(new AchievementListener());
        
        System.out.println("Registered event listeners for Forge");
    }
    
    private void registerMobSpawns() {
        // 启用和平模式下的怪物生成
        MobSpawningManager.enablePeacefulMobSpawning();
        System.out.println("Registered mob spawns for Forge");
    }
    
    private void registerTradingSystem() {
        // 注册交易系统
        System.out.println("Registered trading system for Forge");
    }
    
    private void registerAchievements() {
        // 注册成就系统
        AchievementManager.registerAchievements();
        System.out.println("Registered achievements for Forge");
    }
}
