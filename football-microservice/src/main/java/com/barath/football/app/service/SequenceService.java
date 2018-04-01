package com.barath.football.app.service;

import com.barath.football.app.repository.SequenceRepository;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * Created by barath on 18/03/18.
 */
@Service
public class SequenceService implements SequenceRepository{

    private static final String OBJECT_KEY_MAPPER="_id";


    protected ReactiveMongoOperations reactiveMongoOperations;

    public SequenceService(ReactiveMongoOperations reactiveMongoOperations) {
        this.reactiveMongoOperations = reactiveMongoOperations;
    }

    @Override
    public Long getNextSequenceId(String key) {

        Query query = new Query(Criteria.where(OBJECT_KEY_MAPPER).is(key));

        Update update = new Update();
        update.inc("seq", 1);

        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);


        reactiveMongoOperations.findAndModify(query, update, options, Object.class);

        return null;
    }
}
