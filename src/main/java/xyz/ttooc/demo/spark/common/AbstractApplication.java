package xyz.ttooc.demo.spark.common;

import org.apache.spark.sql.SparkSession;

public class AbstractApplication {

    public static void batchApplication(AbstractController controller) {
        Environment environment = new Environment();
        SparkSession sparkSession = SparkSession
                .builder()
                .config("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
                .config("spark.kryo.registrator", "xyz.ttooc.demo.spark.common.KryoRegistrator")
//                .config("spark.cassandra.connection.host", PropertiesUtil.getPropery("cassandra.host"))
                .config("spark.sql.crossJoin.enabled", "true")
                .getOrCreate();
        environment.put(sparkSession);

        controller.dispatch();

        sparkSession.stop();
        environment.clear();
    }
}
