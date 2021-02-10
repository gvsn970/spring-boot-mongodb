package com.onpassive.spring.mongo.api.configure;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;

@Configuration
public class HazelCastCacheConfig {

	@Bean
	public Config configure() {
		return new Config().setInstanceName("hazlecast-insatnce")
				.addMapConfig(new MapConfig().setName("userCache")
						.setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
						.setEvictionPolicy(EvictionPolicy.LRU).setTimeToLiveSeconds(2000));
	}
}
