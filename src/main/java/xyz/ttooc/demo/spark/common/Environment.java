package xyz.ttooc.demo.spark.common;

import org.apache.spark.sql.SparkSession;

public class Environment {
    private static ThreadLocal<SparkSession> sparkSessionThreadLocal = new ThreadLocal<>();

    public void put(SparkSession sparkSession) {
        sparkSessionThreadLocal.set(sparkSession);
    }

    public SparkSession take() {
        return sparkSessionThreadLocal.get();
    }

    public void clear() {
        sparkSessionThreadLocal.remove();
    }
}
