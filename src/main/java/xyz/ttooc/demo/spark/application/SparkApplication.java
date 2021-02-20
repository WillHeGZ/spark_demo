package xyz.ttooc.demo.spark.application;

import xyz.ttooc.demo.spark.common.AbstractController;
import xyz.ttooc.demo.spark.exception.SparkException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Author Will He
 * @Date 2021/2/18 14:32
 * @Description
 **/
public class SparkApplication {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String applicationControllerPath = Optional.ofNullable(args[0]).orElseThrow(() -> new SparkException("arg[0] must be not null")).trim();
        String applicationType = Optional.ofNullable(args[1]).orElseThrow(() -> new SparkException("arg[1] must be not null")).trim();

        List<String> applicationList = Arrays.asList("BATCH", "STREAMING");
        if (!applicationList.contains(applicationType)) {
            throw new SparkException("arg[1] must be BATCH or STREAMING");
        }

        Class<?> aClass = Class.forName(applicationControllerPath);
        BatchApplication.batchApplication((AbstractController) aClass.newInstance());
    }
}
