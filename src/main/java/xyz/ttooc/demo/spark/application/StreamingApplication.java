package xyz.ttooc.demo.spark.application;

import org.apache.spark.sql.SparkSession;
import xyz.ttooc.demo.spark.common.AbstractController;
import xyz.ttooc.demo.spark.common.Environment;

public class StreamingApplication {

    public static void streamingApplication(AbstractController controller) {
        Environment environment = new Environment();
        SparkSession sparkSession = SparkSession
                .builder()
                .config("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
                .config("spark.kryo.registrator", "xyz.ttooc.demo.spark.common.KryoRegistrator")
                .config("spark.cassandra.connection.host", null)
                .config("spark.sql.crossJoin.enabled", "true")
                .appName("streaming-" + controller.getClass().getName())
                .getOrCreate();
        environment.put(sparkSession);

        controller.dispatch();

        sparkSession.stop();
        environment.clear();
    }
}
