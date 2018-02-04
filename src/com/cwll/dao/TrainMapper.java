package com.cwll.dao;

import com.cwll.model.Train;

import java.util.List;

/**
 * Created by cwll on 2018/1/26.
 */
public interface TrainMapper {
    List<Train> findTrains();

    boolean addTrain(Train train);

//    void arrangeTrain(Train train);
}
