package com.barath.football.app.repository;

/**
 * Created by barath on 18/03/18.
 */
public interface SequenceRepository {

    Long getNextSequenceId(String key);

}
