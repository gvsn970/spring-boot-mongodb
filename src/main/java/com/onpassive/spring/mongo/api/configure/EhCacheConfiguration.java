/*
 * package com.onpassive.spring.mongo.api.configure;
 * 
 * import org.springframework.cache.CacheManager; import
 * org.springframework.cache.annotation.EnableCaching; import
 * org.springframework.cache.ehcache.EhCacheCacheManager; import
 * org.springframework.cache.ehcache.EhCacheManagerFactoryBean; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.core.io.ClassPathResource; import
 * org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
 * 
 * @EnableMongoRepositories(basePackages = "com.onpassive.spring.mongo.api")
 * 
 * @EnableCaching
 * 
 * @Configuration public class EhCacheConfiguration {
 * 
 * @Bean public CacheManager cacheManager() { return new
 * EhCacheCacheManager(cacheMangerFactory().getObject()); }
 * 
 * @Bean public EhCacheManagerFactoryBean cacheMangerFactory() {
 * EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
 * bean.setConfigLocation(new ClassPathResource("ehcache.xml"));
 * bean.setShared(true); return bean; } }
 */