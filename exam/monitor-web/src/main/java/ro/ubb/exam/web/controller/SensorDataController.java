package ro.ubb.exam.web.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.exam.core.model.SensorData;
import ro.ubb.exam.core.service.SensorDataService;
import ro.ubb.exam.web.converter.SensorDataConverter;
import ro.ubb.exam.web.dto.SensorsDataDto;

import java.util.List;


@RestController
public class SensorDataController {
    @Autowired
    private SensorDataService sensorDataService;

    @Autowired
    private SensorDataConverter sensorDataConverter;


    @RequestMapping(value = "/sensorData")
     SensorsDataDto getAllSensorData(){
        var result = new SensorsDataDto(sensorDataConverter.convertModelsToDtos(sensorDataService.getAllSensorData()));
        return result;
    }

    @RequestMapping(value = "/sensorData/getMostRecent4/{name}", method = RequestMethod.GET)
    SensorsDataDto getMostRecent4(@PathVariable String name){

        var result = new SensorsDataDto(
                sensorDataConverter.convertModelsToDtos(sensorDataService.getMostRecent4(name))
        );

        return result;
    }

    @RequestMapping(value = "/sensorData/names")
    List<String> getSensorNames(){
        return sensorDataService.getSensorNames();
    }



}
