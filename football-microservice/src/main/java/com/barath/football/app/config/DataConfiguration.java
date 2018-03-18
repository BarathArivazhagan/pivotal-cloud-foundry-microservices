package com.barath.football.app.config;

import com.barath.football.app.document.*;
import com.barath.football.app.service.*;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.lang.invoke.MethodHandles;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by barath on 18/03/18.
 */

@Configuration
public class DataConfiguration {


    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private MatchService matchService;
    private TeamService teamService;
    private RefereeService refereeService;
    private PlayerService playerService;
    private DivisionService divisionService;

    public DataConfiguration(MatchService matchService, TeamService teamService, RefereeService refereeService, PlayerService playerService, DivisionService divisionService) {
        this.matchService = matchService;
        this.teamService = teamService;
        this.refereeService = refereeService;
        this.playerService = playerService;
        this.divisionService = divisionService;
    }

    public List<Match> loadCSVData() throws Exception {

        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        Resource csvResource = new ClassPathResource("football_data.csv");
        MappingIterator<Map<String, String>> it = csvMapper.readerFor(Map.class)
                .with(schema)
                .readValues(csvResource.getFile());

        List<Match> matches = new ArrayList<>();
        while (it.hasNext()) {
            Map<String, String> rowAsMap = it.next();
            if (logger.isDebugEnabled()) logger.debug("Row data {} ", rowAsMap);
            matches.add(buildMatchDocument(rowAsMap));
        }

        matches.forEach( m -> logger.info( "match document ==> {}",m));
        return matches;
    }


    public Match buildMatchDocument(Map<String,String> rowData){

        Division division = new Division(1L,rowData.get(CSVKEYS.DIV.toString()));
        Team homeTeam = new Team(1L,rowData.get(CSVKEYS.HOMETEAM.toString()));
        Team awayTeam = new Team(1L,rowData.get(CSVKEYS.AWAYTEAM.toString()));
        Referee referee = new Referee(1L, rowData.get(CSVKEYS.REFEREE.toString()));
        Goal goal = new Goal(parseInt(rowData.get(CSVKEYS.FTHG.name())),
                parseInt(rowData.get(CSVKEYS.FTAG.name())), parseInt(rowData.get(CSVKEYS.HTHG.name())),
                parseInt(rowData.get(CSVKEYS.HTAG.name())));
        Shot shot = new Shot(parseInt(rowData.get(CSVKEYS.HS.name())),
                parseInt(rowData.get(CSVKEYS.AS.name())), parseInt(rowData.get(CSVKEYS.HST.name())),
                parseInt(rowData.get(CSVKEYS.AST.name())));
        Card redCards = new Card(Card.CardType.RED,parseInt(rowData.get(CSVKEYS.HR.name())),parseInt(rowData.get(CSVKEYS.AR.name())));
        Card yellowCards = new Card(Card.CardType.RED,parseInt(rowData.get(CSVKEYS.HY.name())),parseInt(rowData.get(CSVKEYS.AY.name())));
        Match match = new Match(1L, dateFormatConversion(rowData.get(CSVKEYS.DATE.toString())),division,
                 homeTeam,awayTeam,referee,goal,resolveMatchResult(rowData.get(CSVKEYS.FTR.name())),shot, Arrays.asList(redCards,yellowCards)
                );

        return match;
    }

    @PostConstruct
    public void populateData() throws Exception{
        loadCSVData().stream().forEach( match -> {

            matchService.saveMatchReportCard(Mono.just(match));

        });

    }

    protected int parseInt(String param){

        return Integer.parseInt(param);
    }

    protected Date dateFormatConversion(String date){

        try {
            return df.parse(date);
        }catch (ParseException exception){
            logger.error(" Error =====> in parsing the date {}", date);
        }
        return new Date();
    }

    protected String resolveMatchResult(String matchResult){

        switch (matchResult){

            case "D" : return MatchResult.DRAW.name();
            case "A" : return MatchResult.AWAY.name();
            case "H" : return MatchResult.HOME.name();

            default: return MatchResult.NORESULT.name();

        }
    }
}


enum CSVKEYS {
    DIV("Div"),
    DATE("Date"),HOMETEAM("HomeTeam"),
    AWAYTEAM("AwayTeam"),
    FTHG("FTHG"),FTAG("FTAG"),
    FTR("FTR"),HTHG("HTHG"),HTAG("HTAG"),HTR("HTR"),
    REFEREE("Referee"),
    HS("HS"),AS("AS"),HST("HST"),AST("AST"),HF("HF"),AF("AF"),HC("HC"),AC("AC"),
    HY("HY"),AY("AY"),HR("HR"),AR("AR");

    private final String name;

    private CSVKEYS(String s) {
        name = s;
    }


    public String toString() {
        return this.name;
    }

}

enum  MatchResult{
    DRAW,HOME,AWAY,NORESULT
}