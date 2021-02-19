package xyz.ttooc.demo.spark.controller;

import xyz.ttooc.demo.spark.common.AbstractController;
import xyz.ttooc.demo.spark.service.WordCountService;

public class WordCountController extends AbstractController {
    private WordCountService wordCountService = new WordCountService();

    @Override
    public void dispatch() {
        wordCountService.dataAnalysis();
    }
}
