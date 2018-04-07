package com.barath.football.app;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.lang.invoke.MethodHandles;
import java.util.Map;

/**
 * Created by barath on 18/03/18.
 */
public class CSVTestUtils {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Test
    public void loadCSVDataTest() throws Exception{

        CsvMapper csvMapper=new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        Resource csvResource= new ClassPathResource("football_data.csv");
        MappingIterator<Map<String,String>> it = csvMapper.readerFor(Map.class)
                .with(schema)
                .readValues(csvResource.getFile());

         while (it.hasNext()){
             Map<String,String> rowAsMap = it.next();
             logger.info("Row data {} ",rowAsMap);

         }
    }
}
