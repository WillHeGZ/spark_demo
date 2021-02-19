package xyz.ttooc.demo.spark.application;

import org.apache.spark.sql.SparkSession;
import xyz.ttooc.demo.spark.common.AbstractController;
import xyz.ttooc.demo.spark.common.Environment;

public class AbstractApplication {

    public static void batchApplication(AbstractController controller) {
        SparkSession sparkSession = SparkSession
                .builder()
                .config("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
                .config("spark.kryo.registrator", "xyz.ttooc.demo.spark.common.KryoRegistrator")
//                .config("spark.cassandra.connection.host", PropertiesUtil.getPropery("cassandra.host"))
                .config("spark.sql.crossJoin.enabled", "true")
                .master("local[*]")
                .appName(controller.getClass().getName())
                .getOrCreate();
        Environment environment = new Environment();
        environment.put(sparkSession);

        controller.dispatch();

        sparkSession.stop();
        environment.clear();
    }
}
