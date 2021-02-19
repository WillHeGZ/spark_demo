package xyz.ttooc.demo.spark.controller;

import xyz.ttooc.demo.spark.common.AbstractController;
import xyz.ttooc.demo.spark.service.WordCount2Service;

public class WordCount2Controller extends AbstractController {
    private WordCount2Service wordCountService = new WordCount2Service();

    @Override
    public void dispatch() {
        wordCountService.dataAnalysis();
    }
}
