package com.fheebiy.common;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.KestrelCommandFactory;
import net.rubyeye.xmemcached.impl.RandomMemcachedSessionLocaltor;
import net.rubyeye.xmemcached.utils.AddrUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * Created by bob zhou on 14-6-12.
 */
public class KestrelUtil {

    static String server;

    static int poolSize;

    static int timeout;

    private static MemcachedClient memcachedClient;
    static {
        server = Config.getProperty("kestrel.server.host");
        poolSize = Integer.parseInt(Config.getProperty("kestrel.connectionPoolSize"));
        timeout = Integer.parseInt(Config.getProperty("kestrel.ConnectTimeout"));

        MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses(server),new int[]{1});
        builder.setCommandFactory(new KestrelCommandFactory());
        builder.setSessionLocator(new RandomMemcachedSessionLocaltor());
        builder.setConnectionPoolSize(poolSize);
        builder.setConnectTimeout(timeout);
        try {
            memcachedClient = builder.build();
            memcachedClient.setPrimitiveAsString(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void send(String qname, Object obj){
        try {
            memcachedClient.set(qname, 0, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String receive(String qname) {
        try {
            return memcachedClient.get(qname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
