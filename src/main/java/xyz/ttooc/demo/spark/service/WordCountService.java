package xyz.ttooc.demo.spark.service;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.Tuple2;
import xyz.ttooc.demo.spark.common.AbstractService;
import xyz.ttooc.demo.spark.dao.WordCountDAO;

import java.util.Arrays;

public class WordCountService extends AbstractService {
    private WordCountDAO wordCountDAO = new WordCountDAO();

    @Override
    public void dataAnalysis() {
        JavaRDD<String> rdd = wordCountDAO.textFile("datas/test.txt");
        JavaPairRDD<String, Long> reduceRdd = rdd
                .flatMap(s -> Arrays.asList(s.split(" ")).iterator())
                .mapToPair(s -> new Tuple2<>(s, 1L))
                .reduceByKey((v1, v2) -> v1 + v2);

        reduceRdd.foreach(t -> {
            Logger log = LoggerFactory.getLogger("WordCountService");
            log.info("{} - > {}", t._1, t._2);
        });
    }
}
