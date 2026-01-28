package com.peacefulmobs.forge;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class MobSpawningListener {
    @SubscribeEvent
    public void onBiomeLoading(BiomeLoadingEvent event) {
        // 修改生物群系的怪物生成设置
        // 确保和平模式下怪物能够生成
        System.out.println("Modifying biome spawning for " + event.getName());
        
        // 这里可以修改生物群系的怪物生成配置
        // 例如，添加或修改怪物生成条目
    }
    
    // 可以添加其他与怪物生成相关的事件监听器
}
