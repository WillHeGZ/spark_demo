package xyz.ttooc.demo.spark.application;

import xyz.ttooc.demo.spark.common.AbstractApplication;
import xyz.ttooc.demo.spark.common.AbstractController;
import xyz.ttooc.demo.spark.exception.SparkException;

import java.util.Optional;

/**
 * @Author Will He
 * @Date 2021/2/18 14:32
 * @Description
 **/
public class SparkBatchApplication {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String applicationControllerPath = Optional.ofNullable(args[0]).orElseThrow(() -> new SparkException("arg[0] must be not null")).trim();
        Class<?> aClass = Class.forName(applicationControllerPath);
        AbstractApplication.batchApplication((AbstractController) aClass.newInstance());
    }
}
