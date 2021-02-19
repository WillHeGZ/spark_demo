package xyz.ttooc.demo.spark.common;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

public abstract class AbstractDAO {
    public JavaRDD<String> textFile(String path) {
        Environment environment = new Environment();
        SparkSession sparkSession = environment.take();
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkSession.sparkContext());
        JavaRDD<String> stringJavaRDD = javaSparkContext.textFile(path);
        return stringJavaRDD;
    }
}
