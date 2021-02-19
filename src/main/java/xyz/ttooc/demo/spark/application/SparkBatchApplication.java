package xyz.ttooc.demo.spark.application;

import xyz.ttooc.demo.spark.common.AbstractController;

/**
 * @Author Will He
 * @Date 2021/2/18 14:32
 * @Description
 **/
public class SparkBatchApplication {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("xyz.ttooc.demo.spark.controller.WordCountController");
        AbstractApplication.batchApplication((AbstractController) aClass.newInstance());
    }
}
