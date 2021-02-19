package xyz.ttooc.demo.spark.common;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDAO {
    public JavaRDD<String> textFile(String path) {
        Environment environment = new Environment();
        SparkSession sparkSession = environment.get();
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkSession.sparkContext());
        JavaRDD<String> stringJavaRDD = javaSparkContext.textFile(path);
        return stringJavaRDD;
    }

    public static Dataset<Row> getJDBCTable(String dbUrl, String username, String password, String table) {
        Environment environment = new Environment();
        SparkSession sparkSession = environment.get();

        Map configMap = new HashMap();
        configMap.put("url", dbUrl);
        configMap.put("user", username);
        configMap.put("password", password);
        configMap.put("dbtable", table);

        return sparkSession.sqlContext().read().format("jdbc").options(configMap).load();
    }
}
